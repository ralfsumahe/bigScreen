package com.funo.service.config;



import com.funo.vo.config.CenterConfig;
import com.funo.vo.config.ChannelConfig;
import com.funo.vo.config.MainApiConfig;
import com.funo.vo.config.MicroServiceConfig;

import java.util.List;

public interface IConfigService {
	
	public Boolean setCenterConfigs(String str);

	public List<CenterConfig> getAllCenterConfig();
	
	public List<MicroServiceConfig> getAllMicroServices();
	
	public List<MicroServiceConfig> getAllMicroServicesByCenter(String centerName);
	
	public String getMainMicroservicesByCenter(String centerName);
	public List<MainApiConfig> getMainApiByCenter(String centerName);
	
	public List<ChannelConfig> getAllChannels();
}
