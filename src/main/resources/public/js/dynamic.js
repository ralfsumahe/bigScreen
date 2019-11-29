/**
	 * 
	 * @param domId
	 * @param lineType  来源于data-linetype  line 线条  bar 柱体
	 * @param isAreaStyle 来源于data-isareastyle 是否需要线下的阴影面积  true 有 false 无
	 * @param isQx       来源于data-isqx  是否是平滑曲线   true 曲线 false 折线
	 * @param min 		来源于data-min y轴最小值 
	 * 
	 * @param title
	 * @param xtitle
	 * @param ytitle
	 * @param datatitles
	 * @returns
	 */
	function createZxtDynamic(domId,zxt) {
		var paramsList = ["linetype","isareastyle","isqx","max","min","title","xtitle","ytitle","datatitles","data"];
		var params = new Object();
		for(var i=0;i < paramsList.length;i++){
			var paramKey = paramsList[i];
			var paramValue = zxt.data(paramKey);
			params[paramKey] = paramValue;
		}
		
		var colors = ['#00B4F0','#CDCD00','#FF8C69','#E52E53','#79EB1F'];
		
		//基线相关配置
		var jxcolor = colors[colors.length-1];
		params["jxcolor"]=jxcolor;
		var jxlineType = "line";
		params["jxlineType"] = jxlineType;
		var jxisAreaStyle = false;
		params["jxisAreaStyle"] = jxisAreaStyle;
		//基线相关配置完成
		
		var isQx = params["isqx"]!=false?true:params["isqx"];
		var min = params["min"];
		var max = params["max"];
		
		params["colors"] = colors;
		
		
		
		
		// 基于准备好的dom，初始化echarts实例
		var zxtChart = echarts.init(document.getElementById(domId));
		var option = {
			title : {
//				text:'随时间变化的折线图',
				textStyle:{
					color:'#00E5FE'
				}
			},
			tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['线条1'],
		        textStyle:{
		        	color :'#00B5F1',
		        },
		        right :'35%',
		        top:'28px',
		        //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'
		        icon :'circle'
		    },
		    grid:{
		    	show :false
		    },
			xAxis : {
				name:"时间",
				type : 'category',
				data : [],
				axisLine :{
					lineStyle :{
						color : '#00B5F1'
					}
				},
			},
			yAxis : {
				name:'数值',
				type : 'value',
				axisLine:{
					lineStyle:{
						color : '#00B5F1'
					}
				},
				splitLine:{
		            show:false
		        },
		        min: min,
		        max: max,
		        nameTextStyle:{
		        	fontSize :20,
		        	fontWeight :'bolder'
		        }
			},
			series : [ {
				name : "线条1",
				data : [],
				type : 'line',
				smooth:isQx,
				areaStyle: {normal: {}}
			}]
		};
		
		var option1 = {};
		var dates = [];
		var datas = [];
		var datas1 = [];
		for(var i = 0;i < 30;i++){
			dates[i] = '';
			datas[i] = 0;
			datas1[i] = 0;
		}
		$.post(addParamTime("/demo/"+domId),{
			data:params["data"]
		},function(data){
			drawZxt(option,data,params,zxtChart);
		});
		
		
		var interval = setInterval(
				function() {
					var time = new Date().getTime();
					$.post(addParamTime("/demo/"+domId),{
						data:params["data"]
					},function(data){
						drawZxt(option,data,params,zxtChart);
					});
				}, 5000);
		zxt[0].interval = interval;
	}
	
	
	/**
	 * 画出折线图
	 * @param option
	 * @param data
	 * @returns
	 */
	function drawZxt(option,data,params,zxtChart){
		var lineType = params["linetype"]?params["linetype"]:"line";
		var isAreaStyle = false;
		var title = params["title"];
		var xtitle = params["xtitle"];
		var ytitle = params["ytitle"];
		var datatitles = params["datatitles"]?params["datatitles"].split(","):null;
		
		var jxcolor = params["jxcolor"];
		var jxlineType = params["jxlineType"];
		var jxisAreaStyle = params["jxisAreaStyle"];
		var colors = params["colors"];
		var isQx = params["isqx"]!=false?true:params["isqx"];
		
		
//		option.title.text = data.title;
		option.legend.data = datatitles?datatitles:data.dataTitles;
		option.xAxis.name = "";//xtitle?xtitle:data.xtitle;
		option.xAxis.data = data.times;
		option.yAxis.name = "      "+(ytitle?ytitle:data.ytitle);
		option.series = new Array();
		for(var i = 0;i < data.dataTitles.length;i++){
			var st = data.datas[i];
			var lineType1 = data.datas[i].type?data.datas[i].type:lineType;
			var color1 = colors[i];
			var isAreaStyle1 = data.other&&data.other["isAreaStyle"]?data.other["isAreaStyle"]:false;
			/*if(option.legend.data[i].indexOf("基线")!=-1){
				lineType1 = jxlineType;
				color1 = jxcolor;
				isAreaStyle1 = jxisAreaStyle;
			}*/
			option.series.push($.extend({
				name : "线条1",
				data : [],
				type : lineType1,
				yAxisIndex:data.datas[i].yAxisIndex,
				smooth:isQx,
				barWidth:data.other&&data.other["barWidth"]?data.other["barWidth"]:null,
				areaStyle: isAreaStyle1?{
					color:{
					    type: 'linear',
					    x: 0,
					    y: 0,
					    x2: 0,
					    y2: 1,
					    colorStops: [{
					        offset: 0, color: colors[i] // 0% 处的颜色
					    }, {
					        offset: 1, color: '#00025E' // 100% 处的颜色
					    }],
					    global: false // 缺省为 false
					}
				}:null
			},{
				name :option.legend.data[i],
				data :st.datas,
				color:color1
			}));
		}
		if(data.yinfos){
			option.yAxis = new Array();
			for(var i = 0 ;i < data.yinfos.length;i++){
				var yInfo = data.yinfos[i];
				var yfontSize = yInfo.fontSize?yInfo.fontSize:20;
				option.yAxis.push($.extend({
					name:'数值',
					type : 'value',
					axisLine:{
						lineStyle:{
							color : '#00B5F1'
						}
					},
					splitLine:{
			            show:false
			        },
			        nameTextStyle:{
			        	fontSize :yfontSize,
			        	fontWeight :'bolder'
			        }
				},{
					name:yInfo["name"],
					min:yInfo["min"],
					max:yInfo["max"],
					position:yInfo["position"],
					offset:yInfo["offset"]
				}));
				
			}
		}
		option.tooltip= {
	        trigger: 'axis',
//	        axisPointer: {
//	            type: 'cross'
//	        }
	    };
		option.grid={
			right: "25%"
		};
		zxtChart.setOption(option,true);
	}
	
	/**
	 * 添加一个时间常数
	 * @returns
	 */
	function addParamTime(url){
		var time = new Date().getTime();
		if(url.indexOf("?")!=-1){
			url+="&"+time;
		}else{
			url +="?"+time;
		}
		return url;
	}
	
	function createYbp(domId) {

		// 基于准备好的dom，初始化echarts实例
		var ybpChart = echarts.init(document.getElementById(domId));

		// 指定图表的配置项和数据
		var option = {
			title : {
				bottom:10,
				left:'25%',
				textStyle:{
					color:"#fff",
				}
			},
			tooltip : {
				formatter : "{c}%"
			},
			toolbox : {
				feature : {
					restore : {},
					saveAsImage : {}
				}
			},
			series : [ {
				name : '健康度',
				type : 'gauge',
				detail : {
					formatter : '{value}%',
					fontSize : 30,
					fontFamily  :'Microsoft YaHei',
					offsetCenter :[0,0]
				},
				radius:'100%',
				data : [ {
					value : 0
				} ],
				axisLine: {
		            show: true,
		            lineStyle: {
		                width:'18',
		                color: [[1, '#0D529C']]

		            }
		        },
		        splitLine:{
		        	show :false
		        },
		        pointer :{
		        	show :false
		        },
		        axisLabel :{
		        	show:false
		        },
		        axisTick :{
		        	show:false
		        }
			} ]
		};
		$.get(addParamTime("/demo/"+domId),function(data){
			option.series[0].data[0].value = data.value;
//			option.title.text = data.title;
			if(data.value > 90){
				option.series[0].axisLine.lineStyle.color = [[data.value/100,'red'],[1,'#0D529C']];
			}else{
				option.series[0].axisLine.lineStyle.color = [[data.value/100,'#04D9EC'],[1,'#0D529C']];
			}
			
			ybpChart.setOption(option, true);
		});

		setInterval(
			function() {
				$.get(addParamTime("/demo/"+domId),function(data){
					option.series[0].data[0].value = data.value;
//					option.title.text = data.title;
					if(data.value > 90){
						option.series[0].axisLine.lineStyle.color = [[data.value/100,'red'],[1,'#0D529C']];
					}else{
						option.series[0].axisLine.lineStyle.color = [[data.value/100,'#04D9EC'],[1,'#0D529C']];
					}
					ybpChart.setOption(option, true);
				});
			}, 5000);
	}
	//创建仪表盘
	function createYbp2(domId) {

		// 基于准备好的dom，初始化echarts实例
		var ybpChart = echarts.init(document.getElementById(domId));

		// 指定图表的配置项和数据
		var option = {
			title : {
//				text:'健康度',
				top:0,
				textStyle:{
					color:"#fff",
				}
			},
			tooltip : {
				formatter : "{c}%"
			},
			toolbox : {
				feature : {
					restore : {},
					saveAsImage : {}
				}
			},
			series : [ {
				name : '健康度',
				type : 'gauge',
				detail : {
					formatter : '{value}%',
					fontSize : 25,
					fontFamily  :'Microsoft YaHei',
					offsetCenter :[0,'20%'],
				},
				radius:'85%',
				startAngle:180,
				endAngle:0,
				splitNumber :5,
				data : [ {
					value : 0
				} ],
				axisLine: {
		            show: true,
		            lineStyle: {
		                width:'60',
		                color: [[1, '#0D529C']]

		            }
		        },
		        splitLine:{
		        	show :false
		        },
		        pointer :{
		        	length :60,
		        	show :true
		        },
		        itemStyle:{
		        	color:'#35E7F0'
		        },
		        axisLabel :{
		        	show:true,
		        	distance :-53,
		        	formatter :function(value){
		        		return parseInt(value);
		        	}
		        },
		        axisTick :{
		        	show:false
		        }
			} ]
		};
		$.get(addParamTime("/demo/"+domId),function(data){
			option.series[0].data[0].value = data.value;
//			option.series[0].max=data.total;
			option.series[0].detail.formatter=data.value+"%";
//			option.title.text = data.title;
			if(data.value < 90){
				option.series[0].axisLine.lineStyle.color = [[data.value/100,'red'],[1,'#0D529C']];
			}else{
				option.series[0].axisLine.lineStyle.color = [[data.value/100,'#04D9EC'],[1,'#0D529C']];
			}
			
			option.series[0].axisLabel.formatter= function(value){
				return parseInt(parseInt(value)/100*data.total);
			}
			
			ybpChart.setOption(option, true);
		});

		setInterval(
			function() {
				var time = new Date().getTime();
				$.get(addParamTime("/demo/"+domId),function(data){
					option.series[0].data[0].value = data.value;
					option.series[0].detail.formatter=data.value+"%";
//					option.title.text = data.title;
					if(data.value < 90){
						option.series[0].axisLine.lineStyle.color = [[data.value/100,'red'],[1,'#0D529C']];
					}else{
						option.series[0].axisLine.lineStyle.color = [[data.value/100,'#04D9EC'],[1,'#0D529C']];
					}
					
					option.series[0].axisLabel.formatter= function(value){
						return parseInt(parseInt(value)/100*data.total);
					}
					
					ybpChart.setOption(option, true);
				});
			}, 5000);
	}