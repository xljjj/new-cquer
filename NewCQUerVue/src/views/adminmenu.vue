<template>
        <el-menu :default-openeds="['1']" unique-opened router>
         <!-- <template #title>11</template> -->
          <el-sub-menu index="1">
            <template #title>
              <el-icon><setting /></el-icon>信息管理
            </template>
            <el-menu-item-group>
              <el-menu-item index="/adminPersonal">查询信息</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="/ResetPassword">找回密码</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>          
        </el-menu>

</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { Menu as IconMenu, Message, Setting, User  } from '@element-plus/icons-vue'

const item = {
  date: '2016-05-02',
  name: 'Tom',
  address: 'No. 189, Grove St, Los Angeles',
}
const tableData = ref(Array.from({ length: 20 }).fill(item))
</script>

<style scoped>

</style>
