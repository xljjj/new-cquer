<template>
	<div class="container">
		<section id="img-one" class="img">
			<h1 id="h1">H I !</h1>

		</section>
		<section class="content-one">
			<div class="text-box">
				<div class="cnt">
					<h2>重庆大学图书馆</h2>
					<p>一栋红色建筑，深厚而优雅</p>
					<br />
					<p>
						<a
							target="_blank"
							rel="noopener noreferrer"
							href="https://baike.baidu.com/item/%E9%87%8D%E5%BA%86%E5%A4%A7%E5%AD%A6%E5%9B%BE%E4%B9%A6%E9%A6%86/2263385"
							class="btn"
						>
							find <em>more</em>
						</a>
					</p>
				</div>
			</div>
		</section>
		<section class="content-two">
			<div class="text-box">
				<div class="cnt">
					<h2>第一教学楼</h2>
					<p>我们执笔奋斗的地方</p>
					<br />
					<p>
						<a
							target="_blank"
							rel="noopener noreferrer"
							href="http://jjc.cqu.edu.cn/info/1020/1222.htm"
							class="btn"
							>find <em>more</em></a
						>
					</p>
				</div>
			</div>
		</section>
		<section class="content-three">
			<div class="text-box">
				<div class="cnt">
					<h2>书屋</h2>
					<p>属于我们的宁静</p>
					<br />
					<p>
						<a
							target="_blank"
							rel="noopener noreferrer"
							href="http://huxi.cqu.edu.cn/page/2683791b75adf967"
							class="btn"
							>find <em>more</em></a
						>
					</p>
				</div>
			</div>
		</section>
		<section class="content-four">
			<div class="text-box">
				<div style="text-align: center" class="cnt">
					<h2>What's past, is prologue</h2>
					<p></p>
					<br />
					<p>
						<a style="opacity: 0.8" @click="handleClick" class="btn"
							>来看看同学们吧！</a
						>
					</p>
				</div>
			</div>
		</section>
	</div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import axios from 'axios'
import qs from 'qs'      //引入qs
import { useRouter } from 'vue-router'
import {onMounted,onBeforeUpdate,onUpdated,onBeforeMount,onBeforeUnmount,onUnmounted,computed,watch } from "vue";
const account = sessionStorage.getItem('account')

const router = useRouter()
const handleClick = () => {
	router.push('/home')
}



onMounted( ()=>{
    axios
		.post('/api/student/getSort', qs.stringify(
            {account: account}
        ))
		.then((res) => {
			console.log(res)
			if (res.data.code === 200) {
                ElMessage({
                    message: `您是第${res.data.data[0]}个报到的重大学子`,
                    type: 'success',
                }),
                ElMessage({
                    message: `您有${res.data.data[1]}个已报道同专业的新同学`,
                    type: 'success',
                }),
                ElMessage({
                    message: `您有${res.data.data[1]}个已报到的老乡`,
                    type: 'success',
                })
                    
 
                
			}
		})
		.catch((error) => {
			console.log(error)
		})
})



</script>
<style scoped>
.container {
	width: 100vw;
	height: auto;
    max-width: 1520px;
}

section {
	height: 100vh;
	position: relative;
	color: rgba(255, 255, 255, 0.8);
	font-size: 10vh;
	/* 设置字体 */
	font-family: 'modern_no._20regular', serif;
	/* 文字阴影 */
	text-shadow: 4px 4px rgb(46, 43, 43);
	/* 弹性布局 */
	display: flex;
	/* 水平居中 */
	justify-content: center;
	/* 垂直居中 */
	align-items: center;
}

#h1 {
    font-size: 80px;
}

#idx {
	position: absolute;
	font-size: 40px;
	margin: 0 auto;
	padding: 0 auto;
    padding-top: 50px;
	/* bottom: 10%; */
	height: 50px;
}

.img {
	overflow: hidden;
	/* 背景图片不重复 */
	background-repeat: no-repeat;
	/* 背景图片位置：居中 */
	background-position: center;
	/* 背景图片固定 */
	background-attachment: fixed;
	background-size: cover;
	/* 禁止用户误选中 */
	user-select: none;
}

#img-one {
	background-image: url(@/assets/img/img2.jpg);
	background-size: cover;
}

#img-two {
	background-image: url(@/assets/img/img2.jpg);
}

.content-one {
	background: url(@/assets/img/img1.jpg) no-repeat fixed center;
	background-size: cover;
}

.content-two {
	background: url(@/assets/img/img4.jpg) no-repeat fixed center;
	background-size: cover;
}

.content-three {
	background: url(@/assets/img/img3.jpg) no-repeat fixed center;
	background-size: cover;
}

.content-four {
	background: url(@/assets/img/img2.jpg) no-repeat fixed center;
	background-size: cover;
}

.text-box {
	width: 100%;
	height: 50%;
	/* 绝对定位 */
	position: absolute;
	bottom: 20%;
	/* 文字居中 */
	text-align: center;
	background-color: rgba(0, 0, 0, 0.3);
	/* 旋转中心 */
	transform-origin: center bottom;
	/* 扭曲斜切 */
	transform: skew(0, -8deg);
}

.text-box .cnt {
	display: inline-block;
	text-align: right;
	margin: 50px 0 10px;
	width: 90%;
	max-width: 990px;
	transform-origin: right bottom;
	transform: skew(0, 8deg);
}

.cnt h2 {
	margin-top: 100px;
	font-size: 36px;
	font-family: 'modern_no._20regular', serif;
	text-shadow: 1px 0px 0px #323232;
	letter-spacing: 0.3em;
	/* 大写字母 */
	text-transform: uppercase;
	color: #fff;
	margin-bottom: 5px;
}

.cnt p {
	font-size: 20px;
	line-height: 1.7;
	padding-top: 10px;
	margin-bottom: 10px;
	color: #fff;
}

a.btn {
	font-size: 90%;
	font-family: 'modern_no._20regular', serif;
	letter-spacing: 0.3em;
	text-shadow: 1px 0px 0px black;
	line-height: 2.5;
	display: inline-block;
	background-color: #eaeaea;
	color: #000;
	border: 3px solid rgb(147, 146, 146);
	white-space: nowrap;
	text-decoration: none;
	padding: 0 20px;
}

/* .btn {
    position: absolute;
    bottom: 20%;
    width: 100px;
    height: 50px;
}

#btn button {
    width: 100%;
    height: 100%;
} */
</style>
