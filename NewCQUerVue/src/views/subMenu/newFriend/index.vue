<template>
	<el-card>
		<el-row :gutter="20" class="header">
			<el-button type="primary" @click="handleClickAdd" :icon="Search"
				>上传信息</el-button
			>
			<el-button type="primary" @click="handleClickDrop" :icon="Search"
				>删除信息</el-button
			>
		</el-row>
		<el-table :data="tableData" stripe style="width: 100%">
			<el-table-column
				:prop="item.prop"
				:label="item.label"
				v-for="(item, index) in options"
				:key="index"
			/>
		</el-table>
	</el-card>
</template>

<script setup>
import { Search } from '@element-plus/icons-vue'
import { onMounted } from 'vue'
import { ref } from 'vue'
import { options } from './option.js'
const router = useRouter()
import axios from 'axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import qs from 'qs' //引入qs
const tableData = ref([])
const account = sessionStorage.getItem('account')

const handleClickAdd = () => {
	axios
		.post(
			'/api/student/addChatStu',
			qs.stringify({
				account: account,
			})
		)
		.then((res) => {
			console.log(res)
			if (res.status === 200) {
				ElMessage({
					showClose: true,
					message: '添加成功',
					type: 'success',
				})
				axios
					.post('/api/student/getChatStu')
					.then((res) => {
						console.log(res)
						if (res.status === 200) {
							
							tableData.value = res.data.data
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
const handleClickDrop = () => {
	axios
		.post(
			'/api/student/deleteChatStu',
			qs.stringify({
				account: account,
			})
		)
		.then((res) => {
			console.log(res)
			if (res.status === 200) {
				ElMessage({
					showClose: true,
					message: '删除成功',
					type: 'success',
				})
                axios
		.post('/api/student/getChatStu')
		.then((res) => {
			console.log(res)
			if (res.status === 200) {
				tableData.value = res.data.data
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
            else {
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

onMounted(() => {
	axios
		.post(
			'/api/student/getChatStu',
			qs.stringify({ account: account })
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
				console.log(tableData)
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
})
</script>

<style  scoped></style>
