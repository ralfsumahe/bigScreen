package com.funo.service;

import com.alibaba.fastjson.JSONObject;
import com.funo.constant.DemoContants;
import com.funo.vo.AlertInfo;
import com.funo.vo.BaseYBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;



@Service
public class DemoServiceImpl implements IDemoService {


	@Autowired
    RedisTemplate<String, String> redisTemplate;

	@Override
	public AlertInfo getAlertInfo() {
		String str = redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ALERTINFO);
		AlertInfo info = JSONObject.parseObject(str, AlertInfo.class);
		return info;
	}

	@Override
	public BaseYBP ybp(String redisKey) {
		String str = redisTemplate.opsForValue().get(redisKey);
		BaseYBP info = JSONObject.parseObject(str, BaseYBP.class);
		return info;
	}

	@Override
	public void config(String configKey,String configValue) {
		redisTemplate.opsForValue().set(configKey, configValue);
	}

}
