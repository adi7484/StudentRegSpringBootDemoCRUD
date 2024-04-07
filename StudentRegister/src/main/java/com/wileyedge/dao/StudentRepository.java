package com.wileyedge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wileyedge.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
}
