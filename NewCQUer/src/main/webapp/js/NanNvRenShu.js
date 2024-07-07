var Chart_NanNvRenShu = echarts.init(document.getElementById('NanNvRenShu'));
								option_NanNvRenShu = {
									backgroundColor: '',
									xAxis: {
										type: 'category',
										data: ["总计人数", "男生人数", "女生人数"],
										axisLabel: {
											show: true,
											textStyle: {
												color: '#fff'
											},
											fontSize: 15
										},
										offset: -20,
										axisLine: {
											show: false,
											onzero: false,
										}
									},
									yAxis: {
										type: 'value',
										show: false
									},
									series: [
										{
											data: [120, 200, 150],
											type: 'bar',
											label: {
												show: true,
												position: "insideBottom",
												fontSize: 25,
												offset: [0, -20]
											},
											itemStyle: {
												color: 'rgba(128, 128, 128, 0)'
											}
										}
									]
								};
								Chart_NanNvRenShu.setOption(option_NanNvRenShu);