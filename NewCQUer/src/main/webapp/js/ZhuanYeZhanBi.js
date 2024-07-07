var Chart_ZhuanYeZhanBi = echarts.init(document.getElementById('ZhuanYeZhanBi'));
						var option_ZhuanYeZhanBi = {
							xAxis: {
								type: 'category',
								axisLabel: {
									color: 'white'
								},
								data: ['计科','信安','物联网','软工'],
								splitLine: {
									show: false
								}
							},
							yAxis: {
								show:false,
								type: 'value',
								axisLabel: {
									color: 'white'
								},
								splitLine: {
									show: false
								}
							},
							series: [
								{
									data: [100,40,50,90],
									type: 'bar',
									color: 'rgb(163, 46, 155)',
									label: {
										show: true,
										position: "top",
										color: 'white'
									}
								}
							]
						};
						Chart_ZhuanYeZhanBi.setOption(option_ZhuanYeZhanBi);