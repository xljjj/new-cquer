<template>
	<el-card>
		<el-row :gutter="20" class="header">
			学生信息
		</el-row>
		<el-table :data="tableData" stripe style="width: 100%">
			<el-table-column
				width="120"
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
import qs from 'qs'
const tableData = ref([])
const account = sessionStorage.getItem('account')

onMounted(() => {
	axios
		.post('/api/admin/check')
		.then((res) => {
			console.log(res)
			if (res.data.code === 200) {
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

<style scoped>
.header {
	padding-bottom: 16px;
	box-sizing: border-box;
}
</style>
