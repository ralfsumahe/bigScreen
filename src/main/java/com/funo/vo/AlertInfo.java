package com.funo.vo;

import java.util.List;

/**
 * 告警信息统计
 * 描述
 * @author linkun
 * @created 2019年8月20日 下午2:03:56
 */
public class AlertInfo {

	private List<String> titles;
	private List<Integer> counts;
	
	
	
	private AlertInfo() {
		super();
	}
	public AlertInfo(List<String> titles, List<Integer> counts) {
		super();
		this.titles = titles;
		this.counts = counts;
	}
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	public List<Integer> getCounts() {
		return counts;
	}
	public void setCounts(List<Integer> counts) {
		this.counts = counts;
	}
	
	
	
}
