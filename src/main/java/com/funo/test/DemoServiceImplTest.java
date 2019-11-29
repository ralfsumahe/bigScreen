package com.funo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceImplTest {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public void addAlertInfo() {

	}
	



}
