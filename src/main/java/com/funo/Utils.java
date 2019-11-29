package com.funo;

import com.alibaba.fastjson.JSONObject;

public class Utils {

	public static Object getValue(JSONObject rootJo,String keys) throws Exception{
		JSONObject jo = rootJo;
		if(keys.split("\\.").length == 1){
			return jo.get(keys);
		}
		String jsonKeys = keys.substring(0, keys.lastIndexOf("."));
		String valueKey = keys.substring(keys.lastIndexOf(".")+1);
		jo = getJSONObject(jo, jsonKeys);
		return jo.get(valueKey);
	}
	
	/**
	 * 根据keys值获取jsonObject
	 * 描述
	 * @author linkun
	 * @created 2018年10月24日 下午3:35:44
	 * @param jo
	 * @param keys
	 * @return
	 * @throws Exception 
	 */
	public static JSONObject getJSONObject(JSONObject rootJo,String keys) throws Exception{
		JSONObject jo = rootJo;
		if(keys.split("\\.").length == 1){
			return jo.getJSONObject(keys);
		}
		String[] keyArray = keys.split("\\.");
		for(String key:keyArray){
			if(!jo.containsKey(key)){
				throw new Exception("根据key值获取jsonObject时，key："+key+"不存在");
			}
			jo = jo.getJSONObject(key);
		}
		return jo;
	}
	
	public static String getRedisModuleKey(GroupType groupType,String name,DataType dataType) {
		return groupType.name()+":"+name+":"+dataType.name();
	}
	
	public static void main(String[] args) {
		System.out.println(getRedisModuleKey(GroupType.API,"service_1",DataType.BUSINESS));
	}
}
