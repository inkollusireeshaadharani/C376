package com.wileyedge.dao;

import java.util.List;
import java.util.Optional;

import com.wileyedge.model.Student;

public interface IDao {
	public List<Student> findAll();
	Optional<Student> findById(int id);
	public Student save(Student stud);
	public Student deleteById(int id);
	public List<Student> findByName(String name);
}
