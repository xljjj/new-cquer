var Chart_AiHaoTongJi = echarts.init(document.getElementById('AiHaoTongJi'));
						function drawChart_AiHaoTongJi(hobbyNum){
							let resultData = {
							status: 'success',
							data: [
								{
									name: '运动类',
									value: hobbyNum[0],
								},
								{
									name: '娱乐类',
									value: hobbyNum[1],
								},
								{
									name: '社交类',
									value: hobbyNum[2],
								},
								{
									name: '智力类',
									value: hobbyNum[3],
								},
								{
									name: '收藏类',
									value: hobbyNum[4],
								},
								{
									name: '乐器类',
									value: hobbyNum[5],
								},
								{
									name: '文艺类',
									value: hobbyNum[6],
								},
								{
									name: '其他类',
									value: hobbyNum[7],
								},
								



							],
							msg: 'exercitation in',
						};

                        // 颜色库
						let colorList = [
                            //  颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
							new echarts.graphic.LinearGradient(0, 0, 1, 1, [
								{
									offset: 0,
									color: 'rgba(59, 181, 182, 1)',
								},
								{
									offset: 1,
									color: 'rgba(66, 227, 151, 0.2)',
								},
							]),
							new echarts.graphic.LinearGradient(1, 0, 0, 1, [
								{
									offset: 0,
									color: 'rgba(254, 220, 69, 1)',
								},
								{
									offset: 1,
									color: 'rgba(251, 112, 153, 0.2)',
								},
							]),
							new echarts.graphic.LinearGradient(0, 1, 1, 0, [
								{
									offset: 0,
									color: 'rgba(0, 138, 255, 1)',
								},
								{
									offset: 1,
									color: 'rgba(0, 216, 255, 0.2)',
								},
							]),
							new echarts.graphic.LinearGradient(0, 0, 1, 1, [
								{
									offset: 0,
									color: 'rgba(246, 191, 159, 1)',
								},
								{
									offset: 1,
									color: 'rgba(219, 138, 222, 0.2)',
								},
							]),
							new echarts.graphic.LinearGradient(1, 0, 0, 1, [
								{
									offset: 0,
									color: 'rgba(247, 138, 158, 1)',
								},
								{
									offset: 0.5,
									color: 'rgba(245, 111, 135, 0.5)',
								},
								{
									offset: 1,
									color: 'rgba(254, 152, 139, 0.2)',
								},
							]),

						];
						let colorListLen = colorList.length;

						// 生成随机坐标的不重叠圆
                        // maxLength：圆的最多数量，radius：圆的默认半径，max：x、y可能的最大值
						function drawCircles(maxLength, radius, max_x, max_y) {
							let circles = [];
							let anti_crash_count = 0;
							while (circles.length < maxLength) {
                                // 生成圆的x，y，半径
								let circle = {
									x: getRandomNumber(radius, max_x - radius),
									y: getRandomNumber(radius, max_y - radius),
									radius,
								};

                                // 判断是否重叠
								let isOverlapping = false;
								for (let j = 0; j < circles.length; j++) {
									let previous_circle = circles[j];
									let distance = Math.hypot(circle.x - previous_circle.x, circle.y - previous_circle.y);

									if (distance < circle.radius + previous_circle.radius) {
										isOverlapping = true;

									}
								}
								if (!isOverlapping) {
									circles.push(circle);
								}
								anti_crash_count++;
                                // 重叠次数过多终止
								if (anti_crash_count > 100000) {
									break;
								}
							}
							return circles;
						}

						// 生成随机数坐标
						function getRandomNumber(min, max) {
							return Math.floor(Math.random() * (max - min) + min);
						}
						// 按value从大到小排序
						let countList = resultData.data.sort(function(a,b){return b.value-a.value;});
						var showData = [];
						var max = countList[0].value;
						
						// 放大规则
						var number = Math.round(max * 0.5);
                        // 获取当前区域x、y的最大值
						let graphCanvas = document.getElementById('AiHaoTongJi').getBoundingClientRect();
						let randomCircleArr = drawCircles(
							countList.length,
							40,
							graphCanvas.width,
							graphCanvas.height
						);
                        // 生成标签设置
						countList.forEach((e, i) => {
                            e.id = i;
							e.label = {
								normal: {
									show: true,
									color: '#fff',
								},
							};
							e.itemStyle = {
								normal: {
									color: colorList[Math.floor(Math.random() * colorListLen)],
									shadowBlur: 16,
									shadowOffsetY: 16,
									shadowColor: 'rgba(0,0,0,0.1)',
								},
							};
							if (randomCircleArr[i]) {
								e.x = randomCircleArr[i].x;
								e.y = randomCircleArr[i].y;
								e.symbolSize = ((e.value + number) / max) * 40;
								e.label.normal.fontSize = ((e.value + number) / max) * 10;
							} else {
								e.symbolSize = 0;
								e.x = 0;
								e.y = 0;
							}
						});

						option_AiHaoTongJi = {
							tooltip: {
								trigger: 'item',
								formatter: function (params) {
									if (params['data']['name'] !== '') {
										return '<b>' + params['data']['name'] + '</b>：<b>' + params['data']['value'] + ' </b>';
									}
								},
							},
							series: [
								{
									name: '爱好统计',
									type: 'graph',
									layout: 'none',
									label: {
										show: true,
										normal: {
											color: '#fff',
										},
									},
                                    // 将上面设置好的data放入series
									data: countList,
								},
							],
						};

						Chart_AiHaoTongJi.setOption(option_AiHaoTongJi);
						}
						drawChart_AiHaoTongJi([8,7,6,5,4,3,2,1]);