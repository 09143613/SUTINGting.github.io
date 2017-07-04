package com.ec.domain;

import java.io.Serializable;
import java.util.ArrayList;


public class Section {
	private int sectionNo;
	private String dayOfWeek;
	private String timeOfDay;
	private String room;
	private int capacity;
	private Course course;
	private Professor professor;
	private ArrayList<Student> enrolledStudents;
	public Section() {
		super();
	}
	public Section(int sectionNo, String dayOfWeek, String timeOfDay, String room, int capacity, Course course,
			Professor professor) {
		super();
		this.sectionNo = sectionNo;
		this.dayOfWeek = dayOfWeek;
		this.timeOfDay = timeOfDay;
		this.room = room;
		this.capacity = capacity;
		this.course = course;
		this.professor = professor;
		this.enrolledStudents = new ArrayList<Student>();
	}
	public int getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public ArrayList<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	
}
