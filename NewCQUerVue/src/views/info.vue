<template>
	<div class="bigBox">
		<!-- 最外层的大盒子 -->
		<div class="box">
			<div class="register-form">
				<!-- 标题盒子 -->
				<div class="title-box">
					<h1>必填</h1>
				</div>
				<!-- 输入框盒子 -->
				<el-form :model="loginForm" ref="loginFormRef" :rules="rules">
					<el-form-item prop="password">
						<el-input
							type="text"
							placeholder="首次登陆请修改密码"
							v-model="loginForm.password"
						/>
					</el-form-item>
					<el-form-item prop="confirmPassword">
						<el-input
							type="text"
							placeholder="确认密码"
							v-model="loginForm.confirmPassword"
						/>
					</el-form-item>
					<el-form-item prop="name">
						<el-input
							type="text"
							placeholder="姓名"
							v-model="loginForm.name"
						/>
					</el-form-item>
					<el-form-item prop="sex">
						<el-select v-model="loginForm.sex" placeholder="性别">
							<el-option label="男" value="男" />
							<el-option label="女" value="女" />
						</el-select>
					</el-form-item>
					<el-form-item prop="age">
						<el-input
							type="text"
							placeholder="年龄"
							v-model.number="loginForm.age"
						/>
					</el-form-item>
					<el-form-item prop="major">
						<el-select v-model="loginForm.major" placeholder="专业">
							<el-option
								label="计算机科学与技术"
								value="计算机科学与技术"
							/>
							<el-option label="信息安全" value="信息安全" />
							<el-option label="物联网工程" value="物联网工程" />
							<el-option label="软件工程" value="软件工程" />
						</el-select>
					</el-form-item>
					<el-form-item prop="province">
						<el-select
							v-model="loginForm.province"
							placeholder="省份"
						>
							<el-option label="北京" value="北京" />
							<el-option label="天津" value="天津" />
							<el-option label="河北省" value="河北省" />
							<el-option label="山西省" value="山西省" />
							<el-option
								label="内蒙古自治区"
								value="内蒙古自治区"
							/>
							<el-option label="辽宁省" value="辽宁省" />
							<el-option label="吉林省" value="吉林省" />
							<el-option label="黑龙江省" value="黑龙江省 " />
							<el-option label="上海" value="上海" />
							<el-option label="江苏省" value="江苏省" />
							<el-option label="浙江省" value="浙江省" />
							<el-option label="安徽省" value="安徽省" />
							<el-option label="福建省" value="福建省" />
							<el-option label="江西省" value="江西省" />
							<el-option label="山东省" value="山东省" />
							<el-option label="河南省" value="河南省" />
							<el-option label="湖北省" value="河南省" />
							<el-option label="江西省" value="江西省" />
							<el-option label="湖南省" value="湖南省" />
							<el-option label="广东省" value="广东省" />
							<el-option
								label="广西壮族自治区"
								value="广西壮族自治区"
							/>
							<el-option label="海南省" value="海南省" />
							<el-option label="重庆" value="重庆" />
							<el-option label="四川省" value="四川省" />
							<el-option label="贵州省" value="贵州省" />
							<el-option label="西藏自治区" value="西藏自治区" />
							<el-option label="陕西省" value="陕西省" />
							<el-option label="甘肃省" value="甘肃省" />
							<el-option label="青海省" value="青海省" />
							<el-option
								label="宁夏回族自治区"
								value="宁夏回族自治区"
							/>
							<el-option label="青海省" value="青海省" />
							<el-option
								label="宁夏回族自治区"
								value="宁夏回族自治区"
							/>
							<el-option
								label="新疆维吾尔自治区"
								value="新疆维吾尔自治区"
							/>
							<el-option label="台湾省" value="台湾省" />
							<el-option
								label="香港特别行政区"
								value="香港特别行政区"
							/>
							<el-option
								label="澳门特别行政区"
								value="澳门特别行政区"
							/>
						</el-select>
					</el-form-item>
					<el-form-item prop="hobby">
							<el-select
								v-model="loginForm.hobby"
								multiple
								placeholder="爱好"
							>
								<el-option
									v-for="(item, index) in options"
									:key="index"
									:label="item.label"
									:value="item.value"
								/>
							</el-select>
					</el-form-item>
				</el-form>
			</div>
			<!-- 注册盒子 -->
			<div class="register-form">
				<!-- 标题盒子 -->
				<div class="title-box">
					<h1>选填</h1>
				</div>
				<!-- 输入框盒子 -->
				<el-form :model="loginForm" ref="loginFormRef" :rules="rules">
					<el-form-item prop="phone">
						<el-input
							type="text"
							placeholder="电话"
							v-model.number="loginForm.phone"
						/>
					</el-form-item>
					<el-form-item prop="qq">
						<el-input
							type="text"
							placeholder="QQ"
							v-model.number="loginForm.qq"
						/>
					</el-form-item>
					<el-form-item prop="wx">
						<el-input
							type="text"
							placeholder="微信"
							v-model="loginForm.wx"
						/>
					</el-form-item>
					<el-form-item prop="email">
						<el-input
							type="text"
							placeholder="email"
							v-model="loginForm.email"
						/>
					</el-form-item>
					<el-form-item prop="description" class="descriptionInput">
						<el-input
							type="textarea"
							placeholder="自我描述"
							class="descriptionInput1"
							v-model="loginForm.description"
							style="resize: none"
						/>
					</el-form-item>
				</el-form>
				<!-- 按钮盒子 -->
				<div class="btn-box">
					<button @click="submit">提交</button>
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
const account = sessionStorage.getItem('account')
const loginForm = reactive({
	password: '',
	confirmPassword: '',
	name: '',
	sex: '',
	age: '',
	major: '',
	province: '',
	hobby: '',
	phone: '',
	qq: '',
	wx: '',
	email: '',
	description: '',
})
const loginFormRef = ref('')
var fhobby = '00000000'

String.prototype.replaceAt = function (index) {
	return this.substr(0, index) + '1' + this.substr(index + 1)
}

const options = [
	{
		label: '运动类',
		value: '1',
	},
	{
		label: '娱乐类',
		value: '2',
	},
	{
		label: '社交类',
		value: '3',
	},
	{
		label: '智力类',
		value: '4',
	},
	{
		label: '收藏类',
		value: '5',
	},
	{
		label: '乐器类',
		value: '6',
	},
	{
		label: '文艺类',
		value: '7',
	},
	{
		label: '其他类',
		value: '8',
	},
]
const validatePass2 = (rule, value, callback) => {
	if (value === '') {
		callback(new Error('请再次输入密码'))
	} else if (value !== loginForm.password) {
		callback(new Error('两次输入密码不一致!'))
	} else {
		callback()
	}
}

const rules = reactive({
	password: [
		{ required: true, message: '新密码', trigger: 'blur' },
		{ min: 3, max: 20, message: '长度为3-20', trigger: 'blur' },
	],
	confirmPassword: [
		{ required: true, message: '确认密码', trigger: 'blur' },
		{ validator: validatePass2, trigger: 'blur', required: true },
	],
	name: [{ required: true, message: '输入姓名', trigger: 'blur' }],
    major: [{ required: true, message: '填写专业', trigger: 'blur' }],

	age: [
		{ required: true, message: '输入年龄', trigger: 'blur' },
		{ type: 'number', message: '必须为数字', trigger: 'blur' },
	],

	hobby: [{ required: true, message: '爱好', trigger: 'blur' }],
	phone: [{ type: 'number', message: '必须为数字', trigger: 'blur' }],
	qq: [{ type: 'number', message: '必须为数字', trigger: 'blur' }],
})

const router = useRouter()

const submit = () => {
    for (var i = 0; i < loginForm.hobby.length; i++) {
		fhobby = fhobby.replaceAt(loginForm.hobby[i] - 1)
	}
	loginFormRef.value.validate((valid) => {
		if (valid) {
			axios
				.post(
					'/api/student/submit',
					qs.stringify({
						account: account,
						password: loginForm.password,
						name: loginForm.name,
						age: loginForm.age,
						sex: loginForm.sex,
						major: loginForm.major,
						province: loginForm.province,
						hobby: fhobby,
						phone: loginForm.phone,
						qq: loginForm.qq,
						wx: loginForm.wx,
						email: loginForm.email,
						roommatepre: loginForm.roommatepre,
						description: loginForm.description,
					})
				)
				.then((res) => {
					console.log(res)
					if (res.data.code === 200) {
						ElMessage({
							showClose: true,
							message: '提交成功',
							type: 'success',
						})
						router.push('/welcome')
					} else if (res.data.code === 500) {
                        ElMessage({
							showClose: true,
							message: `${res.data.msg}`,
							type: 'error',
						})
                    }
				})
				.catch((error) => {
					console.log(error)
				})
		} else {
			ElMessage({
				showClose: true,
				message: '检查一下',
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
	background-image: url(@/assets/img/img6.jpg);
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
	padding-top: 30px;
	height: 100px;
	line-height: 100px;
}

/* 标题 */
.title-box h1 {
	/* margin-top: 15%; */
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
	width: 60%;
	height: 40px;
	margin-bottom: 20px;
	text-indent: 20px;
	/* border: 1px solid #fff; */
	background-color: rgba(255, 255, 255, 0.01);
	border-radius: 120px;
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}

/**修改边框和字体颜色 */

.el-select {
	width: 100%;
}

.el-select >>> .el-input__wrapper {
	width: 60%;
	height: 40px;
	margin-bottom: 20px;
	text-indent: 20px;
	/* border: 1px solid #fff; */
	background-color: rgba(255, 255, 255, 0.3);
	border-radius: 120px;
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}

.el-select >>> .el-input__inner {
	padding-left: 5%;
}
/* .el-select-dropdown__item:hover{
       color:#00D3E9;
       background-color: #0F3360;
   } */

.el-select >>> .el-select-tags-wrapper.has-prefix {
    margin-left: 0px;
    display: flex;
    flex-flow: row wrap;
    flex-direction: row;
}

.el-select >>> .el-select__tags-text {
    display:flex;
    width:60px;
}



/* .el-select >>> .el-select__tags>>> .el-tag--info {
    padding-left: 0px;
} */

.el-input >>> ::placeholder {
	color: white !important;
}
.el-select >>> ::placeholder {
	color: white !important;
}

.el-input >>> .el-input__inner {
	color: white;
}

.el-input >>> .el-input__wrapper {
	padding-left: 10%;
	width: 100%;
	height: 40px;
	/* margin-bottom: 20px; */
	text-indent: 20px;
	border: 0px solid #fff;
	background-color: rgba(255, 255, 255, 0.3) !important;
	border-radius: 120px;
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}

.descriptionInput {
	width: 60%;
	height: 80px;
	border-radius: 10px;
	margin-bottom: 20px;
	text-indent: 20px;
	border: 1px solid #fff;
	background-color: rgba(255, 255, 255, 0.01);
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}
.descriptionInput1 {
	width: 100%;
	height: 80px;
	border-radius: 10px;
	margin-bottom: 20px;
	text-indent: 20px;
	border: 0px solid #fff;
	background-color: rgba(255, 255, 255, 0.01);
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}
.descriptionInput1 >>> .el-textarea__inner {
	width: 100%;
	height: 80px !important;
	color: white;
	padding-left: 0;
	border-radius: 10px;
	margin-bottom: 20px;
	text-indent: 20px;
	border: 0px solid #fff;
	background-color: rgba(255, 255, 255, 0.01);
	/* 增加磨砂质感 */
	backdrop-filter: blur(10px);
}

.el-textarea >>> ::placeholder {
	color: white !important;
}

.el-textarea >>> .el-textarea__inner:focus {
	box-shadow: 0 0 0 1px #ffffff inset;
}

/* 输入框 */

.input-box #sites option {
	font-size: 40px;
}

input:focus {
	/* 光标颜色 */
	color: white;
}

/* 聚焦时隐藏文字 */
.el-input>>>.el-input__inner:focus::placeholder {
	opacity: 0;
}

.el-textarea >>> .el-textarea__inner:focus::placeholder {
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
	border-radius: 10px !important;
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
</style>
