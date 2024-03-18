package com.wileyedge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wileyedge.model.Student;

@Repository("dataJpaDao")
public interface StudentJpaRepository extends JpaRepository<Student, Integer>, IDao {
	@Query
	public List<Student> findByName(String name);
}
