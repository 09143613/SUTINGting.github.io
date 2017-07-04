package com.ec.specification;

import com.ec.domain.Course;
import com.ec.domain.Section;
import com.ec.domain.Student;
import com.ec.domain.TranscriptEntity;
import org.springframework.stereotype.Service;

@Service("selectionSectionSpecification")
public class SelectionSectionSpecification implements Specification<Section> {
	@Override
	public String validate(Student student, Section section) {
		String result=null;
		boolean ifPlan=false;
		boolean ifSelect=false;
		boolean ifPrevCan=false;
		for(Course course:student.getPlanOfStudy()){
			if(course.getNumber().equals(section.getCourse().getNumber())){
				ifPlan=true;
				break;
			}
		}
		if(ifPlan==true){
			if(student.getAttends()==null){
				
			}else{
				for(Section s:student.getAttends()){
					if(s.getCourse().getNumber().equals(section.getCourse().getNumber())){
						ifSelect=true;
						break;
					}
				}
			}
		}
		if(ifPlan==true&&ifSelect==false){
			if(section.getCourse().getPrevCourse()!=null){
				for(Course c:section.getCourse().getPrevCourse()){
					ifPrevCan=false;
					if(student.getTranscript()==null){
						
					}else{
						for(TranscriptEntity t:student.getTranscript()){
							if(t.getSection().getCourse().getNumber().equals(c.getNumber())&&t.getGrade()>=60){
								ifPrevCan=true;
							}
						}
					}
					if(ifPrevCan==false){
						result="1";
						break;
					}
				}
			}
		}
		if(ifPlan==false){
			result="2";
			return result;
		}else if(section.getCapacity()<=section.getEnrolledStudents().size()){
			result="3";
			return result;
		}else if(ifSelect==true){
			result="4";
			return result;
		}
		return result;
	}
}
