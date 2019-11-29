package com.funo.job;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 数据处理类
 * 当前值是错误的
 * 描述
 * @author linkun
 * @created 2019年11月5日 上午12:01:23
 */
@Component
public class DynamicPojoDataCWHandler extends BasePojoDataHandler {
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	@Override
	public String getValueKey(Date now) {
		return DateFormatUtils.format(now , "yyyy-MM-dd HH:mm:ss_mm:ss");
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
		if(datas.size() >= 2) {
			redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(ds.get(1)) ,
					100, TimeUnit.MINUTES);
		}else {
			redisTemplate.opsForValue().set(redisKey,JSON.toJSONString(ds.get(0)) ,
					100, TimeUnit.MINUTES);
		}
		
		
		return true;
	}
	
	
}
