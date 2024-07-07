<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    status-icon
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
  >
    <el-form-item label="姓名" prop="name">
      <el-input v-model="ruleForm.name" />
    </el-form-item>

    <el-form-item label="修改密码" prop="pass">
      <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />
    </el-form-item>

    <el-form-item label="确认密码" prop="checkPass">
      <el-input
        v-model="ruleForm.checkPass"
        type="password"
        autocomplete="off"
      />
    </el-form-item>

    <el-form-item label="年龄" prop="age">
      <el-input v-model.number="ruleForm.age" />
    </el-form-item>

    <el-form-item label="性别" prop="sex">
      <el-radio-group v-model="ruleForm.sex">
        <el-radio label="男" />
        <el-radio label="女" />
      </el-radio-group>
    </el-form-item>

    <el-form-item label="专业" prop="major">
      <el-select v-model="ruleForm.major" placeholder="请选择专业">
        <el-option label="计算机科学与技术" value="计算机科学与技术" />
        <el-option label="信息安全" value="信息安全" />
        <el-option label="物联网工程" value="物联网工程" />
        <el-option label="软件工程" value="软件工程" />
      </el-select>
    </el-form-item>

    <el-form-item label="省份" prop="province">
      <el-select v-model="ruleForm.province" placeholder="请选择省份">
        <el-option label="北京" value="北京" />
        <el-option label="天津" value="天津" />
        <el-option label="河北省" value="河北省" />
        <el-option label="山西省" value="山西省" />
        <el-option label="内蒙古自治区" value="内蒙古自治区" />
        <el-option label="辽宁省" value="辽宁省" />
        <el-option label="吉林省" value="吉林省" />
        <el-option label="黑龙江省" value="黑龙江省" />
        <el-option label="上海" value="上海" />
        <el-option label="江苏省" value="江苏省" />
        <el-option label="浙江省" value="浙江省" />
        <el-option label="安徽省" value="安徽省" />
        <el-option label="福建省" value="福建省" />
        <el-option label="江西省" value="江西省" />
        <el-option label="山东省" value="山东省" />
        <el-option label="河南省" value="河南省" />
        <el-option label="湖北省" value="湖北省" />
        <el-option label="湖南省" value="湖南省" />
        <el-option label="广东省" value="广东省" />
        <el-option label="广西壮族自治区" value="广西壮族自治区" />
        <el-option label="海南省" value="海南省" />
        <el-option label="重庆" value="重庆" />
        <el-option label="四川省" value="四川省" />
        <el-option label="贵州省" value="贵州省" />
        <el-option label="云南省" value="云南省" />
        <el-option label="西藏自治区" value="西藏自治区" />
        <el-option label="陕西省" value="陕西省" />
        <el-option label="甘肃省" value="甘肃省" />
        <el-option label="青海省" value="青海省" />
        <el-option label="宁夏回族自治区" value="宁夏回族自治区" />
        <el-option label="新疆维吾尔自治区" value="新疆维吾尔自治区" />
        <el-option label="台湾省" value="台湾省" />
        <el-option label="香港特别行政区" value="香港特别行政区" />
        <el-option label="澳门特别行政区" value="澳门特别行政区" />
      </el-select>
    </el-form-item>

    <el-form-item label="爱好" prop="hobby">
      <el-checkbox-group v-model="ruleForm.hobby">
        <el-checkbox label="运动类" name="hobby" />
        <el-checkbox label="娱乐类" name="hobby" />
        <el-checkbox label="社交类" name="hobby" />
        <el-checkbox label="智力类" name="hobby" />
        <el-checkbox label="收藏类" name="hobby" />
        <el-checkbox label="乐器类" name="hobby" />
        <el-checkbox label="文艺类" name="hobby" />
        <el-checkbox label="其他类" name="hobby" />
      </el-checkbox-group>
    </el-form-item>

    <el-form-item label="电话" prop="phone">
      <el-input v-model="ruleForm.phone" />
    </el-form-item>

    <el-form-item label="QQ" prop="qq">
      <el-input v-model="ruleForm.qq" />
    </el-form-item>

    <el-form-item label="微信" prop="wx">
      <el-input v-model="ruleForm.wx" />
    </el-form-item>

    <el-form-item label="邮箱" prop="email">
      <el-input v-model="ruleForm.email" />
    </el-form-item>

    <el-form-item label="个人描述" prop="desc">
      <el-input v-model="ruleForm.desc" type="textarea" />
    </el-form-item>

    <el-form-item>
        <div class="btn">
            <el-button type="primary" @click="submitForm(ruleFormRef)"
                >提交</el-button>
            <el-button @click="resetForm(ruleFormRef)">重置</el-button>
        </div>

    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { ElMessage } from 'element-plus'
import axios from 'axios'
import { ca } from 'element-plus/es/locale';

const ruleFormRef = ref<FormInstance>()
const account = sessionStorage.getItem('account')

const checkAge = (rule: any, value: any, callback: any) => {
  if (ruleForm.age!=''){
    try{
      if (Number(ruleForm.age)<0){
      callback(new Error("年龄要求大于0"))
    }
    }catch(error){
      callback(new Error("年龄要求输入为数字"))
    }
  }
  callback()
}

const validatePass = (rule: any, value: any, callback: any) => {
    if (ruleForm.checkPass !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('checkPass', () => null)
    }
    callback()
  }

const validatePass2 = (rule: any, value: any, callback: any) => {
  if (ruleForm.pass==''&&value==''){
    callback()
  }
  else if (value !== ruleForm.pass) {
    callback(new Error("密码不一致"))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  name:'',
  pass: '',
  checkPass: '',
  age: '',
  sex:'',
  major:'',
  province:'',
  hobby:[],
  phone:'',
  qq:'',
  wx:'',
  email:'',
  desc:''
})

const rules = reactive<FormRules>({
  name:[
    {  message: '请输入姓名', trigger: 'blur' },
    { min: 2, max: 20, message: '姓名长度范围:2~20', trigger: 'blur' },
  ],
  pass: [{ validator: validatePass, trigger: 'blur' }],
  checkPass: [{validator: validatePass2, trigger: 'blur' }],
  age: [{ validator: checkAge, trigger: 'blur' }],
})

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      axios({
        method:'POST',
        url:'/api/student/update',
        params:{
          account:account,
          password:ruleForm.checkPass,
          name:ruleForm.name,
          age:ruleForm.age,
          sex:ruleForm.sex,
          major:ruleForm.major,
          province:ruleForm.province,
          hobby:computeHobby(ruleForm.hobby),
          phone:ruleForm.phone,
          qq:ruleForm.qq,
          wx:ruleForm.wx,
          email:ruleForm.email,
          description:ruleForm.desc
        }
      }
      ).then(res => {
        console.log(res)
        if (res.status === 200) {
        ElMessage({
              showClose: true,
              message: '修改成功',
              type: 'success',
            })
        }
        else{
          ElMessage({
					showClose: true,
					message: '修改失败',
					type: 'error',
			})
        }
      })
    } else {
      ElMessage({
					showClose: true,
					message: '输入不完整或不规范',
					type: 'error',
			})
      console.log(computeHobby(ruleForm.hobby))
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

const computeHobby=function(hobby:Array<string>):string{
  let num:number=0;
  for (let i=0;i<hobby.length;i++){
    if (hobby[i]=="运动类"){
      num+=10000000
    }
    else if (hobby[i]=="娱乐类"){
      num+=1000000
    }
    else if (hobby[i]=="社交类"){
      num+=100000
    }
    else if (hobby[i]=="智力类"){
      num+=10000
    }
    else if (hobby[i]=="收藏类"){
      num+=1000
    }
    else if (hobby[i]=="乐器类"){
      num+=100
    }
    else if (hobby[i]=="文艺类"){
      num+=10
    }
    else{
      num+=1
    }
  }
  let ans:string=num.toString()
  for (let i=ans.length;i<8;i++){
    ans='0'+ans
  }
  return ans
}
</script>

<style scoped> 
.btn {
    margin-left: 5%;
}
</style>
