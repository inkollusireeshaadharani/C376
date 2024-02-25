package com.wileyedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.dao.IDao;
import com.wileyedge.model.Student;

@Service(value="service")
public class StudentService implements IService{
	
	@Autowired
	private IDao dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED )
	public void saveStudents(List<Student> studList) {
		for(Student s : studList) {
			dao.saveStudent(s);
		}
	}

}
