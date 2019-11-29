package com.funo.test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.funo.vo.BaseZXT;
import com.funo.vo.BaseZXTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;


@Component
public class SLAServiceImplTest {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void addData() {
		String[] times = new String[] {"22:00","22:05","22:10","22:15","22:20","22:25","22:30","22:35",
				"22:40","22:45","22:50","22:55"};
		String[] centers = new String[] {"all","user","produce","intel"};
		String[] centerNames = new String[] {"系统","用户中心","产商品中心","互联网中心"};
		for(int j = 0;j < centers.length;j++) {
			String center = centers[j];
			String centerName = centerNames[j];
			String[] titles = new String[] {"吞吐量","成功率","平均时长","最大时长","时长"};
			String[] yTitles = new String[] {"吞吐量(次/分)","成功率(%)","平均时长(ms)","最大时长(ms)","时长(ms)"};
			String[] keys = new String[] {
					getSlaRedisKey(center, "req"),
					getSlaRedisKey(center, "success"),
					getSlaRedisKey(center, "avgrespontime"),
					getSlaRedisKey(center, "maxrespontime"),
					getSlaRedisKey(center, "respontime")
			};
			
			for(int i = 0;i < titles.length;i++) {
				String title = titles[i];
				String yTitle = yTitles[i];
				String key = keys[i];
				List<BaseZXT> datas = new ArrayList<>();
				if(title.indexOf("成功率")!=-1){
					BaseZXT info1 = new BaseZXT(title,new Double[] {99.1d,99.2d,98.3d,100d,100d,99.2d,100d,98.4d,99.8d,100d,100d,100d});
					datas.add(info1);
					BaseZXT info = new BaseZXT(title+"基线",new Double[] {100d,100d,100d,100d,100d,100d,100d,100d,100d,100d,100d,100d});
					datas.add(info);
				}else if(title.indexOf("吞吐量")!=-1) {
					BaseZXT info = new BaseZXT(title,new Double[] {10000d,8999d,12000d,8000d,10000d,12034d,8909d,10000d,8909d,10000d,8909d,8909d});
					datas.add(info);
					BaseZXT info1 = new BaseZXT(title+"基线",new Double[] {8999d,10000d,8909d,10000d,12034d,12034d,12034d,12034d,12034d,8909d,10000d,10000d});
					datas.add(info1);
				}else if(title.indexOf("最大时长")!=-1) {
					BaseZXT info = new BaseZXT(title,new Double[] {10d,12d,25d,25d,25d,16d,18d,33d,24d,30d,15d,23d});
					datas.add(info);
				}else if(title.indexOf("平均时长")!=-1) {
					BaseZXT info = new BaseZXT(title,new Double[] {0.2d,0.03,0.1d,0.08d,0.08d,0.15d,0.3d,0.09d,0.44d,0.345d,0.056d,0.077d});
					datas.add(info);
					BaseZXT info1 = new BaseZXT(title+"基线",new Double[] {0.03d,0.1d,0.08d,0.15d,0.15d,0.09d,0.09d,0.44d,0.15d,0.15d,0.08d,0.08d});
					datas.add(info1);
				}else{
					BaseZXT info = new BaseZXT(title,new Double[] {0.2d,0.03,0.1d,0.08d,0.08d,0.15d,0.3d,0.09d,0.44d,0.345d,0.056d,0.077d});
					datas.add(info);
					BaseZXT info1 = new BaseZXT(title+"基线",new Double[] {0.03d,0.1d,0.08d,0.15d,0.15d,0.09d,0.09d,0.44d,0.15d,0.15d,0.08d,0.08d});
					datas.add(info1);
				}
				
				BaseZXTs statics = new BaseZXTs(times,title,"时间",yTitle,datas);
				
				redisTemplate.opsForValue().set(key, JSON.toJSONString(statics), 100, TimeUnit.MINUTES);
				System.out.println(redisTemplate.opsForValue().get(key));
			}
			
		}
		
		
	}
	
	private String getSlaRedisKey(String center,String target) {
		return "zxt_sla"+"_"+center+"_"+target;
	}

}
