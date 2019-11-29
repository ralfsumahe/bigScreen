package com.funo.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 折线图 描述
 * 
 * @author linkun
 * @created 2019年8月14日 下午1:39:55
 */
public class BaseZXTs {

	/**
	 * 时间轴数据
	 */
	private String[] times;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * x轴标题
	 */
	private String xtitle;
	/**
	 * y轴标题
	 */
	private String ytitle;
	/**
	 * 数据列表
	 */
	private List<BaseZXT> datas = new ArrayList<>();
	
	private List<YInfo> yInfos;
	
	private Map<String,Object> other;
	
	private BaseZXTs() {
		super();
	}
	/**
	 * 
	 * 描述
	 * @author linkun
	 * @created 2019年8月19日 下午10:29:56
	 * @param times
	 * @param title
	 * @param xtitle
	 * @param ytitle
	 * @param datas
	 */
	public BaseZXTs(String[] times, String title, String xtitle, String ytitle, List<BaseZXT> datas) {
		super();
		this.times = times;
		this.title = title;
		this.xtitle = xtitle;
		this.ytitle = ytitle;
		this.datas = datas;
	}
	
	public String[] getTimes() {
		return times;
	}
	public void setTimes(String[] times) {
		this.times = times;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String[] getDataTitles() {
		String[] tmps = new String[datas.size()];
		for(int i = 0;i < datas.size();i++) {
			tmps[i] = datas.get(i).getDataTitle();
		}
		return tmps;
	}
	public List<BaseZXT> getDatas() {
		return datas;
	}
	public void addData(BaseZXT data) {
		this.datas.add(data);
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
