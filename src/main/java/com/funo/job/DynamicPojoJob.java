package com.funo.job;

import com.alibaba.fastjson.JSONObject;
import com.funo.DataType;
import com.funo.GroupType;
import com.funo.Utils;
import com.funo.constant.DemoContants;
import com.funo.constant.GraphicConstants;
import com.funo.service.config.IConfigService;
import com.funo.vo.AlertInfo;
import com.funo.vo.BaseYBP;
import com.funo.vo.back.*;
import com.funo.vo.config.CenterConfig;
import com.funo.vo.config.ChannelConfig;
import com.funo.vo.config.MicroServiceConfig;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;



@Component
public class DynamicPojoJob {

	@Autowired
	private DynamicPojoDataCWHandler dynamicPojoDataHandler;
	
	@Autowired
	private IConfigService configService;
	
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Async
	@Scheduled(cron="0/5 * * * * ?")
	public void dynamicPojo() throws Exception {
		Date now = new Date();
		
		//获取数据
		List<InterfacePojoDataInfo> dataInfos = new ArrayList<>();
		for(int i = 0;i < 5;i++) {
			InterfacePojoDataInfo dataInfo = new InterfacePojoDataInfo();
			dataInfo.setTime(DateUtils.addSeconds(now, -5*i));
			
			Random r = new Random();
			double cpu = Math.round(r.nextDouble()*10000)/100.0;
			double memery =  Math.round(r.nextDouble()*10000)/100.0;
			double disk =  Math.round(r.nextDouble()*10000)/100.0;
			
			DynamicPojo info = new DynamicPojo();
			info.setCpu(cpu);
			info.setMemery(memery);
			info.setDisk(disk);
			
			dataInfo.setValue(info);
			dataInfos.add(dataInfo);
		}
		//获取数据结束
		
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler,dataInfos);
		operator.operate(now,"dynamicPojo");
	}
	
	@Async
	@Scheduled(cron="0/5 * * * * ?")
	public void dynamicPojo1() throws Exception {
		Date now = new Date();
		
		//获取数据
		Random r = new Random();
		double cpu = Math.round(r.nextDouble()*10000)/100.0;
		double memery =  Math.round(r.nextDouble()*10000)/100.0;
		double disk =  Math.round(r.nextDouble()*10000)/100.0;
		
		DynamicPojo info = new DynamicPojo();
		info.setCpu(cpu);
		info.setMemery(memery);
		info.setDisk(disk);
		//获取数据结束
		
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler,info);
		operator.operate(now,"dynamicPojo1");
	}
	
	
	@Async
	@Scheduled(cron="0/5 * * * * ?")
	public void dynamicPojo2() throws Exception {
		Date now = new Date();
		
		//获取数据
		Random r = new Random();
		double cpu = r.nextInt(10)+90;
		//获取数据结束
		
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler,cpu);
		operator.operate(now,"dynamicPojo2");
	}
	@Async
	@Scheduled(cron="0/5 * * * * ?")
	public void addData()throws Exception{
		Date now = new Date();
		addCenterOther(now);
		addChannelOther(now);
		addMicroserviceOther(now);
		addAllBusinessInfo(now);
		addCenterBusinessInfo(now);
		addApiInfoData(now);
		addresource_allocation_rate(now);
		addvisual_machine_alocat(now);

		addAlertInfo(now);

		addYbp(now);
		addYbp2(now);
	}

	private void addYbp2(Date now) {

		BaseYBP info3 = new BaseYBP(GraphicConstants.YBP_NODE_HELTH,100.0,110,110);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_NODESHEALTH,JSONObject.toJSONString(info3) ,
				65, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_NODESHEALTH));

		BaseYBP info4 = new BaseYBP(GraphicConstants.YBP_CONRAIN_HELTH,100.0,12,34);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_CONTAINERSHEALTH,JSONObject.toJSONString(info4) ,
				34, TimeUnit.MINUTES);

		BaseYBP info5 = new BaseYBP(GraphicConstants.YBP_CONRAIN_HELTH,98.0,45,333);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_MICRO_SERIVCES_HEALTH,JSONObject.toJSONString(info5) ,
				34, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_CONTAINERSHEALTH));
	}

	private void addYbp(Date now) {
		BaseYBP info = new BaseYBP(GraphicConstants.YBP_CPU_AVG_TITLE,Math.round(11*10000.0/30)/100.0);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_YBP_AVGCPU,JSONObject.toJSONString(info) ,
				100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_YBP_AVGCPU));
		BaseYBP info2 = new BaseYBP(GraphicConstants.YBP_DISK_AVG_TITLE,Math.round(11*10000.0/30)/100.0);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_YBP_AVGDISK,JSONObject.toJSONString(info2) ,
				100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_YBP_AVGDISK));
		BaseYBP info3 = new BaseYBP(GraphicConstants.YBP_MEM_AVG_TITLE,Math.round(11*10000.0/30)/100.0);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_YBP_AVGMEMORY,JSONObject.toJSONString(info3) ,
				100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_YBP_AVGMEMORY));
		BaseYBP info4 = new BaseYBP(GraphicConstants.YBP_VIRMEM_AVG_TITLE,Math.round(2*10000.0/30)/100.0);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_YBP_AVGVISUALMEMORY,JSONObject.toJSONString(info4) ,
				100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_YBP_AVGVISUALMEMORY));


	}

	/**
	 * 添加告警信息
	 * @param now
	 */
	private void addAlertInfo(Date now) {
		List<String> titles = Arrays.asList(new String[] {"紧急告警","重要告警","次要告警","提示告警"});
		List<Integer> counts = Arrays.asList(new Integer[]{10200,56,1,2});
	AlertInfo info = new AlertInfo(titles, counts);
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ALERTINFO, JSONObject.toJSONString(info) ,
				100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ALERTINFO));
}


	private void addvisual_machine_alocat(Date now) {
		Random r = new Random();
		VisualmachineAlocatInfo info = new VisualmachineAlocatInfo();
		info.setMachineNum(r.nextInt(50)+50);
		info.setVisualNum(50+r.nextInt(80));
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
		operator.operate(now, "visual_machine_alocat");
	}

	private void addresource_allocation_rate(Date now) {
		ResourceAllocatedInfo info = new ResourceAllocatedInfo();
		Random r = new Random();
		info.setCpu(20+r.nextInt(50));
		info.setDisk(20+r.nextInt(50));
		info.setMemery(20+r.nextInt(50));
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
		operator.operate(now, "resource_allocation_rate");
	}

	/**
	 * 添加api信息
	 * 描述
	 * @author linkun
	 * @created 2019年11月9日 下午11:30:48
	 * @param now
	 */
	private void addApiInfoData(Date now) {
		List<String> mainApis = new ArrayList<>();
		configService.getAllCenterConfig().stream().forEach(center->{
			mainApis.addAll(center.getMainAPIs().stream().map(a -> a.getName()).collect(Collectors.toList()));
		});
		for(String mainApi:mainApis) {
			
			Random r = new Random();
			ApiBusinessInfo info = new ApiBusinessInfo();
			info.setApiName(mainApi);
			info.setReq(r.nextInt(1000)+5000);
			info.setAvgrespontime(20+r.nextInt(200));
			info.setSuccess(90+r.nextInt(10));
			BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
			operator.operate(now, Utils.getRedisModuleKey(GroupType.API,mainApi, DataType.BUSINESS));
		}
	}

	/**
	 * 添加通道容器信息
	 * 描述
	 * @author linkun
	 * @created 2019年11月8日 下午5:04:46
	 * @param now
	 */
	private void addChannelOther(Date now) {
		List<ChannelConfig> channels = configService.getAllChannels();
		for(ChannelConfig channel:channels) {
			ChannelOtherInfo info = new ChannelOtherInfo();
			Random r = new Random();
			info.setName(channel.getName());
			info.setCurrentContainerNum(r.nextInt(20));
			info.setErrorContainerNum(0);
			info.setInitContainerNum(r.nextInt(10));
			
			info.setCpu(Double.valueOf(r.nextInt(50)+10));
			info.setMemery(Double.valueOf(r.nextInt(50)+10));
			
			BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
			operator.operate(now, Utils.getRedisModuleKey(GroupType.CHANNEL,channel.getName(), DataType.OTHER));
		}
	}
	
	
	/**
	 * 添加微服务容器信息
	 * 描述
	 * @author linkun
	 * @created 2019年11月8日 下午5:04:46
	 * @param now
	 */
	private void addMicroserviceOther(Date now) {
		List<MicroServiceConfig> microservices = configService.getAllMicroServices();
		for(MicroServiceConfig microservice:microservices) {
			MicroserviceOtherInfo info = new MicroserviceOtherInfo();
			Random r = new Random();
			info.setName(microservice.getName());
			info.setCurrentContainerNum(r.nextInt(20));
			info.setErrorContainerNum(0);
			info.setInitContainerNum(r.nextInt(10));
			
			
			info.setCpu(Double.valueOf(r.nextInt(50)+10));
			info.setMemery(Double.valueOf(r.nextInt(50)+10));
			
			BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
			operator.operate(now, Utils.getRedisModuleKey(GroupType.MICROSERVICE,microservice.getName(), DataType.OTHER));
		}
	}

	/**
	 * 添加中心微服务
	 * 描述
	 * @author linkun
	 * @created 2019年11月6日 上午1:28:26
	 * @param now
	 */
	private void addCenterOther(Date now) {
		List<CenterConfig> centers = configService.getAllCenterConfig();
		
		for(CenterConfig center:centers) {
			String centerName = center.getName();
			CenterOtherInfo info = new CenterOtherInfo();
			Random r = new Random();
			info.setCenterName(centerName);
			info.setContainerNum(r.nextInt(31));
			info.setMicroserviceNum(r.nextInt(10));
			info.setVisualmachineNum(r.nextInt(30));
			BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
			operator.operate(now, Utils.getRedisModuleKey(GroupType.CENTER,centerName, DataType.OTHER));
		}
		
	}

	/**
	 * 添加总业务指标
	 * 描述
	 * @author linkun
	 * @created 2019年11月6日 上午1:27:05
	 * @param now
	 */
	private void addAllBusinessInfo(Date now) {
		//总体业务指标
		List<InterfacePojoDataInfo> dataInfos = new ArrayList<>();
		for(int i = 0;i < 5;i++) {
			InterfacePojoDataInfo dataInfo = new InterfacePojoDataInfo();
			dataInfo.setTime(DateUtils.addSeconds(now, -5*i));
			
			Random r = new Random();
			double avgrespontime = r.nextInt(100)+20;
			double success =  r.nextInt(10)+90;
			double req =  r.nextInt(20000)+20000;
			
			CenterBusinessInfo binfo = new CenterBusinessInfo();
			binfo.setAvgrespontime(avgrespontime);
			binfo.setReq(req);
			binfo.setSuccess(success);
			
			dataInfo.setValue(binfo);
			dataInfos.add(dataInfo);
		}
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, dataInfos);
		operator.operate(now, Utils.getRedisModuleKey(GroupType.ALL,"all", DataType.BUSINESS));
		//总体业务指标
	}
	
	/**
	 * 添加各中心业务指标
	 * 描述
	 * @author linkun
	 * @created 2019年11月6日 上午1:27:05
	 * @param now
	 */
	private void addCenterBusinessInfo(Date now) {
		List<CenterConfig> centers = configService.getAllCenterConfig();
		for(CenterConfig center :centers) {
			List<InterfacePojoDataInfo> dataInfos = new ArrayList<>();
			for(int i = 0;i < 5;i++) {
				InterfacePojoDataInfo dataInfo = new InterfacePojoDataInfo();
				dataInfo.setTime(DateUtils.addSeconds(now, -5*i));
				
				Random r = new Random();
				double avgrespontime = r.nextInt(100)+20;
				double success =  r.nextInt(10)+90;
				double req =  r.nextInt(20000)+3000;
				
				CenterBusinessInfo binfo = new CenterBusinessInfo();
				binfo.setAvgrespontime(avgrespontime);
				binfo.setReq(req);
				binfo.setSuccess(success);
				
				dataInfo.setValue(binfo);
				dataInfos.add(dataInfo);
			}
			BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, dataInfos);
			operator.operate(now, Utils.getRedisModuleKey(GroupType.CENTER,center.getName(), DataType.BUSINESS));
		}
	}
}
