<template>
    <h1>
        输入学生账号重置密码为123456
    </h1>
    <el-form-item label="学生账号" prop="account">
      <el-input v-model="stuaccount" />
    </el-form-item>
    <div class="btn-box">
		<button type="button" class="btn btn-primary" @click="handleClick" style="width:30%">确定</button>
	</div>
</template>

<script setup>
    import { reactive, ref } from 'vue'
    import { ElMessage } from 'element-plus'
    import axios from 'axios'
    import qs from 'qs' //引入qs

    let stuaccount=ref('')

    const handleClick = () => {
		console.log(stuaccount._value)
	axios
		.post(
			'/api/admin/findBack',
			qs.stringify({
				stuaccount: stuaccount._value,
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
					message: res.data.msg,
					type: 'error',
				})
			}
		})
		.catch((error) => {
			console.log(error)
		})
}
</script>