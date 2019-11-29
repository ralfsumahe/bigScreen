package com.funo.vo;
/**
 * 折线图数据
 * 描述
 * @author linkun
 * @created 2019年8月19日 下午10:00:05
 */
public class BaseZXT {

	/**
	 * 数据标题
	 */
	private String dataTitle;
	/**
	 * 数据列表
	 */
	private Number[] datas;
	
	private Integer min;
	
	private Integer max;
	
	private String type;
	
	private Integer yAxisIndex;
	
	private Boolean isAreaStyle;
	
	private BaseZXT() {
		super();
	}
	public BaseZXT(String dataTitle, Number[] datas) {
		super();
		this.dataTitle = dataTitle;
		this.datas = datas;
	}
	public String getDataTitle() {
		return dataTitle;
	}
	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	public Number[] getDatas() {
		return datas;
	}
	public void setDatas(Number[] datas) {
		this.datas = datas;
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

	
	
	
	
}
