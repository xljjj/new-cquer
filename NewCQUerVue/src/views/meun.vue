<template>
        <el-menu :default-openeds="['1']" unique-opened router>
         <!-- <template #title>11</template> -->
          <el-sub-menu index="1">
            <template #title>
              <el-icon><message /></el-icon>新手助手
            </template>
            <el-menu-item-group>
    
              <el-menu-item index="/hobby">兴趣相投</el-menu-item>
              <el-menu-item index="/fellow">看看老乡</el-menu-item>

              <el-menu-item index="/newFriend">新生交友</el-menu-item>

              <el-menu-item index="/select">匹配室友</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><icon-menu /></el-icon>新生攻略
            </template>
            <el-menu-item-group>
              <el-menu-item index="/preClass">课程预览</el-menu-item>
              <el-menu-item index="/life">虎溪生活</el-menu-item>
              <el-menu-item index="/classTem">选课系统</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><setting /></el-icon>信息管理
            </template>
            <el-menu-item-group>
              <el-menu-item index="/Personal">个人中心</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>          
          <el-sub-menu index="4">
            <template #title>
              <el-icon><User /></el-icon>关于我们
            </template>
            <el-menu-item-group>
              <el-menu-item index="/ikun">了解我们</el-menu-item>
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
