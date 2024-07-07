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
				<el-button class="btn1"
					type="primary"
					@click="loginOut"
					:icon="Search"
					>退出登录</el-button
				>
                <el-button
                    class="btn2"
					type="primary"
					>
                    <a target="_blank" href="http://192.168.43.119:8080/show.html"> 信息呈现仓</a>
                    </el-button
				>
			</el-header>

			<el-main>
				<router-view></router-view>
			</el-main>
		</el-container>
	</el-container>
</template>
<script setup>
import Menu from './meun'
import { useRouter } from 'vue-router'
const router = useRouter()
const account = sessionStorage.getItem('account')

const loginOut = () => {
    router.push('./login')
}

</script>
<style scoped>

a {
    text-decoration:none;
    color:white;
}


.el-aside {
	height: 100vh;
	padding-top: 60px;
}

.btn1 {
    position: absolute;
    right: 3%;
    top: 3%;
}

.btn2 {
    position: absolute;
    right: 10%;
    top: 3%;
}
.user {
    position: absolute;
    left: 1.5%;
    top: 3%;
}
</style>
