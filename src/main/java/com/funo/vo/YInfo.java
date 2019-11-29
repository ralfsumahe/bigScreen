package com.funo.vo;

public class YInfo {

	/**
	 * y轴title
	 */
	private String name;
	/**
	 * 最小值
	 */
	private Integer min;
	/**
	 * 最大值
	 */
	private Integer max;
	/**
	 * 位置   right  left
	 */
	private String position;
	/**
	 * y轴偏移
	 */
	private Integer offset;
	
	private Integer fontSize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}
	
	
}
