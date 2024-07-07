<template>
	<div class="roommate-left">
		<h2>提交个人习惯</h2>
		<el-form-item label="作息习惯：">
		<el-radio-group v-model="radio1">
      		<el-radio :label="'1'" size="large">早睡早起</el-radio>
      		<el-radio :label="'0'" size="large">晚睡晚起</el-radio>
    	</el-radio-group>
	</el-form-item><br>
	<el-form-item label="睡眠习惯：">
		<el-radio-group v-model="radio2">
      		<el-radio :label="'1'" size="large">打呼噜</el-radio>
      		<el-radio :label="'0'" size="large">不打呼噜</el-radio>
    	</el-radio-group>
	</el-form-item><br>
	<el-form-item label="是否吸烟：">
		<el-radio-group v-model="radio3">
      		<el-radio :label="'1'" size="large">吸烟</el-radio>
      		<el-radio :label="'0'" size="large">不吸烟</el-radio>
    	</el-radio-group>
	</el-form-item><br>
	<el-form-item label="卫生习惯：">
		<el-radio-group v-model="radio4">
      		<el-radio :label="'1'" size="large">打扫卫生频率高</el-radio>
      		<el-radio :label="'0'" size="large">打扫卫生频率低</el-radio>
    	</el-radio-group>
	</el-form-item>
	<div>
		<div class="btn-box">
			<button type="button" class="btn btn-primary" @click="handleClick" style="width:80%">提交</button>
		</div>
	</div>
	</div>
	<div class="roommate-right">
		<h2>室友匹配公示</h2>
		<el-card>
		<el-row :gutter="20" class="header">
			<el-button type="primary" @click="handleClick2" :icon="Search">点击查询数据</el-button>
		</el-row>
		<el-table :data="tableData" stripe style="width: 100%">
			<el-table-column width="100" :prop="item.prop" :label="item.label" v-for="(item,index) in options" :key="index"/>
		</el-table>
	</el-card>
	</div>
</template>

<script setup>
const router = useRouter()
import { Search } from '@element-plus/icons-vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { ref } from 'vue'
import { options } from './option.js'
import qs from 'qs' //引入qs
const account = sessionStorage.getItem('account') //获取账号
// 获得4个选项的值与组件进行绑定
const radio1 = ref('1')
const radio2 = ref('1')
const radio3 = ref('1')
const radio4 = ref('1')
//表格数据
const tableData = ref([])


const handleClick = () => {
	axios
		.post(
			'/api/student/dormitoryMatch',
			qs.stringify({
				account: account,
                roommatepre: radio1._value+radio2._value+radio3._value+radio4._value
			})
		)
		.then((res) => {
			console.log(res)
			if (res.status === 200) {
				ElMessage({
					showClose: true,
					message: res.data.msg,
					type: 'success',
				})
			} else {
				ElMessage({
					showClose: true,
					message: '发送失败',
					type: 'error',
				})
			}
		})
		.catch((error) => {
			console.log(error)
		})
}
const handleClick2 = () => {
	axios
		.post(
			'/api/student/dormitoryGet',
		)
		.then((res) => {
			console.log(res)
			if (res.status === 200) {
				ElMessage({
					showClose: true,
					message: '获取成功',
					type: 'success',
				})
                tableData.value = res.data.data
				console.log(tableData.value)
			} else {
				ElMessage({
					showClose: true,
					message: '获取失败',
					type: 'error',
				})
			}
		})
		.catch((error) => {
			console.log(error)
		})
}

</script>

<style scoped>
	.roommate-left{
		width: 45%;
		height: 100%;
		float: left;
	}
	.roommate-right{
		width: 45%;
		height: 100%;
		float: left;
	}
	.header {
    padding-bottom: 16px;
    box-sizing: border-box;
}
</style>
