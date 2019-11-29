package com.funo.vo;

import java.util.List;
import java.util.Map;

public class DynamicInfos {

	/**
	 * 描点个数
	 */
	private Integer count;
	/**
	 * 间隔时间（min）
	 */
	private Integer timeLen;
	/**
	 * x轴title
	 */
	private String xtitle;
	/**
	 * y轴title
	 */
	private String ytitle; 
	/**
	 * 数据列表
	 */
	private DynamicInfo[] datas;
	
	private List<YInfo> yInfos;
	
	private Map<String,Object> other;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTimeLen() {
		return timeLen;
	}
	public void setTimeLen(Integer timeLen) {
		this.timeLen = timeLen;
	}
	public String getXtitle() {
		return xtitle;
	}
	public void setXtitle(String xtitle) {
		this.xtitle = xtitle;
	}
	public String getYtitle() {
		return ytitle;
	}
	public void setYtitle(String ytitle) {
		this.ytitle = ytitle;
	}
	public DynamicInfo[] getDatas() {
		return datas;
	}
	public void setDatas(DynamicInfo[] datas) {
		this.datas = datas;
	}
	public List<YInfo> getYInfos() {
		return yInfos;
	}
	public void setYInfos(List<YInfo> yInfos) {
		this.yInfos = yInfos;
	}
	public Map<String, Object> getOther() {
		return other;
	}
	public void setOther(Map<String, Object> other) {
		this.other = other;
	}
	
}
