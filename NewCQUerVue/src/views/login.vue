<template>
	<div class="bigBox">
		<!-- 最外层的大盒子 -->
		<div class="box">
			<!-- 注册盒子 -->
			<div class="register-form">
				<!-- 标题盒子 -->
				<div class="title-box">
					<h1>登录</h1>
				</div>
				<!-- 输入框盒子 -->
				<el-form :model="loginForm" ref="loginFormRef" :rules="rules">
					<el-form-item prop="account">
						<el-input
							type="text"
							placeholder="学号"
							id="studentNumberInput"
							v-model="loginForm.account"
						/>
					</el-form-item>
					<el-form-item prop="password">
						<el-input
							type="password"
							placeholder="密码"
							id="passwordInput"
							v-model="loginForm.password"
						/>
					</el-form-item>
				</el-form>
				<!-- 切换学生登录和管理员登录 -->
					<el-radio-group v-model="loginSwitch">
						<el-radio :label="0" size="large">学生登录</el-radio>
						<el-radio :label="1" size="large">管理员登录</el-radio>
					</el-radio-group>
				<!-- 按钮盒子 -->
				<div class="btn-box">
					<button @click="login">登录</button>
				</div>
			</div>
		</div>
	</div>
</template>
<script setup>
import { reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import axios from 'axios'
import { useRouter } from 'vue-router'
import qs from 'qs' //引入qs
import api from '../api/login'

let loginSwitch=ref(0)

const loginForm = reactive({
	account: '',
	password: '',
})
const loginFormRef = ref('')
const rules = reactive({
	account: [
		{ required: true, message: '输入用户名', trigger: 'blur' },
		{
			min: 3,
			max: 12,
			message: '长度限制:3~12',
			trigger: 'blur',
		},
	],
	password: [
		{ required: true, message: '输入密码', trigger: 'blur' },
		{ min: 3, message: '长度至少需要3位', trigger: 'blur' },
	],
})

const router = useRouter()

const login = () => {
	loginFormRef.value.validate((valid) => {
		if (valid) {
			if (loginSwitch._value==0){
				axios
				.post('/api/student/login', qs.stringify(loginForm))
				.then((res) => {
					console.log(res)
					if (res.data.code === 200) {
						ElMessage({
							showClose: true,
							message: '登录成功!',
							type: 'success',
						})
						sessionStorage.setItem('account', loginForm.account)
						sessionStorage.setItem('password', loginForm.password)
						router.push('' + res.data.data)
					} else if (res.data.code === 500) {
						ElMessage({
							showClose: true,
							message: '账号或密码错误!',
							type: 'error',
						})
					}
				})
				.catch((error) => {
					console.log(error)
				})
			}
			else{
				axios
				.post('/api/admin/login', qs.stringify(loginForm))
				.then((res) => {
					console.log(res)
					if (res.data.code === 200) {
						ElMessage({
							showClose: true,
							message: '登录成功!',
							type: 'success',
						})
						sessionStorage.setItem('account', loginForm.account)
						sessionStorage.setItem('password', loginForm.password)
						router.push('' + res.data.data)
					} else if (res.data.code === 500) {
						ElMessage({
							showClose: true,
							message: '账号或密码错误!',
							type: 'error',
						})
					}
				})
				.catch((error) => {
					console.log(error)
				})
			}
		} else {
			ElMessage({
				showClose: true,
				message: '检查一下咯',
				type: 'error',
			})
		}
	})
}
</script>

<style scoped>
/* 去除input的轮廓 */
input {
	outline: none;
}

li {
	list-style: none;
}

.bigBox {
	height: 100vh;
	/* 溢出隐藏 */
	overflow-x: hidden;
	display: flex;
	/* 渐变方向从左到右 */
	/* background: linear-gradient(to right,
            rgb(217, 192, 195),
            rgb(171, 201, 213)); */
	background-image: url(@/assets/img/img5.JPG);
	background-size: cover;
}

span {
	position: absolute;
	z-index: 0;
	bottom: 0;
	border-radius: 50%;
	/* 径向渐变 */
}

/* 最外层的大盒子 */
.box {
	width: 1050px;
	height: 600px;
	display: flex;
	/* 相对定位 */
	position: relative;
	z-index: 2;
	margin: auto;
	/* 设置圆角 */
	border-radius: 8px;
	/* 设置边框 */
	border: 1px solid rgba(255, 255, 255, 0.6);
	/* 设置盒子阴影 */
	box-shadow: 2px 1px 19px rgba(0, 0, 0, 0.1);
	/* background-color: grey; */
	/* opacity: 0.6; */
}

/* 滑动的盒子 */

/* 登录和注册盒子 */
.register-form {
	flex: 1;
	height: 100%;
}

/* 标题盒子 */
.title-box {
	/* padding-top: 30px; */
	height: 100px;
	line-height: 100px;
}
.el-input >>> .el-input__inner:focus::placeholder {
	opacity: 0;
}

/* 标题 */
.title-box h1 {
	margin-top: 15%;
	text-align: center;
	color: white;
	/* 禁止选中 */
	user-select: none;
	letter-spacing: 5px;
	text-shadow: 4px 4px 3px rgba(0, 0, 0, 0.1);
}

/* 输入框盒子 */
.el-form {
	/* padding-top: 10px; */
	display: flex;
	/* 纵向布局 */
	flex-direction: column;
	/* 水平居中 */
	align-items: center;
}

.el-form-item {
	width: 30%;
	height: 40px;
	margin-bottom: 20px;
	text-indent: 20px;
	/* border: 1px solid #fff; */
	background-color: rgba(255, 255, 255, 0.3);
	border-radius: 120px;
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}
.el-input >>> ::placeholder {
	color: #ffffff !important;
}

.el-input >>> .el-input__wrapper {
	width: 100%;
	height: 40px;
	/* margin-bottom: 20px; */
	text-indent: 20px;
	border: 1px solid #fff;
	background-color: rgba(255, 255, 255, 0.3) !important;
	border-radius: 120px;
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}

/* 输入框 */

.input-box #sites option {
	font-size: 40px;
	color: red;
}

input:focus {
	/* 光标颜色 */
	color: white;
}

/* 聚焦时隐藏文字 */
input:focus::placeholder {
	opacity: 0;
}

/* 按钮盒子 */
.btn-box {
	display: flex;
	justify-content: center;
}

/* 按钮 */
button {
	width: 100px;
	height: 30px;
	margin: 0 7px;
	line-height: 30px;
	border: none;
	border-radius: 4px;
	background-color: #69b3f0;
	color: white;
}

/* 按钮悬停时 */
button:hover {
	/* 鼠标小手 */
	cursor: pointer;
	/* 透明度 */
	opacity: 0.8;
}

/* 按钮文字 */
.btn-box p {
	height: 30px;
	line-height: 30px;
	/* 禁止选中 */
	user-select: none;
	font-size: 14px;
	color: white;
}

.btn-box p:hover {
	cursor: pointer;
	border-bottom: 1px solid white;
}

.el-radio-group{
    display:flex;
    justify-content: center;
    padding-bottom:1%;
}

.el-radio{
    color:white;
}
</style>
