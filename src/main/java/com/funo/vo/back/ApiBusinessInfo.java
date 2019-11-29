package com.funo.vo.back;

/**
 * api指标信息
 * 描述
 * @author linkun
 * @created 2019年11月11日 下午6:55:36
 */
public class ApiBusinessInfo {

	/**
	 * api名称
	 */
	private String apiName;
	/**
	 * 吞吐量(次/分)
	 */
	private Number req;
	/**
	 * 成功率(%)
	 */
	private Number success;
	/**
	 * 平均时长(ms)
	 */
	private Number avgrespontime;
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public Number getReq() {
		return req;
	}
	public void setReq(Number req) {
		this.req = req;
	}
	public Number getSuccess() {
		return success;
	}
	public void setSuccess(Number success) {
		this.success = success;
	}
	public Number getAvgrespontime() {
		return avgrespontime;
	}
	public void setAvgrespontime(Number avgrespontime) {
		this.avgrespontime = avgrespontime;
	}
	
	
}
