package com.ec.domain;

import java.io.Serializable;
import java.util.ArrayList;


import org.springframework.stereotype.Component;

@Component
public class Student extends Person{
	
	private String degree;
	private String major;
	private ArrayList<TranscriptEntity> transcript;
	private ArrayList<Section> attends;
	private ArrayList<Course> planOfStudy;
	private String password;
	public Student() {
		super();
	}
	public Student(String ssn, String name,String degree,String major) {
		super(ssn, name);
		this.degree=degree;
		this.major=major;
		// TODO Auto-generated constructor stub
	}	
	public Student(String degree, String major, ArrayList<TranscriptEntity> transcript, ArrayList<Section> attends,String password,ArrayList<Course> planOfStudy) {
		super();
		this.degree = degree;
		this.major = major;
		
		this.password = password;
		attends = new ArrayList<Section>();
		planOfStudy=new ArrayList<Course>();
		transcript = new ArrayList<TranscriptEntity>();
	}
	/**
	 * 方法
	 */
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public ArrayList<TranscriptEntity> getTranscript() {
		return transcript;
	}
	public void setTranscript(ArrayList<TranscriptEntity> transcript) {
		this.transcript = transcript;
	}
	public ArrayList<Section> getAttends() {
		return attends;
	}
	public void setAttends(ArrayList<Section> attends) {
		this.attends = attends;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Course> getPlanOfStudy() {
		return planOfStudy;
	}
	public void setPlanOfStudy(ArrayList<Course> planOfStudy) {
		this.planOfStudy = planOfStudy;
	}
	
	
}
