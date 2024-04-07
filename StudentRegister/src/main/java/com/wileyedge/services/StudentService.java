package com.wileyedge.services;

import java.util.List;

import com.wileyedge.entities.Student;

public interface StudentService {
	public List<Student> getStudents();
	public Student getStudent(long studentId);
	public Student addStudent(Student student);
	public void deleteStudent(long studentId);
	public Student updateStudent(Student student);

}
