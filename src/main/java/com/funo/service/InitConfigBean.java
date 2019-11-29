package com.funo.service;

import com.funo.service.config.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class InitConfigBean {
	@Autowired
	private IConfigService configService;
	
	/**
	 * 读取配置信息，存入缓存
	 * 描述
	 * @author linkun
	 * @created 2019年11月7日 下午1:46:31
	 * @throws IOException
	 */
	@PostConstruct
	public void initConfig() throws IOException {
		ClassPathResource resource = new ClassPathResource("centerConfig.json");
		String jsonData = "";
		byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
		jsonData = new String(bytes, StandardCharsets.UTF_8);
		configService.setCenterConfigs(jsonData);
	}
	
}
