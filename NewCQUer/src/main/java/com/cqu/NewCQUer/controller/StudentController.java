package com.cqu.NewCQUer.controller;

import java.util.ArrayList;

import javax.annotation.PreDestroy;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.NewCQUer.pojo.Dormitory;
import com.cqu.NewCQUer.pojo.Result;
import com.cqu.NewCQUer.pojo.Student;
import com.cqu.NewCQUer.service.StudentService;
/**
 * spring mvc 的框架
 * m:model
 * v:view
 * c:controller
 * */


@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	//登录
	@PostMapping("login")
	@ResponseBody
	public Result<?> login(String account, String password) {
		Student result_student = service.findStudentByAccount(account);
		String nextpage;  //下一个网页
		if(result_student == null) {	//第一次登录的学生
			if(account.equals(password) && account.length()!=0) {
				nextpage = "/info"; //首次登录后默认进入提交个人信息界面
			} else {
				return Result.error(500,"用户名或密码错误");
			}
		}else {   //该学号非第一次登录
			String psw_encrypt = DigestUtils.md5Hex(password);  //同种加密方式加密后的密码
			if(psw_encrypt.equals(result_student.getPassword())) {
				nextpage = "/home"; //主页
			} else {
				return Result.error(500,"用户名或密码错误");
			}
		}
		return Result.success(nextpage,"跳转到下一网页");
	}
	
	//提交，首次登录初始密码为学号（账号），提交即可注册信息
	@PostMapping("submit")
	@ResponseBody
	public Result<?> submit(String account, String password, String name, String age, String sex, 
			String major, String province, String hobby, String phone, String qq, String wx, 
			String email, String roommatepre, String description) {
		if((password.length()==0||password==null) || (name.length()==0||name==null) || 
				(age.length()==0||age==null) || (sex.length()==0||sex==null) ||
				(major.length()==0||major==null) || (province.length()==0||province==null) ||
				(hobby.length()==0||hobby==null)||hobby.equals("00000000")) {
			return Result.error(500,"必填项没填全");//必填项没填全
		}
		String nextpage;
		String psw_encrypt = DigestUtils.md5Hex(password);  //同种加密方式加密后的密码
		if(phone.length()==0 || phone==null) phone=null;
		if(qq.length()==0 || qq==null) qq=null;
		if(wx.length()==0 || wx==null) wx=null;
		if(email.length()==0 || email==null) email=null;
		Student student_firstLogin = new Student(account, psw_encrypt, name, age, sex, major, province,
				hobby, phone, qq, wx, email, roommatepre, description);
		service.insertStudent(student_firstLogin);
		nextpage = "/welcome";
		return Result.success(nextpage,"跳转到欢迎页面");
	}
	
	//查看个人信息
	@PostMapping("look")
	@ResponseBody
	public Result<?> look(String account) {
		Student student = service.findStudentByAccount(account);
		return Result.success(student,"查看个人信息");
	}
	 
	//修改个人信息
	@PostMapping("update")
	@ResponseBody
	public Result<?> update(String account, String password, String name, String age, String sex, 
			String major, String province, String hobby, String phone, String qq, String wx, 
			String email, String description) {
		String nextpage;
		Student stu = service.findStudentByAccount(account);
		if(password.length()!=0) {
			String psw_encrypt = DigestUtils.md5Hex(password);  //同种加密方式加密后的密码
			stu.setPassword(psw_encrypt);
		}
		if(name.length()!=0) 		 stu.setName(name);
		if(age.length()!=0) 		 stu.setAge(age);
		if(sex.length()!=0)  		 stu.setSex(sex);
		if(major.length()!=0) 		 stu.setMajor(major);
		if(province.length()!=0)	 stu.setProvince(province);
		if(hobby.length()!=0) 		 stu.setHobby(hobby);
		if(phone.length()!=0) 		 stu.setPhone(phone);
		if(qq.length()!=0)			 stu.setQq(qq);
		if(wx.length()!=0)           stu.setWx(wx);
		if(email.length()!=0) 		 stu.setEmail(email);
		if(description.length()!=0)  stu.setDescription(description);
		service.updateStudent(stu);
		nextpage = "/home";
		return Result.success(nextpage,"修改完信息回到首页");
	}
	
	//用于欢迎界面，获取报到名次、同专业人数、同省份人数
	@PostMapping("getSort")
	@ResponseBody
	public Result<?> getSort(String account) {
		Student student_firstLogin = service.findStudentByAccount(account);
		int men = service.countSexNumber("男");
		int women = service.countSexNumber("女");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(men+women);
		list.add(service.countMajorNumber(student_firstLogin.getMajor())-1);
		list.add(service.countProvinceNumber(student_firstLogin.getProvince())-1);
		return Result.success(list,"获取报到名次、同专业人数、同省份人数");
	}
	
	//获取男女生人数list(顺序为:男 女)
	@RequestMapping("getSexNum")
	@ResponseBody
	public Result<?> getSexNum() {
		int men = service.countSexNumber("男");
		int women = service.countSexNumber("女");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(men);
		list.add(women);
		return Result.success(list,"获取男女生人数list(顺序为:男 女)");
	}
	
	//获取不同专业人数list(顺序为:计算机科学与技术 信息安全 物联网工程 软件工程)
	@RequestMapping("getMajorNum")
	@ResponseBody
	public Result<?> getMajorNum() {
		int jike = service.countMajorNumber("计算机科学与技术");
		int xinan = service.countMajorNumber("信息安全");
		int wulianwang = service.countMajorNumber("物联网工程");
		int ruangong = service.countMajorNumber("软件工程");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(jike);
		list.add(xinan);
		list.add(wulianwang);
		list.add(ruangong);
		return Result.success(list,"获取不同专业人数list(顺序为:计算机科学与技术 信息安全 物联网工程 软件工程)");
	}
	
	//获取不同年龄段人数list(顺序为:15及以下 16-18 19-21 22-24 25及以上)
	@RequestMapping("getAgeNum")
	@ResponseBody
	public Result<?> getAgeNum() {
		int age1 = service.countAgeNumber(0, 15);
		int age2 = service.countAgeNumber(16, 18);
		int age3 = service.countAgeNumber(19, 21);
		int age4 = service.countAgeNumber(22, 24);
		int age5 = service.countAgeNumber(25, 100);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(age1);
		list.add(age2);
		list.add(age3);
		list.add(age4);
		list.add(age5);
		return Result.success(list,"获取不同年龄段人数list(顺序为:15及以下 16-18 19-21 22-24 25及以上)");
	}
	
	//获取不同省份的学生人数list(顺序为:如下)
	@RequestMapping("getProvinceNum")
	@ResponseBody
	public Result<?> getProvinceNum(){
	    ArrayList<Integer> list = new ArrayList<>();
	    String[] arr={"北京","天津","河北省","山西省","内蒙古自治区","辽宁省","吉林省","黑龙江省","上海","江苏省",
	    "浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西壮族自治区","海南省",
	    "重庆","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省","宁夏回族自治区",
	    "新疆维吾尔自治区","台湾省","香港特别行政区","澳门特别行政区"};
	    for (String s:arr){
	        list.add(service.countProvinceNumber(s));
	    }
	    return Result.success(list,"获取不同省份的学生人数list");
	}
	
	//获取不同兴趣的学生人数list(顺序为:运动类 娱乐类 社交类 智力类 收藏类 乐器类 文艺类 其他类)
	@RequestMapping("getHobbyNum")
	@ResponseBody
	public Result<?> getHobbyNum() {
		ArrayList<Student> students = new ArrayList<Student>();
		students = service.findAllStudent();   //数据库中所有的学生
		ArrayList<Integer> list = new ArrayList<>();   
		int number[] = new int[8];
		for (int i = 0; i < 8; i++) {
			number[i] = 0;
		}
		for (Student student: students) {
			for (int i = 0; i < 8; i++) {
				if (student.getHobby().charAt(i) == '1') {
					number[i]++;
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			list.add(number[i]);
		}
		return Result.success(list,"获取不同兴趣的学生人数list(顺序为:运动类 娱乐类 社交类 智力类 收藏类 乐器类 文艺类 其他类)");
	}
	
	//查询与某学生同省份的其他学生信息，查看老乡信息(不包括自己)
	//输入 某学生的账号（学号）
	//返回data的类型 ArrayList<Student>
	@PostMapping("getSameProvinceStu")
	@ResponseBody
	public Result<?> getSameHProvinceStu(String account){
		Student student = service.findStudentByAccount(account);  //通过账号查找学生
		ArrayList<Student> students = new ArrayList<>();  //返回的data
		students = service.findSameProvince(student.getProvince()); //某一省份的全部学生信息
		for(int i=0;i<students.size();i++) {  //通过遍历来把自己排除出去
			if(students.get(i).getAccount().equals(account)) {
				students.remove(i);
			}
		}
		return Result.success(students,"获取同省份学生信息列表（不包括自己）");
	}

	//查询同爱好学生list，查看同好信息(不包括自己)
	//输入 某学生的账号（学号）
	//返回data的类型 ArrayList<Student>
	@PostMapping("getSameHobbyStu")
	@ResponseBody
	public Result<?> getSameHobbyStu(String account){
		Student student = service.findStudentByAccount(account); //通过账号查找学生
		String ss = student.getHobby(); //获取该学生的爱好
		ArrayList<Student> Allstudent = service.findAllStudent(); //获取所有学生信息
		ArrayList<Student> students = new ArrayList<>(); //返回的data
		for (Student stu:Allstudent) {
			if(stu.getAccount().equals(account)) {  //把自己排除
				continue;
			}
			String s = stu.getHobby();
			for(int i = 0;i<s.length();i++) {  //判断是否有爱好相同
				if(s.charAt(i)==ss.charAt(i)&&s.charAt(i)=='1') {
					students.add(stu);
					break;
				}
			}
		}
		return Result.success(students,"获取同爱好学生信息列表（不包括自己）");
	}

	//查询chat表单中所有学生信息，信息用于在新生交友贴上显示
	//返回data的类型 ArrayList<Student>
	@PostMapping("getChatStu")
	@ResponseBody
	public Result<?> getChatStu(){
		ArrayList<Student> students = new ArrayList<>();
		students = service.findAllStudentChat();
		return Result.success(students,"success");
	}
	
	//向chat表单中添加学生信息，即把自己信息上传到新生交友贴上
	//输入 账号（学号）account
	//返回data的类型 null
	@PostMapping("addChatStu")
	@ResponseBody
	public Result<?> addChatStu(String account){
		Student stu = service.findStudentChatByAccount(account);
		if(stu!=null) {
			return Result.success("新生交友贴已有个人信息","success");
		}
		Student student = service.findStudentByAccount(account);
		service.insertStudentChat(student);
		return Result.success();
	}
	
	//向chat表单中删除学生信息，即把自己信息从新生交友贴删除
	//输入 账号（学号）account
	//返回data的类型 null
	@PostMapping("deleteChatStu")
	@ResponseBody
	public Result<?> deleteChatStu(String account){
		Student student = service.findStudentByAccount(account);
		service.deleteStudentChat(student);
		return Result.success();
	}
	
	//匹配室友功能的表单提交
	//输入 账号（学号）account 室友偏好 roommatepre（四位二进制）
	//返回data的类型 null
	@PostMapping("dormitoryMatch")
	@ResponseBody
	public Result<?> dormitoryMatch(String account,String roommatepre){
		Student student = service.findStudentByAccount(account);
		String gender = student.getSex();   //获取性别
		int code = 500;
		String msg = "";
		if(student.getRoommatepre()==null) {  //判断是否已经使用过了该功能
			System.out.println(1);
			student.setRoommatepre(roommatepre);
			service.updateStudent(student);     //更新室友偏好
			ArrayList<Student> dorm = new ArrayList<>(); //宿舍，待加入学生
			ArrayList<Student> allstudents = new ArrayList<>();
			allstudents = service.findAllStudent();
			for(Student stu : allstudents) {
				if(stu.getAccount().equals(student.getAccount())) {
					continue;  //自己不能当自己的室友
				}
				if(!stu.getSex().equals(gender)) {
					continue;  //不能男女混寝
				}
				if(stu.getRoommatepre().equals(student.getRoommatepre())) { //习惯相匹配
					dorm.add(stu);
					if(dorm.size() == 3) break; //三人加自己四人一宿舍
				}
			}
			dorm.add(student);
			ArrayList<String> strlist = new ArrayList<>(); 
			if(dorm.size() == 4) {  //寝室满四人
				for(Student stu : dorm) { //把该宿舍的学生的roommatepre后面加1变成5位
					strlist.add(stu.getAccount());
					strlist.add(stu.getName());
					String rp;
					if(gender.equals("男")){
						rp = stu.getRoommatepre() + "1";  //第五位为1表示男宿舍
					} else {
						rp = stu.getRoommatepre() + "0";  //第五位为0表示女宿舍
					}
					stu.setRoommatepre(rp);
					service.updateStudent(stu);
					System.out.println(stu);
				}
				Dormitory dormitory = new Dormitory(strlist.get(0),strlist.get(1),strlist.get(2),
						strlist.get(3),strlist.get(4),strlist.get(5),strlist.get(6),strlist.get(7));
				service.insertDormitory(dormitory);  //向dormitory表中加入数据
				msg = "信息上传成功，请等待分配";
				code = 200;
			}
		} else if(student.getRoommatepre().length() == 5){
			msg = "已分配宿舍";
			code = 500;
		} else {
			msg = "已填表，请等待分配";
			code = 200;
		}
		return Result.success(code,msg);
	}	
	
	//获取已经分配好的宿舍的信息，看看有没有自己
	//返回data的类型 ArrayList<Dormitory>
	@PostMapping("dormitoryGet")
	@ResponseBody
	public Result<?> dormitoryGet(){
		ArrayList<Dormitory> dorms = new ArrayList<>();
		dorms = service.findAllDorm();
		return Result.success(dorms,"全部宿舍的信息");
	}
	
}

