package com.ec.dao;

import java.util.ArrayList;

import com.ec.domain.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public interface StudentDao {

	@Select("select * from student where ssn= #{ssn} and password = #{password}")
	@Results({
		@Result(id=true,column="ssn" ,property="ssn"),
		@Result(column="name" ,property="name"),
		@Result(column="degree" ,property="degree"),
		@Result(column="major" ,property="major"),
		@Result(column="password" ,property="password")		
	})
	Student selectBySsnAndPassword(@Param("ssn") String ssn, @Param("password") String password);
	
	@Select("select * from student where ssn in (select student_ssn from transcriptentity where sectionNo=#{sectionNo})")
	@Results({
			@Result(id=true,column="ssn" ,property="ssn"),
			@Result(column="name" ,property="name"),
			@Result(column="degree" ,property="degree"),
			@Result(column="major" ,property="major"),
			@Result(column="password" ,property="password")
	})
	ArrayList<Student> selectStudentBySectionNo(int sectionNo);
	
	@Select("select * from student")
	@Results({
		@Result(id=true,column="ssn" ,property="ssn"),
		@Result(column="ssn" , property="attends",
				many=@Many(select="com.ec.dao.SectionDao.selectByStudentSn",
						fetchType=FetchType.LAZY)),
		@Result(column="ssn" , property="planOfStudy",
		many=@Many(select="com.ec.dao.CourseDao.selectByStudentSn",
				fetchType=FetchType.LAZY)),
		
	})
	ArrayList<Student> load();
	
	@Select("select * from student where ssn=#{ssn}")
	@Results({
		@Result(id=true,column="ssn" ,property="ssn"),
		@Result(column="ssn" , property="attends",
				many=@Many(select="com.ec.dao.SectionDao.selectByStudentSn",
						fetchType=FetchType.LAZY)),
		@Result(column="ssn" , property="planOfStudy",
		many=@Many(select="com.ec.dao.CourseDao.selectByStudentSn",
				fetchType=FetchType.LAZY))
	})
	Student selectBySsn(String ssn);
}
