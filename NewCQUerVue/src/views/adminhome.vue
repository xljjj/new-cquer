<template lang="">
	<el-container>
		<el-aside width="200px">
            <div class="user">
                当前用户：{{account}}
            </div>
			<Menu />
		</el-aside>
		<el-container>
			<el-header>
				<el-button
					type="primary"
					@click="loginOut"
					:icon="Search"
					>退出登录</el-button
				>
			</el-header>

			<el-main>
				<router-view></router-view>
			</el-main>
		</el-container>
	</el-container>
</template>
<script setup>
import Menu from './adminmenu'
import { useRouter } from 'vue-router'
const router = useRouter()
const account = sessionStorage.getItem('account')

const loginOut = () => {
    router.push('./login')
}

</script>
<style scoped>
.el-aside {
	height: 100vh;
	padding-top: 60px;
}

.el-button {
    position: absolute;
    right: 3%;
    top: 3%;
}

.user {
    position: absolute;
    left: 1.5%;
    top: 3%;
}
</style>
