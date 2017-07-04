package com.ec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ec.domain.Student;
import com.ec.service.LoginService;
import com.ec.service.SectionService;
import com.ec.service.SelectSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SelectSectionController {
	private Student student;
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	@Autowired
	@Qualifier("sectionService")
	private SectionService sectionService;
	@Autowired
	private SelectSectionService selectSectionService;
	@RequestMapping(value="/studentLogin")
	public ModelAndView login(String ssn,String password,
			 ModelAndView mv,
			 HttpSession session){
		student = loginService.studentLogin(ssn,password);
		if(student != null){
			session.setAttribute("student", student);
			mv.setViewName("main");
		}else{
			mv.addObject("message", "1");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	
	@RequestMapping(value="querySection")
	@ResponseBody
	public Object querySection(){
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		list=sectionService.querySection();
		return list;
	}
	
	@RequestMapping(value="selectSection",produces="text/html;charset=UTF-8")
	@ResponseBody  	  
	public Object selectSection(int sectionNo,HttpSession session){
		/*String ssn=student.getSsn();*/
		/*String ssn="09143604";*/
		Student student=(Student)session.getAttribute("student");
		String ssn=student.getSsn();
		String result=selectSectionService.selectSection(ssn,sectionNo);
		return result;
	}
	
	@RequestMapping(value="queryEnrolledStudents")
	@ResponseBody
	public Object queryEnrolledStudents(int sectionNo){
		/*int sectionNo=2;*/
		ArrayList<Student> enrolledStudents=new ArrayList<Student> ();
		enrolledStudents=selectSectionService.queryEnrolledStudents(sectionNo);
		return enrolledStudents;
	}
	
	
}
