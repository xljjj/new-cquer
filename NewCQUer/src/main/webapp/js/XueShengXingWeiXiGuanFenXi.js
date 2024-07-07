var Chart_XingWeiXiGuan = echarts.init(document.getElementById('XingWeiXiGuan'));
                        var student_num = 10;
						option_XingWeiXiGuan = {
							backgroundColor: '',
							"normal": {
								"top": 200,
								"left": 300,
								"width": 500,
								"height": 400,
								"zIndex": 6,
								"backgroundColor": ""
							},
							"color": ["rgba(245, 166, 35, 1)", "rgba(19, 173, 255, 1)"],
							
							"tooltip": {
								"show": true,
								"trigger": "item"
							},
							"radar": {
								"center": ["50%", "50%"],
								"radius": "70%",
								"startAngle": 90,
								"splitNumber": 4,
								"shape": "circle",
								"splitArea": {
									"areaStyle": {
										"color": ["transparent"]
									}
								},
								"axisLabel": {
									"show": false,
									"fontSize": 8,
									"color": "#fff",
									"fontStyle": "normal",
									"fontWeight": "normal"
								},
								"axisLine": {
									"show": true,
									"lineStyle": {
										"color": "white"//
									}
								},
								"splitLine": {
									"show": true,
									"lineStyle": {
										"color": "white"//
									}
								},
								"indicator": [{
									"name": "运动类",
									"max": student_num
								}, {
									"name": "娱乐类",
									"max": student_num
								}, {
									"name": "社交类 ",
									"max": student_num
								}, {
									"name": "智力类",
									"max": student_num
								}, {
									"name": "收藏类",
									"max": student_num
								}, {
									"name": "乐器类",
									"max": student_num
								}, {
									"name": "文艺类",
									"max": student_num
								}, {
									"name": "其他类",
									"max": student_num
								}]
							},
							"series": [{
								"name": "",
								"type": "radar",
								"symbol": "circle",
								"symbolSize": 5,
								"areaStyle": {
									"normal": {
										"color": "rgba(19, 173, 255, 0.5)"
									}
								},
								"itemStyle": {
									"color": 'rgba(19, 173, 255, 1)',
									"borderColor": 'rgba(19, 173, 255, 0.4)',
									"borderWidth": 10,
								},
								"lineStyle": {
									"normal": {
										"type": "dashed",

										"color": "rgba(19, 173, 255, 1)",
										"width": 2
									}
								},
								"data": [
									[80, 50, 55, 80, 50, 80, 48, 43]
								]
							}]
						};
						Chart_XingWeiXiGuan.setOption(option_XingWeiXiGuan);