package com.wileyedge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.dao.IDao;
import com.wileyedge.model.Student;

@Service(value="service")
public class StudentService implements IService {
	@Autowired
	@Qualifier("dataJpaDao")
	private IDao dao;
	@Override
	public List<Student> findAll() {
		System.out.println("Inside findAll() of StudentService");
		return dao.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		System.out.println("Inside findById() method of StudentService");
		return dao.findById(id);
	}

	@Override
	public Student save(Student stud) {
		return dao.save(stud);
	}

	@Override
	public Student deleteById(int id) {
		
		return dao.deleteById(id);
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

}
