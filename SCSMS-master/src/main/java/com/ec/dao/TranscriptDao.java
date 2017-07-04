package com.ec.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.ec.domain.TranscriptEntity;

public interface TranscriptDao {
	@Select("select * from transcriptentity")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="grade",property="grade"),
		@Result(column="student_ssn",property="student",
		one=@One(select="dao.StudentDao.selectBySsn",
				fetchType=FetchType.EAGER)),
		@Result(column="sectionNo",property="section",
		one=@One(select="com.ec.dao.SectionDao.selectBySectionNo",
		fetchType=FetchType.EAGER))
	})
	ArrayList<TranscriptEntity> load();
	
	@Insert("insert into transcriptentity (sectionNo,student_ssn) values (#{sectionNo},#{ssn})")
	void add(@Param("ssn") String ssn, @Param("sectionNo") int sectionNo);
	
	

}