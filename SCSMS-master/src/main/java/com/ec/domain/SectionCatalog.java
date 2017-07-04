package com.ec.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.ec.dao.SectionDao;
import com.ec.dao.TranscriptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class SectionCatalog{
	private ArrayList<Section> sectionCatalog;
	private HashMap<String,Section> map;
	public SectionCatalog(ArrayList<Section> sectionCatalog,HashMap<String,Section> map) {
		super();
		sectionCatalog =new ArrayList<Section>();
		map=new HashMap<String,Section>();
	}
	
	public SectionCatalog() {
		super();
	}
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private TranscriptDao transcriptDao;
	@PostConstruct
	public void init(){
		ArrayList<Section> list=load();
		this.sectionCatalog=list;
		int size=list.size();
		HashMap<String,Section> hashmap=new HashMap<String,Section>();
		
		for(int i=0;i<size;i++){
			hashmap.put(String.valueOf(list.get(i).getSectionNo()), list.get(i));
		}
		this.map=hashmap;
	}
	private ArrayList<Section> load() {
		ArrayList<Section> list=sectionDao.load();
		return list;
	}

	@PreDestroy
	public void preDestroy(){
				
	}
	public void sectionAddEnrolledStudent(Student student, Section section) {
		map.get(String.valueOf(section.getSectionNo())).getEnrolledStudents().add(student);
			String ssn=student.getSsn();
			int sectionNo=section.getSectionNo();
			transcriptDao.add(ssn, sectionNo);
	}
	public ArrayList<Section> getSectionCatalog() {
		return sectionCatalog;
	}

	public void setSectionCatalog(ArrayList<Section> sectionCatalog) {
		this.sectionCatalog = sectionCatalog;
	}

	public HashMap<String, Section> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Section> map) {
		this.map = map;
	}

	

	

	
	
}
