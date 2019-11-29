package com.funo.vo.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 微服务配置树
 * 描述
 * @author linkun
 * @created 2019年11月7日 上午9:46:59
 */
public class MicroServiceConfig {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 中文名
	 */
	private String cnname;
	
	
	private List<ChannelConfig> channels = new ArrayList<>();
	
	
	public MicroServiceConfig() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public List<ChannelConfig> getChannels() {
		return channels;
	}
	public void setChannels(List<ChannelConfig> channels) {
		this.channels = channels;
	}
	
}
