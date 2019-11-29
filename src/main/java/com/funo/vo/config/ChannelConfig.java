package com.funo.vo.config;

public class ChannelConfig {

	/**
	 * 通道名称
	 */
	private String name;
	/**
	 * 通道中文名
	 */
	private String cnname;
	/**
	 * 初始容器数
	 */
	private Integer initContainerNum;
	/**
	 * 最大容器数
	 */
	private Integer maxContainerNum;
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
	public Integer getInitContainerNum() {
		return initContainerNum;
	}
	public void setInitContainerNum(Integer initContainerNum) {
		this.initContainerNum = initContainerNum;
	}
	public Integer getMaxContainerNum() {
		return maxContainerNum;
	}
	public void setMaxContainerNum(Integer maxContainerNum) {
		this.maxContainerNum = maxContainerNum;
	}
	
	
}
