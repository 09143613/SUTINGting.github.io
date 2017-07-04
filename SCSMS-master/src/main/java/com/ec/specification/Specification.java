package com.ec.specification;

import com.ec.domain.Section;
import com.ec.domain.Student;

public interface Specification<T> {
	String validate(Student student, Section section);
}
