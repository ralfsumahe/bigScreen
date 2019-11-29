package com.funo.vo;

public class DynamicInfo {

	/**
	 * 数据模块
	 */
	private String module;
	/**
	 * 数据title
	 */
	private String dataTitle;
	/**
	 * 折线还是柱状图
	 * line bar
	 */
	private String type;
	/**
	 * 对应的y轴
	 */
	private Integer yAxisIndex;
	/**
	 * 最小值
	 */
	private Integer min;
	/**
	 * 最大值
	 */
	private Integer max;
	
	private Boolean isAreaStyle;
	
	private String field;
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getDataTitle() {
		return dataTitle;
	}
	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getyAxisIndex() {
		return yAxisIndex;
	}
	public void setyAxisIndex(Integer yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Boolean getIsAreaStyle() {
		return isAreaStyle;
	}
	public void setIsAreaStyle(Boolean isAreaStyle) {
		this.isAreaStyle = isAreaStyle;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	
}
