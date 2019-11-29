package com.funo.vo.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 中心配置
 * 描述
 * @author linkun
 * @created 2019年11月7日 上午9:46:48
 */
public class CenterConfig {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 微服务列表
	 */
	private List<MicroServiceConfig> microServices = new ArrayList<>();
	/**
	 * 关键微服务
	 */
	private String mainMicroServices;
	/**
	 * 关键微服务中文名
	 */
	private String mainMicroServiceCnNames;
	/**
	 * 关键api
	 */
	private List<MainApiConfig> mainAPIs = new ArrayList<>();
	
	public CenterConfig() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MicroServiceConfig> getMicroServices() {
		return microServices;
	}
	public void setMicroServices(List<MicroServiceConfig> microServices) {
		this.microServices = microServices;
	}
	public String getMainMicroServices() {
		return mainMicroServices;
	}
	public void setMainMicroServices(String mainMicroServices) {
		this.mainMicroServices = mainMicroServices;
	}
	
	
	public List<MainApiConfig> getMainAPIs() {
		return mainAPIs;
	}
	public void setMainAPIs(List<MainApiConfig> mainAPIs) {
		this.mainAPIs = mainAPIs;
	}
	public String getMainMicroServiceCnNames() {
		return mainMicroServiceCnNames;
	}
	public void setMainMicroServiceCnNames(String mainMicroServiceCnNames) {
		this.mainMicroServiceCnNames = mainMicroServiceCnNames;
	}
	public static void main(String[] args) {
		String[] centerNames = new String[] {
				"互联网中心","订单中心","计费账务中心","客户资料中心","产商品中心","内容计费中心"
		};
		List<CenterConfig> centers = new ArrayList<>();
		for(String centerName:centerNames) {
			CenterConfig center = new CenterConfig();
			center.setName(centerName);
			for(int i = 0;i < 5;i++) {
				MicroServiceConfig ms = new MicroServiceConfig();
				ms.setName(centerName+"_service_"+i);
				ms.setCnname(centerName+"_服务_"+i);
				for(int j = 0;j < 5;j++) {
					ChannelConfig channel = new ChannelConfig();
					channel.setName(ms.getName()+"_channel_"+j);
					channel.setCnname(ms.getCnname()+"_通道_"+j);
					channel.setInitContainerNum(3);
					channel.setMaxContainerNum(10);
					ms.getChannels().add(channel);
				}
				center.getMicroServices().add(ms);
			}
			String[] mainMss = new String[3];
			String[] mainMsCNs = new String[3];
			
			for(int i = 0;i < 10;i++) {
				MainApiConfig api = new MainApiConfig();
				api.setName(centerName+"_api_"+i);
				api.setCnname(centerName+"_接口_"+i);
				
				api.setChannelApis(api.getName()+"_1,"+api.getName()+"_2,"+api.getName()+"_3,");
				center.getMainAPIs().add(api);
			}
			
			for(int i = 0;i < 3;i++) {
				mainMss[i] = centerName+"_service_"+i;
				mainMsCNs[i] = centerName+"_服务_"+i;
			}
			center.setMainMicroServices(StringUtils.join(mainMss));
			center.setMainMicroServiceCnNames(StringUtils.join(mainMsCNs));
			
			
			centers.add(center);
		}
		
		System.out.println(JSON.toJSONString(centers));
	}
	
	
}
