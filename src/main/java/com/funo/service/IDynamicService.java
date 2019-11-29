package com.funo.service;

import com.alibaba.fastjson.JSONArray;
import com.funo.vo.BaseZXTs;
import com.funo.vo.front.*;

import java.util.List;
import java.util.Map;

public interface IDynamicService {

	/**
	 * 动态折线图构造方法
	 * 描述
	 * @author linkun
	 * @created 2019年9月23日 下午9:10:18
	 * @param str		折线图参数
	 * @param title		折线图title
	 * @return
	 * @throws Exception
	 */
	public BaseZXTs zxt(String str, String title) throws Exception;
	
	/**
	 * 动态折线图构造方法
	 * 描述
	 * @author linkun
	 * @created 2019年9月23日 下午9:10:18
	 * @param str		折线图参数
	 * @param title		折线图title
	 * @return
	 * @throws Exception
	 */
	public BaseZXTs zxt2(String str, String title) throws Exception;
	
	/**
	 * 获取排序后的数据列表
	 * 描述
	 * @author linkun
	 * @created 2019年11月6日 下午3:29:02
	 * @param redisModuleKey
	 * @return
	 * @throws Exception
	 */
	public JSONArray getSortedDatasReverseOrder(String redisModuleKey) throws Exception;

	/**
	 * 中心 关键微服务，关键api
	 * 描述
	 * @author linkun
	 * @created 2019年11月12日 上午12:23:03
	 * @return
	 * @throws Exception
	 */
	public Map<String, FronCenterMicroserviceApiInfo> getFrontCenterMicroserviceApiInfos() throws Exception;
	/**
	 * 中心微服务信息
	 * 描述
	 * @author linkun
	 * @created 2019年11月12日 上午12:23:25
	 * @return
	 * @throws Exception 
	 */
	public List<List<FrontCenterInfo>> getFrontCenterInfos() throws Exception;
	/**
	 * 微服务其他信息
	 * 描述
	 * @author linkun
	 * @created 2019年11月12日 上午12:40:41
	 * @return
	 * @throws Exception 
	 */
	public List<List<FrontChannelOtherInfo>> getChannelOtherInfos() throws Exception;

	public List<FrontVisualmachineAlocatInfo> getVisualmachineAlocatInfo() throws Exception;

	public List<FrontResourceAllocatedInfo> getResourceAllocatedInfo() throws Exception;
	
	public JSONArray getList4RedisKey(String redisModuleKey)throws Exception;
	
}
