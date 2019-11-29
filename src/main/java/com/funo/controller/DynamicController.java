package com.funo.controller;

import java.util.List;
import java.util.Map;

import com.funo.service.IDynamicService;
import com.funo.service.config.IConfigService;
import com.funo.vo.BaseZXTs;
import com.funo.vo.config.ChannelConfig;
import com.funo.vo.config.MicroServiceConfig;
import com.funo.vo.front.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;


@RestController
@RequestMapping("/demo")
public class DynamicController {
	@Autowired
	private IDynamicService service;
	@Autowired
	private IConfigService configService;
	
	
	@PostMapping("dynamiczxt/{title}")
	public BaseZXTs zxt(String data, @PathVariable("title") String title) throws Exception {
		return service.zxt(data,title);
	}
	
	@PostMapping("dynamiczxt2/{title}")
	public BaseZXTs zxt2(String data,@PathVariable("title") String title) throws Exception {
		return service.zxt2(data,title);
	}
	
	@GetMapping("getSortedDatasReverseOrder/{redisModuleKey}")
	public JSONArray getSortedDatasReverseOrder(@PathVariable("redisModuleKey") String redisModuleKey)throws Exception{
		return service.getSortedDatasReverseOrder(redisModuleKey);
	}
	
	@GetMapping("getFrontCenterMicroserviceApiInfos")
	public Map<String, FronCenterMicroserviceApiInfo> getFrontCenterMicroserviceApiInfos()throws Exception{
		return service.getFrontCenterMicroserviceApiInfos();
	}
	
	@GetMapping("getFrontCenterInfos")
	public List<List<FrontCenterInfo>> getFrontCenterInfos()throws Exception{
		return service.getFrontCenterInfos();
	}
	
	@GetMapping("getChannelOtherInfos")
	public List<List<FrontChannelOtherInfo>> getChannelOtherInfos()throws Exception{
		return service.getChannelOtherInfos();
	}
	
	@GetMapping("getVisualmachineAlocatInfo")
	public List<FrontVisualmachineAlocatInfo> getVisualmachineAlocatInfo()throws Exception{
		return service.getVisualmachineAlocatInfo();
	}
	@GetMapping("getResourceAllocatedInfo")
	public List<FrontResourceAllocatedInfo> getResourceAllocatedInfo()throws Exception{
		return service.getResourceAllocatedInfo();
	}
	
	@GetMapping("getAllMicroserviceConfig")
	public List<MicroServiceConfig> getAllMicroserviceConfig()throws Exception{
		return configService.getAllMicroServices();
	}
	
	@GetMapping("getAllChannelConfig")
	public List<ChannelConfig> getAllChannelConfig()throws Exception{
		return configService.getAllChannels();
	}
	
	@GetMapping("getList4RedisKey/{redisModuleKey}")
	public JSONArray getList4RedisKey(@PathVariable("redisModuleKey")String redisModuleKey)throws Exception{
		return service.getList4RedisKey(redisModuleKey);
	}
}
