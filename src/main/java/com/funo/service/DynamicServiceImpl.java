package com.funo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.funo.DataType;
import com.funo.GroupType;
import com.funo.Utils;
import com.funo.constant.DemoContants;
import com.funo.constant.DynamicConstants;
import com.funo.service.config.IConfigService;
import com.funo.vo.BaseZXT;
import com.funo.vo.BaseZXTs;
import com.funo.vo.DynamicInfo;
import com.funo.vo.DynamicInfos;
import com.funo.vo.config.CenterConfig;
import com.funo.vo.config.ChannelConfig;
import com.funo.vo.config.MainApiConfig;
import com.funo.vo.config.MicroServiceConfig;
import com.funo.vo.front.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DynamicServiceImpl implements IDynamicService {
	public static Logger log = LoggerFactory.getLogger(DynamicServiceImpl.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private IConfigService configService;

	/**
	 * 动态折线图构造方法
	 * 描述
	 * @author linkun
	 * @created 2019年9月23日 下午9:09:34
	 * @param str		折线图参数
	 * @param title		折线图title
	 * @return
	 * @throws Exception
	 * @see com.funo.service.IDynamicService#zxt(String, String)
	 */
	@Override
	public BaseZXTs zxt(String str, String title) throws Exception {
		DynamicInfos infos = JSON.parseObject(str, DynamicInfos.class);
		
		List<BaseZXT> datas = new ArrayList<>();
		Set<String> keys = new HashSet<>();
		for(DynamicInfo info:infos.getDatas()) {
			String listStr = redisTemplate.opsForValue().get(info.getModule()+"_"+ DynamicConstants.LIST);
			if(StringUtils.isEmpty(listStr)) {
				return null;
			}else {
				Map<String,Number> listMap = JSON.parseObject(listStr, HashMap.class);
				keys.addAll(listMap.keySet().stream().sorted(Comparator.reverseOrder())
						.filter(key-> Integer.parseInt(key.split("_")[1].split(":")[1])%(infos.getTimeLen()==null?1:infos.getTimeLen()) == 0)
						.limit(infos.getCount())
						.sorted().collect(Collectors.toSet()));
			}
		}
		
		List<String> rightKeys = keys.stream().sorted(Comparator.reverseOrder()).limit(infos.getCount()).sorted().collect(Collectors.toList());
		String[] times = new String[rightKeys.size()];
		rightKeys.stream().map(key-> key.substring(key.indexOf("_")+1)).collect(Collectors.toList()).toArray(times);

		
		for(DynamicInfo info:infos.getDatas()) {
			String listStr = redisTemplate.opsForValue().get(info.getModule()+"_"+DynamicConstants.LIST);
			if(StringUtils.isEmpty(listStr)) {
				return null;
			}else {
				Map<String,Number> valueMap = JSON.parseObject(listStr, HashMap.class);
				Number[] vs = new Number[infos.getCount()];
				for(int i =0;i < rightKeys.size();i++) {
					String rightKey = rightKeys.get(i);
					vs[i] = valueMap.get(rightKey);
				}
				BaseZXT zxt = new BaseZXT(info.getDataTitle(), vs);
				zxt.setType(info.getType());
				zxt.setyAxisIndex(info.getyAxisIndex());
				zxt.setMin(info.getMin());
				zxt.setMax(info.getMax());
				zxt.setIsAreaStyle(info.getIsAreaStyle());
				datas.add(zxt);
			}
		}
		
		
		BaseZXTs zxts = new BaseZXTs(times, title, infos.getXtitle(), infos.getYtitle(), datas);
		zxts.setYInfos(infos.getYInfos());
		return zxts;
	}
	
	/**
	 * 动态折线图构造方法
	 * 描述
	 * @author linkun
	 * @created 2019年9月23日 下午9:09:34
	 * @param str		折线图参数
	 * @param title		折线图title
	 * @return
	 * @throws Exception
	 * @see com.funo.service.IDynamicService#zxt2(String, String)
	 */
	@Override
	public BaseZXTs zxt2(String str,String title) throws Exception {
		DynamicInfos infos = JSON.parseObject(str, DynamicInfos.class);
		
		List<BaseZXT> datas = new ArrayList<>();
		Set<String> keys = new HashSet<>();
		for(DynamicInfo info:infos.getDatas()) {
			String listStr = redisTemplate.opsForValue().get(info.getModule()+"_"+DynamicConstants.LIST);
			if(StringUtils.isEmpty(listStr)) {
				return null;
			}else {
				Map<String,Number> listMap = JSON.parseObject(listStr, HashMap.class);
				keys.addAll(listMap.keySet().stream().sorted(Comparator.reverseOrder())
						.filter(key-> Integer.parseInt(key.split("_")[1].split(":")[1])%(infos.getTimeLen()==null?1:infos.getTimeLen()) == 0)
						.limit(infos.getCount())
						.sorted().collect(Collectors.toSet()));
			}
		}
		
		List<String> rightKeys = keys.stream().sorted(Comparator.reverseOrder()).limit(infos.getCount()).sorted().collect(Collectors.toList());
		String[] times = new String[rightKeys.size()];
		rightKeys.stream().map(key-> key.substring(key.indexOf("_")+1)).collect(Collectors.toList()).toArray(times);

		
		for(DynamicInfo info:infos.getDatas()) {
			String listStr = redisTemplate.opsForValue().get(info.getModule()+"_"+DynamicConstants.LIST);
			if(StringUtils.isEmpty(listStr)) {
				return null;
			}else {
				Map<String,Object> valueMap = JSON.parseObject(listStr, HashMap.class);
				Number[] vs = new Number[infos.getCount()];
				for(int i =0;i < rightKeys.size();i++) {
					String rightKey = rightKeys.get(i);
					if(valueMap.get(rightKey) == null) {
						vs[i] = null;
					}else {
						if(!StringUtils.isEmpty(info.getField())) {
							vs[i] = (Number) Utils.getValue((JSONObject)valueMap.get(rightKey), info.getField());
						}else {
							vs[i] = (Number)valueMap.get(rightKey);
						}
					}
					
					
				}
				BaseZXT zxt = new BaseZXT(info.getDataTitle(), vs);
				zxt.setType(info.getType());
				zxt.setyAxisIndex(info.getyAxisIndex());
				zxt.setMin(info.getMin());
				zxt.setMax(info.getMax());
				zxt.setIsAreaStyle(info.getIsAreaStyle());
				datas.add(zxt);
			}
		}
		
		
		BaseZXTs zxts = new BaseZXTs(times, title, infos.getXtitle(), infos.getYtitle(), datas);
		zxts.setYInfos(infos.getYInfos());
		zxts.setOther(infos.getOther());
		return zxts;
	}
	
	public static void main(String[] args) {
		String str = "{count:20,timeLen:5,xtitle:'时间'," + 
				"	yInfos:[" + 
				"		{name:'吞吐量(次/分)',position:'left'},\n" + 
				"		{name:'成功率(%)',position:'right',max:'100',min:'90'},\n" + 
				"		{name:'平均时长(ms)',position:'right',offset:'130',isAreaStyle:true}]\n" + 
				"	,datas:[\n" + 
				"		{module:'avgcpu',dataTitle:'吞吐量',type:'bar',yAxisIndex:'0'},\n" + 
				"		{module:'avgcpu2',dataTitle:'成功率',type:'line',yAxisIndex:'1'},\n" + 
				"		{module:'avgcpu3',dataTitle:'平均时长',type:'line',yAxisIndex:'2'}]}";
		DynamicInfos infos = JSON.parseObject(str, DynamicInfos.class);
		System.out.println(JSON.toJSONString(infos));
		
	}

	/**
	 * 获取排序后的数据列表
	 * 描述
	 * @author linkun
	 * @created 2019年11月6日 下午3:29:26
	 * @param redisModuleKey
	 * @return
	 * @throws Exception
	 * @see com.funo.service.IDynamicService#getSortedDatasReverseOrder(String)
	 */
	@Override
	public JSONArray getSortedDatasReverseOrder(String redisModuleKey) throws Exception {
		String str = redisTemplate.opsForValue().get(redisModuleKey+"_"+DynamicConstants.LIST);
		if(StringUtils.isEmpty(str)) {
			return null;
		}
		JSONObject jo = JSONObject.parseObject(str);
		List<String> keys = jo.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		JSONArray joArray = new JSONArray();
		for(String key:keys) {
			joArray.add(jo.getJSONObject(key));
		}
		
		return joArray;
	}

	@Override
	public Map<String, FronCenterMicroserviceApiInfo> getFrontCenterMicroserviceApiInfos() throws Exception {
		
		List<CenterConfig> centers = configService.getAllCenterConfig();
		Map<String,FronCenterMicroserviceApiInfo> centersMap = new HashMap<>();
		
		for(CenterConfig center:centers) {
			FronCenterMicroserviceApiInfo info = new FronCenterMicroserviceApiInfo();
			
			Map<String,List<FrontMicroserviceInfo>> serviceMap = new HashMap<>();
			for(int i = 0;i < center.getMainMicroServices().split(",").length;i++) {
				String serviceName = center.getMainMicroServices().split(",")[i];
				MicroServiceConfig ms = center.getMicroServices().stream().filter(m->m.getName().equals(serviceName)).findFirst().get();
				Integer ininContainerNum = ms.getChannels().stream().mapToInt(c->c.getInitContainerNum()).sum();
				Integer maxContainerNum = ms.getChannels().stream().mapToInt(c->c.getMaxContainerNum()).sum();
				
				String serviceCnName = ms.getCnname();
				try {
					List<FrontMicroserviceInfo> serviceInfos = this.getSortedDatasReverseOrder(Utils.getRedisModuleKey(GroupType.MICROSERVICE,serviceName, DataType.OTHER))
							.toJavaList(FrontMicroserviceInfo.class).stream().limit(2).collect(Collectors.toList());
					serviceInfos.forEach(o->{
						o.setCnname(serviceCnName);
						o.setInitContainerNum(ininContainerNum);
						o.setMaxContainerNum(maxContainerNum);
					});
					serviceMap.put(serviceName, serviceInfos);
				}catch(Exception ex) {
					log.error("获取关键微服务信息出现异常：",ex);
				}
			}
			info.setMicroservices(serviceMap);
			
			
			Map<String,List<FrontApiInfo>> apiMap = new HashMap<>();
			for(MainApiConfig api :center.getMainAPIs()) {
				String mainApiName= api.getName();
				String mainApiCnName = api.getCnname();
				try {
					List<FrontApiInfo> apiInfos = this.getSortedDatasReverseOrder(Utils.getRedisModuleKey(GroupType.API,mainApiName, DataType.BUSINESS))
							.toJavaList(FrontApiInfo.class).stream().limit(2).collect(Collectors.toList());
					apiInfos.forEach(o -> o.setCnname(mainApiCnName));
					apiMap.put(mainApiName, apiInfos);
				}catch(Exception ex) {
					log.error("获取关键api信息出现异常：",ex);
				}
			}
			info.setApis(apiMap);
			
			centersMap.put(center.getName(), info);
		}
		return centersMap;
	}

	@Override
	public List<List<FrontCenterInfo>> getFrontCenterInfos() throws Exception {
		List<List<FrontCenterInfo>> centerInfosList = new ArrayList<>();
		
		List<CenterConfig> centers = configService.getAllCenterConfig();
		for(CenterConfig center:centers) {
			List<FrontCenterInfo> centerInfos = this.getSortedDatasReverseOrder(Utils.getRedisModuleKey(GroupType.CENTER,center.getName(), DataType.OTHER))
					.toJavaList(FrontCenterInfo.class).stream().limit(2).collect(Collectors.toList());
			centerInfosList.add(centerInfos);
		}
		return centerInfosList;
	}

	@Override
	public List<List<FrontChannelOtherInfo>> getChannelOtherInfos() throws Exception {
		List<List<FrontChannelOtherInfo>> channelInfosList = new ArrayList<>();
		List<ChannelConfig> channels = configService.getAllChannels();
		for(ChannelConfig channel : channels) {
			try {
				List<FrontChannelOtherInfo> channelInfoOthers = this.getSortedDatasReverseOrder(Utils.getRedisModuleKey(GroupType.CHANNEL,channel.getName(), DataType.OTHER))
						.toJavaList(FrontChannelOtherInfo.class).stream().limit(2).collect(Collectors.toList());
				
				channelInfoOthers.forEach(info-> info.setCnname(StringUtils.isEmpty(channel.getCnname())?channel.getName():channel.getCnname()));
				channelInfosList.add(channelInfoOthers);
			}catch(Exception ex) {
				log.error("获取微服务通道数据出现异常：",ex);
			}
			
		}
		
		return channelInfosList;
	}

	@Override
	public List<FrontVisualmachineAlocatInfo> getVisualmachineAlocatInfo() throws Exception {
		List<FrontVisualmachineAlocatInfo> infos = this.getSortedDatasReverseOrder(DemoContants.REDIS_KEY__VISUAL_MACHINE_ALOCAT)
				.toJavaList(FrontVisualmachineAlocatInfo.class).stream().limit(2).collect(Collectors.toList());
		return infos;
	}

	@Override
	public List<FrontResourceAllocatedInfo> getResourceAllocatedInfo() throws Exception {
		List<FrontResourceAllocatedInfo> infos = this.getSortedDatasReverseOrder(DemoContants.REDIS_KEY_RESOURCE_ALLOCATION_RATE)
				.toJavaList(FrontResourceAllocatedInfo.class).stream().limit(2).collect(Collectors.toList());
		return infos;
	}

	@Override
	public JSONArray getList4RedisKey(String redisModuleKey) throws Exception {
		return this.getSortedDatasReverseOrder(redisModuleKey);
	}


}
