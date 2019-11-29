package com.funo.job;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

public abstract class BasePojoDataHandler implements IBigScreenPojoDataHandler{
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Override
	public String getValueKey(Date now) {
		return DateFormatUtils.format(now , "yyyy-MM-dd HH:mm:ss_HH:mm");
	}

	@Override
	public Boolean setDatas(String redisKey, Object data, Date time) {
		String listStr = redisTemplate.opsForValue().get(redisKey);
		Map<String,Object> list;
		if(StringUtils.isEmpty(listStr)) {
			list = new HashMap();
		}else {
			list = JSON.parseObject(listStr, HashMap.class);
		}
		
		list.put(this.getValueKey(time), data);
		List<String> keys = list.keySet().stream().sorted(Comparator.reverseOrder()).limit(IBigScreenPojoDataHandler.SIZE).collect(Collectors.toList());
		Map<String,Object> resultList = new HashMap<>();
		for(String key:keys) {
			resultList.put(key, list.get(key));
		}
		redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(resultList) ,
				100, TimeUnit.MINUTES);
		return true;
	}

	@Override
	public Boolean setDatas(String redisKey, List<InterfacePojoDataInfo> datas) {
		String listStr = redisTemplate.opsForValue().get(redisKey);
		Map<String,Object> list;
		if(StringUtils.isEmpty(listStr)) {
			list = new HashMap();
		}else {
			list = JSON.parseObject(listStr, HashMap.class);
		}
		Map<String,Object> newList = new HashMap<>();
		for(InterfacePojoDataInfo data:datas) {
			newList.put(this.getValueKey(data.getTime()), data.getValue());
		}
		list.putAll(newList);
		
		List<String> keys = list.keySet().stream().sorted(Comparator.reverseOrder()).limit(IBigScreenPojoDataHandler.SIZE).collect(Collectors.toList());
		Map<String,Object> resultList = new HashMap<>();
		for(String key:keys) {
			resultList.put(key, list.get(key));
		}
		redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(resultList) ,
				100, TimeUnit.MINUTES);
		
		return true;
		
	}

	@Override
	public Boolean setData(String redisModuleKey, Object data) {
		redisTemplate.opsForValue().set(redisModuleKey,JSON.toJSONString(data) ,
				100, TimeUnit.MINUTES);
		return true;
	}

	@Override
	public Boolean setData(String redisKey, List<InterfacePojoDataInfo> datas) {
		if(datas == null || datas.size() == 0) {
			return true;
		}
		List<InterfacePojoDataInfo> ds = datas.stream().sorted(new Comparator<InterfacePojoDataInfo>() {

			@Override
			public int compare(InterfacePojoDataInfo o1, InterfacePojoDataInfo o2) {
				long time1 = o1.getTime().getTime();
				long time2 = o2.getTime().getTime();
				if(time1 > time2) {
					return -1;
				}else if(time1 < time2) {
					return 1;
				}else {
					return 0;
				}
			}
			
		}).collect(Collectors.toList());
		redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(ds.get(0)) ,
				100, TimeUnit.MINUTES);
		
		return true;
	}
	
	

}
