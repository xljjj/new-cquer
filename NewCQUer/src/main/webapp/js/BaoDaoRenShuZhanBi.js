var Chart_BaoDaoRenShuZhanBi = echarts.init(document.getElementById('BaoDaoRenShuZhanBi'));
						var getvalue = [8];
						var studentNum=100;

						var option_BaoDaoRenShuZhanBi = {
							title: {
								text: getvalue + '%',
								textStyle: {
									color: '#28BCFE',
									fontSize: 25
								},
								itemGap: 20,
								left: 'center',
								top: 'center'
							},
							tooltip: {
								formatter: function (params) {
									return '<span style="color: #fff;">报道人数占比：' + getvalue + '%</span>';
								}
							},
							angleAxis: {
								max: 100,
								clockwise: true, 
								// 隐藏刻度线
								show: false
							},
							radiusAxis: {
								type: 'category',
								show: true,
								axisLabel: {
									show: false,
								},
								axisLine: {
									show: false,

								},
								axisTick: {
									show: false
								},
							},
							polar: {
								center: ['50%', '50%'],
								radius: '100%' //图形大小
							},
							series: [{
								type: 'bar',
                                // z:"-1",
								data: getvalue,
                                barGap: "-100%",
								showBackground: true,
								backgroundStyle: {
									color: '#BDEBFF',
								},
								coordinateSystem: 'polar',
								roundCap: true,
								barWidth: 30,
								itemStyle: {
									normal: {
										opacity: 1,
										color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
											offset: 0,
											color: '#25BFFF'
										}, {
											offset: 1,
											color: '#5284DE'
										}]),
										shadowBlur: 5,
										shadowColor: '#2A95F9',
                                        borderColor: "rgba(61, 44, 147, 1)",
                                        borderWidth: 0.5
									}
								},
							},
                            {
								type: 'bar',
								data: [100],
								showBackground: true,
								backgroundStyle: {
									color: '#BDEBFF',
								},
								coordinateSystem: 'polar',
								roundCap: true,
								barWidth: 30,
								itemStyle: {
									normal: {
										opacity: 0.2,
										color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
											offset: 0,
											color: '#25BFFF'
										}, {
											offset: 1,
											color: '#5284DE'
										}]),
										shadowBlur: 5,
										shadowColor: '#2A95F9',
                                        borderColor: "rgba(61, 44, 147, 1)",
                                        borderWidth: 0.5
									}
								},
							}
                        ]
						};
                        
						Chart_BaoDaoRenShuZhanBi.setOption(option_BaoDaoRenShuZhanBi);