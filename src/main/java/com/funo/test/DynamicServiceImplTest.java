package com.funo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DynamicServiceImplTest {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;


}
