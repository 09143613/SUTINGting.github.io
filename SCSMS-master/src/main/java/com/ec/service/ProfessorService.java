package com.ec.service;

import java.util.ArrayList;

import com.ec.domain.Professor;

public interface ProfessorService {
	
	boolean addProfessor(Professor professor);
	
	ArrayList<Professor> queryProfessor();
	
	boolean deleteProfessor(String ssn);
	
	boolean updateProfessor(Professor professor);
	

}
