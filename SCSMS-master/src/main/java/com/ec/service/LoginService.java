package com.ec.service;

import com.ec.domain.Student;

public interface LoginService {

	Student studentLogin(String ssn, String password);
}
