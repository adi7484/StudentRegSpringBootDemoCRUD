package com.wileyedge.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wileyedge.dao.StudentRepository;
import com.wileyedge.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentDao;
//	List<Student> list;
	
//	public StudentServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Student(123,"adi",123));
//		list.add(new Student(124,"pooja",1234));
//	}
	
	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(long studentId) {
//		Student s=null;
//		for(Student student:list) {
//			if(student.getId()==studentId) {
//				s=student;
//				break;
//			}
//		}
		
		return studentDao.getOne(studentId);
	}

	@Override
	public Student addStudent(Student student) {
		
//		list.add(student);
		studentDao.save(student);
		return student;
	}

	@Override
	public void deleteStudent(long studentId) {
//		for(Student student:list) {
//			if(student.getId()==studentId) {
//				list.remove(student);
//				break;
//			}
//		}
		studentDao.deleteById(studentId);
	}

	@Override
	public Student updateStudent(Student student) {
//		list.forEach(e->{if(e.getId()==student.getId()) {
//				e.setMarks(student.getMarks());
//				e.setName(student.getName());
//		}
//	  });
		studentDao.save(student);
		return student;
	}

}
