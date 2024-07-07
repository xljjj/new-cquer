var Chart_NianLingZhanBi = echarts.init(document.getElementById('NianLingZhanBi'));
						
						var option_NianLingZhanBi = {
							tooltip: {
								trigger: 'item',
								formatter: '{a} <br/>{b} : {c} ({d}%)'
							},
							legend: {
								show: true,
								padding: [0, -50, 0, 0],
								align: "left",
								x: 'left', //居左显示
								orient: "vertical",
								top: '5%',
								textStyle: {
									color: 'white'
								}
							},
							series: [
								{
									name: '年龄：',
									type: 'pie',
									// top:'10%',
									radius: ['40%', '80%'],
									center: ["60%", "50%"],
									avoidLabelOverlap: false,
									itemStyle: {
										borderRadius: 10,
										borderColor: '#fff',
										borderWidth: 2
									},
									label: {
										show: true,
										formatter:function(data){ return data.percent.toFixed(0)+"%";} ,
										// formatter: '{d}%',
										position: 'inside'
									},
									emphasis: {
										label: {
											show: true,
											fontSize: '10',
											fontWeight: 'bold'
										}
									},
									labelLine: {
										show: false
									},
									data: [
										{ value: 1048, name: '15岁及以下' },
										{ value: 735, name: '16-18岁' },
										{ value: 580, name: '18-22岁' },
										{ value: 484, name: '22-24岁' },
										{ value: 300, name: '25岁及以上' }
									]
								}
							]
						};

						Chart_NianLingZhanBi.setOption(option_NianLingZhanBi);