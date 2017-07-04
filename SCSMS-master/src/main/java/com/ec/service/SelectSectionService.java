package com.ec.service;

import java.util.ArrayList;

import com.ec.domain.Student;

public interface SelectSectionService {

	String selectSection(String ssn, int sectionNo);

	ArrayList<Student> queryEnrolledStudents(int sectionNo);

}
