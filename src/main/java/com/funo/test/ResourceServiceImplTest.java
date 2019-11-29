package com.funo.test;

import com.alibaba.fastjson.JSON;
import com.funo.constant.DemoContants;
import com.funo.constant.GraphicConstants;
import com.funo.vo.BaseZXT;
import com.funo.vo.BaseZXTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ResourceServiceImplTest {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public void addYBPData() {

	}
	
	public void addZXTData() {
		String[] times = new String[] {"22:00","22:05","22:10","22:15","22:20","22:25","22:30","22:35",
				"22:40","22:45","22:50","22:55"};
		
		
		List<BaseZXT> cpuDatas = new ArrayList<>();
		BaseZXT cpuInfo = new BaseZXT(GraphicConstants.ZXT_CPU_AVG_DATATITLE,new Double[] {10.1,12.5,20.3,10.5,8.9,17.34,21d,9d,19d,19d,12d,22d});
		cpuDatas.add(cpuInfo);
		BaseZXTs cpuStatics = new BaseZXTs(times,GraphicConstants.ZXT_CPU_AVG_TITLE,
				GraphicConstants.ZXT_RESOURCE_XTITLE,GraphicConstants.ZXT_RESOURCE_YTITLE,cpuDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZXT_AVGCPU, JSON.toJSONString(cpuStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZXT_AVGCPU));
		
		List<BaseZXT> disDatas = new ArrayList<>();
		BaseZXT disInfo = new BaseZXT(GraphicConstants.ZXT_DISK_AVG_TITLE,new Double[] {10.1,12.5,20.3,10.5,8.9,17.34,21d,9d,19d,19d,12d,22d});
		disDatas.add(disInfo);
		BaseZXTs disStatics = new BaseZXTs(times,GraphicConstants.ZXT_DISK_AVG_DATATITLE,GraphicConstants.ZXT_RESOURCE_XTITLE,
				GraphicConstants.ZXT_RESOURCE_YTITLE,disDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZXT_AVGDISK, JSON.toJSONString(disStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZXT_AVGDISK));
		
		List<BaseZXT> memoryDatas = new ArrayList<>();
		BaseZXT memoryInfo = new BaseZXT(GraphicConstants.ZXT_MEM_AVG_DATATITLE,new Double[] {10.1,12.5,20.3,10.5,8.9,17.34,21d,9d,19d,19d,12d,22d});
		memoryDatas.add(memoryInfo);
		BaseZXTs memoryStatics = new BaseZXTs(times,GraphicConstants.ZXT_MEM_AVG_TITLE,GraphicConstants.ZXT_RESOURCE_XTITLE,
				GraphicConstants.ZXT_RESOURCE_YTITLE,memoryDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZXT_AVGMEMORY, JSON.toJSONString(memoryStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZXT_AVGMEMORY));
		
		
		List<BaseZXT> visualMemoryDatas = new ArrayList<>();
		BaseZXT visualMemoryInfo = new BaseZXT(GraphicConstants.ZXT_VIRMEM_AVG_DATATITLE,new Double[] {10.1,12.5,20.3,10.5,8.9,17.34,21d,9d,19d,19d,12d,22d});
		visualMemoryDatas.add(visualMemoryInfo);
		BaseZXTs visualMemoryStatics = new BaseZXTs(times,GraphicConstants.ZXT_VIRMEM_AVG_TITLE,GraphicConstants.ZXT_RESOURCE_XTITLE,
				GraphicConstants.ZXT_RESOURCE_YTITLE,visualMemoryDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZXT_AVGVISUALMEMORY, JSON.toJSONString(visualMemoryStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZXT_AVGVISUALMEMORY));
	}
	
	public void addZZTData() {
		String[] times = new String[] {"10%","20%","30%","40%","50%","60%","70%","80%",
				"90%","100%"};
		
		
		List<BaseZXT> cpuDatas = new ArrayList<>();
		BaseZXT cpuInfo = new BaseZXT(GraphicConstants.ZZT_CPU_AVG_DATATITLE,new Integer[] {10,8,20,48,30,17,18,9,1,1});
		cpuDatas.add(cpuInfo);
		BaseZXTs cpuStatics = new BaseZXTs(times,GraphicConstants.ZZT_CPU_AVG_TITLE,GraphicConstants.ZZT_RESOURCE_XTITLE,
				GraphicConstants.ZZT_RESOURCE_YTITLE,cpuDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZZT_AVGCPU, JSON.toJSONString(cpuStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZZT_AVGCPU));
		
		List<BaseZXT> disDatas = new ArrayList<>();
		BaseZXT disInfo = new BaseZXT(GraphicConstants.ZZT_DISK_AVG_DATATITLE,new Integer[] {10,8,20,48,30,17,18,9,0,0});
		disDatas.add(disInfo);
		BaseZXTs disStatics = new BaseZXTs(times,GraphicConstants.ZZT_DISK_AVG_TITLE,GraphicConstants.ZZT_RESOURCE_XTITLE,
				GraphicConstants.ZZT_RESOURCE_YTITLE,disDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZZT_AVGDISK, JSON.toJSONString(disStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZZT_AVGDISK));
		
		List<BaseZXT> memoryDatas = new ArrayList<>();
		BaseZXT memoryInfo = new BaseZXT(GraphicConstants.ZZT_MEM_AVG_DATATITLE,new Integer[] {10,8,20,48,30,17,18,9,0,0});
		memoryDatas.add(memoryInfo);
		BaseZXTs memoryStatics = new BaseZXTs(times,GraphicConstants.ZZT_MEM_AVG_TITLE,GraphicConstants.ZZT_RESOURCE_XTITLE,
				GraphicConstants.ZZT_RESOURCE_YTITLE,memoryDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZZT_AVGMEMORY, JSON.toJSONString(memoryStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZZT_AVGMEMORY));
		
		
		List<BaseZXT> visualMemoryDatas = new ArrayList<>();
		BaseZXT visualMemoryInfo = new BaseZXT(GraphicConstants.ZZT_VIRMEM_AVG_DATATITLE,new Integer[] {10,8,20,48,30,17,18,9,0,0});
		visualMemoryDatas.add(visualMemoryInfo);
		BaseZXTs visualMemoryStatics = new BaseZXTs(times,GraphicConstants.ZZT_VIRMEM_AVG_TITLE,GraphicConstants.ZZT_RESOURCE_XTITLE,
				GraphicConstants.ZZT_RESOURCE_YTITLE,visualMemoryDatas);
		
		redisTemplate.opsForValue().set(DemoContants.REDIS_KEY_ZZT_AVGVISUALMEMORY, JSON.toJSONString(visualMemoryStatics), 100, TimeUnit.MINUTES);
		System.out.println(redisTemplate.opsForValue().get(DemoContants.REDIS_KEY_ZZT_AVGVISUALMEMORY));
	}

}
