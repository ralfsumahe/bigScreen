# 业务监控大屏  java后台+echart.js前台
	业务监控大屏  java后台+echart.js前台
	111111111
	地址
	http://localhost:18083/screen01.html
	http://localhost:18083/screen02.html
	http://localhost:18083/screen03.html
	http://localhost:18083/screen04.html
	http://localhost:18083/screen.html      四个图的轮播
	http://localhost:18083/screenXs.html    吞吐量、容器数演示轮播页面
	使用技术
	echart.js		用来绘制折线图、仪表盘
	vue.js		用来绘制表格，或者动态组织页面
	模版模式	用来统一构造redis数据
	22222222222222222
	实现：
	1.折线图
	2.仪表盘
	33333333
	原理：
	1.定时调度存储数据到redis
		使用了模版模式，将所有的添加数据制作成统一的操作方式
		BigScreenPojoDataOperator operator = new BigScreenPojoDataOperator(dynamicPojoDataHandler, info);
			operator.operate(now, "resource_allocation_rate");
			该rediskey会保存两个
			{redisKey}_list     表示随着时间的值数组    time -> pojo
			{redisKey}_current  表示当前的值           pojo
	2.controller从redis获取数据，组装echart.js所需要的格式，展现折线图和仪表盘
	44444444
	redis数据格式：
	折线图
    ALL:all:BUSINESS_list
    {
      "2019-11-29 23:30:25_30:25": {
        "avgrespontime": 91.0,
        "success": 93.0,
        "req": 23906.0
      },
      "2019-11-29 23:32:10_32:10": {
        "avgrespontime": 96.0,
        "success": 91.0,
        "req": 34258.0
      }
    }
    
	仪表盘
    {
      "normal": 110,
      "title": "节点健康度",
      "total": 110,
      "value": 100.0
    }
	dynamicPojo1_current
	表示当前的值           pojo
	{
		"cpu": 18.1,
		"disk": 69.1,
		"memery": 66.55
	}

	dynamicPojo1_list
	表示随着时间的值数组    time -> pojo
	{
		"2019-11-30 00:21:40_21:40": {
			"disk": 51.92,
			"memery": 68.17,
			"cpu": 27.42
		},
		"2019-11-30 00:22:45_22:45": {
			"disk": 87.26,
			"memery": 20.17,
			"cpu": 53.53
		},
		"2019-11-30 00:19:25_19:25": {
			"disk": 58.15,
			"memery": 45.28,
			"cpu": 84.66
		},
		"2019-11-30 00:23:00_23:00": {
			"disk": 82.64,
			"memery": 73.09,
			"cpu": 50.95
		},
		"2019-11-30 00:22:05_22:05": {
			"disk": 96.81,
			"memery": 83.75,
			"cpu": 99.95
		}
	}

