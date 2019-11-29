package com.funo.job;


import com.funo.constant.DynamicConstants;

import java.util.Date;
import java.util.List;

public class BigScreenPojoDataOperator implements IBigScreenDataOperator {
	private IBigScreenPojoDataHandler handler;
	private Object data;
	private List<InterfacePojoDataInfo> datas;
	private BigScreenPojoDataOperator() {
		super();
	}

	public BigScreenPojoDataOperator(IBigScreenPojoDataHandler handler,Object data) {
		super();
		this.handler = handler;
		this.data = data;
	}
	
	public BigScreenPojoDataOperator(IBigScreenPojoDataHandler handler,List<InterfacePojoDataInfo> datas) {
		super();
		this.handler = handler;
		this.datas = datas;
	}

	@Override
	public void operate(Date now,String redisModuleKey) {
		if(data == null) {
//			handler.setData(redisModuleKey+"_"+DynamicConstants.CURRENT, datas);
			handler.setDatas(redisModuleKey+"_"+ DynamicConstants.LIST, datas);
		}else {
			handler.setData(redisModuleKey+"_"+DynamicConstants.CURRENT, data);
			handler.setDatas(redisModuleKey+"_"+DynamicConstants.LIST, data, now);
		}
	}

}
