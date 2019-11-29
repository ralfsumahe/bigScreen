package com.funo.vo.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台中心  微服务信息  api信息
 * 描述
 * @author linkun
 * @created 2019年11月11日 下午8:11:41
 */
public class FronCenterMicroserviceApiInfo {
	/**
	 * 关键微服务信息
	 */
	private Map<String,List<FrontMicroserviceInfo>> microservices = new HashMap<>();
	/**
	 * 关键api信息
	 */
	private Map<String,List<FrontApiInfo>> apis = new HashMap<>();
	public Map<String, List<FrontMicroserviceInfo>> getMicroservices() {
		return microservices;
	}
	public void setMicroservices(Map<String, List<FrontMicroserviceInfo>> microservices) {
		this.microservices = microservices;
	}
	public Map<String, List<FrontApiInfo>> getApis() {
		return apis;
	}
	public void setApis(Map<String, List<FrontApiInfo>> apis) {
		this.apis = apis;
	}

}
