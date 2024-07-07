var Chart_DiTu = echarts.init(document.getElementById('DiTu'));
								var outname=['北京','天津','河北','山西','内蒙古','辽宁','吉林','黑龙江','上海','江苏','浙江','安徽','福建','江西','山东','河南','湖北','湖南','广东','广西','海南','重庆','四川','贵州','云南','西藏','陕西','甘肃','青海','宁夏','新疆','台湾','香港','澳门','南海诸岛'];
								var outvalue = [23,45,33,178,4,55,7,4,33,57,23,45,35,34,24,34,67,56,45,34,32,33,33,99,67,46,47,47,36,56,43,578,55,23,0];
								var outdata = [];

								var max = 6000,
									min = 10;
								var maxSize4Pin = 100,
									minSize4Pin = 20;

								for (var i = 0; i < outname.length; i++) {
									outdata.push({
										name: outname[i],
										value: outvalue[i]
									})
								}

								var geoCoordMap = {};
								/*获取地图数据*/
								var mapFeatures = echarts.getMap('china').geoJson.features;
								//  console.log(mapFeatures)
								mapFeatures.forEach(function (v) {
									//console.info(v)
									// 地区名称
									var name = v.properties.name;
									// 地区经纬度
									geoCoordMap[name] = v.properties.cp;

								});
								var convertData = function (outdata) {
									var res = [];
									for (var i = 0; i < outdata.length; i++) {
										var geoCoord = geoCoordMap[outdata[i].name];
										if (geoCoord) {
											res.push({
												name: outdata[i].name,
												value: geoCoord.concat(outdata[i].value),
											});
										}
									}
									return res;
								};

								option_DiTu = {
									backgroundColor: '',
									tooltip: {
										show: true,
										formatter: function (params) {
											if (params.value.length > 1) {
												return '&nbsp;&nbsp;' + params.name + '&nbsp;&nbsp;&nbsp;' + params.value[2] + '人&nbsp;&nbsp;';
											} else {
												return '&nbsp;&nbsp;' + params.name + '&nbsp;&nbsp;&nbsp;' + params.value + '人&nbsp;&nbsp;';
											}
										},

									},

									geo: {
										map: 'china',
										show: true,
										roam: true,
										scaleLimit: { //滚轮缩放的极限控制
										      min: 1.2,
										      max: 1.2
										    },
										label: {
											emphasis: {
												show: false
											}
										},
										layoutSize: "100%",
										itemStyle: {
											normal: {
												borderColor: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
													offset: 0,
													color: '#00F6FF'
												}, {
													offset: 1,
													color: '#53D9FF'
												}], false),
												borderWidth: 3,
												shadowColor: 'rgba(10,76,139,1)',
												shadowOffsetY: 0,
												shadowBlur: 60
											}
										}
									},
									series: [{
										type: 'map',
										map: 'china',
										aspectScale: 0.75,
										roam: true,
										// zoom:1.1,
										// layoutSize:"50%",
										scaleLimit: { //滚轮缩放的极限控制
										      min: 1.2,
										      max: 1.2
										    },
										label: {
											normal: {
												show: false,
											},
											emphasis: {
												show: false,
											}
										},
										itemStyle: {
											normal: {
												areaColor: {
													x: 0,
													y: 0,
													x2: 0,
													y2: 1,
													colorStops: [{
														offset: 0,
														color: '#073684' // 0% 处的颜色
													}, {
														offset: 1,
														color: '#061E3D' // 100% 处的颜色
													}],
												},
												borderColor: '#215495',
												borderWidth: 1,
											},
											emphasis: {
												areaColor: {

													x: 0,
													y: 0,
													x2: 0,
													y2: 1,
													colorStops: [{
														offset: 0,
														color: '#073684' // 0% 处的颜色
													}, {
														offset: 1,
														color: '#061E3D' // 100% 处的颜色
													}],
												},
											}
										},
										data: outdata,
									}, {
										type: 'effectScatter',
										coordinateSystem: 'geo',
										rippleEffect: {
											brushType: 'stroke'
										},
										showEffectOn: 'render',
										itemStyle: {
											normal: {
												color: {
													type: 'radial',
													x: 0.5,
													y: 0.5,
													r: 0.5,
													colorStops: [{
														offset: 0,
														color: 'rgba(5,80,151,0.2)'
													}, {
														offset: 0.8,
														color: 'rgba(5,80,151,0.8)'
													}, {
														offset: 1,
														color: 'rgba(0,108,255,0.7)'
													}],
													global: false // 缺省为 false
												},
											}

										},
										label: {
											normal: {
												show: true,
												color: '#fff',
												fontWeight: 'bold',
												position: 'inside',
												formatter: function (para) {
													return '{cnNum|' + para.data.value[2] + '}'
												},
												rich: {
													cnNum: {
														fontSize: 13,
														color: '#D4EEFF',
													}
												}
											},
										},
										symbol: 'circle',
										symbolSize: function (val) {
											if (val[2] === 0) {
												return 0;
											}
											var a = (maxSize4Pin - minSize4Pin) / (max - min);
											var b = maxSize4Pin - a * max;
											return a * val[2] + b * 1.2;
										},
										data: convertData(outdata),
										zlevel: 1,
									}]
								};
								Chart_DiTu.setOption(option_DiTu);