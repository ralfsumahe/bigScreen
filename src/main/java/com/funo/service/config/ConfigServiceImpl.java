package com.funo.service.config;

import com.alibaba.fastjson.JSONArray;
import com.funo.constant.ConfigConstants;
import com.funo.vo.config.CenterConfig;
import com.funo.vo.config.ChannelConfig;
import com.funo.vo.config.MainApiConfig;
import com.funo.vo.config.MicroServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigServiceImpl implements IConfigService{
	private  static Logger log = LoggerFactory.getLogger(ConfigServiceImpl.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public List<MicroServiceConfig> getAllMicroServices() {
		String str = redisTemplate.opsForValue().get(ConfigConstants.BIGSCREEN_CONFIG_CENTERCONFIG);
		List<CenterConfig> centerConfigs = JSONArray.parseArray(str, CenterConfig.class);
		List<MicroServiceConfig> msConfigs = new ArrayList<>();		
		centerConfigs.stream().forEach(center->msConfigs.addAll(center.getMicroServices()));
		return msConfigs;
	}

	@Override
	public List<MicroServiceConfig> getAllMicroServicesByCenter(String centerName) {
		String str = redisTemplate.opsForValue().get(ConfigConstants.BIGSCREEN_CONFIG_CENTERCONFIG);
		List<CenterConfig> centerConfigs = JSONArray.parseArray(str, CenterConfig.class);
		
		return centerConfigs.stream().filter(centerConfig-> centerConfig.getName().equals(centerName))
				.findFirst().get().getMicroServices();
	}

	@Override
	public String getMainMicroservicesByCenter(String centerName) {
		String str = redisTemplate.opsForValue().get(ConfigConstants.BIGSCREEN_CONFIG_CENTERCONFIG);
		List<CenterConfig> centerConfigs = JSONArray.parseArray(str, CenterConfig.class);
		return centerConfigs.stream().filter(centerConfig->centerConfig.getName().equals(centerName))
				.findFirst().get().getMainMicroServices();
	}

	@Override
	public List<MainApiConfig> getMainApiByCenter(String centerName) {
		String str = redisTemplate.opsForValue().get(ConfigConstants.BIGSCREEN_CONFIG_CENTERCONFIG);
		List<CenterConfig> centerConfigs = JSONArray.parseArray(str, CenterConfig.class);
		return centerConfigs.stream().filter(centerConfig->centerConfig.getName().equals(centerName))
				.findFirst().get().getMainAPIs();
	}

	@Override
	public Boolean setCenterConfigs(String str) {
		List<CenterConfig> centers= JSONArray.parseArray(str, CenterConfig.class);
		for(CenterConfig center:centers) {
			String[] mainMicroservices = center.getMainMicroServices().split(",");
			String[] mainMicroserviceCnNames = center.getMainMicroServiceCnNames().split(",");
			if(mainMicroservices.length != mainMicroserviceCnNames.length) {
				log.error("关键微服务和关键微服务中文名称数量不相等:{}    {}",center.getMainMicroServices(),center.getMainMicroServiceCnNames());
				throw new RuntimeException("关键微服务和关键微服务中文名称数量不相等");
			}
			for(String mainMicroservice:mainMicroservices) {
				boolean isIn = false;
				for(MicroServiceConfig microservice:center.getMicroServices()) {
					if(microservice.getName().equals(mainMicroservice)) {
						isIn = true;
					}
				}
				if(!isIn) {
					log.error("关键微服务不包含在微服务中，配置有错:{}",mainMicroservice);
					throw new RuntimeException("关键微服务不包含在微服务中，配置有错");
				}
			}
		}
		redisTemplate.opsForValue().set(ConfigConstants.BIGSCREEN_CONFIG_CENTERCONFIG, JSONArray.toJSONString(centers));
		return true;
	}

	@Override
	public List<CenterConfig> getAllCenterConfig() {
		String str = redisTemplate.opsForValue().get(ConfigConstants.BIGSCREEN_CONFIG_CENTERCONFIG);
		List<CenterConfig> centerConfigs = JSONArray.parseArray(str, CenterConfig.class);
		return centerConfigs;
	}

	@Override
	public List<ChannelConfig> getAllChannels() {
		List<MicroServiceConfig> microservices = this.getAllMicroServices();
		List<ChannelConfig> channels = new ArrayList<>();
		microservices.stream().forEach(ms->channels.addAll(ms.getChannels()));
		return channels;
	}

}
