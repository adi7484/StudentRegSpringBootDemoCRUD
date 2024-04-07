package com.wileyedge.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wileyedge.dao.StudentRepository;
import com.wileyedge.entities.Student;
import com.wileyedge.exception.CustomException;


@RestController
@RequestMapping("/students")
public class StudentController {
	

	@Autowired
	private final StudentRepository studentRepository ;
	
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	// Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    // Add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) throws CustomException {
        // Validate marks and attendance
        if (student.getMarks() < 0 || student.getMarks() > 100) {
            throw new CustomException("Marks should be between 0 and 100",404);
        }
        if (student.getAttendance() < 0 || student.getAttendance() > 100) {
            throw new CustomException("Attendance should be between 0 and 100",404);
        }
        return studentRepository.save(student);
    }

    // Update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) throws CustomException {
        // Validate marks and attendance
        if (updatedStudent.getMarks() < 0 || updatedStudent.getMarks() > 100) {
            throw new CustomException("Marks should be between 0 and 100",404);
        }
        if (updatedStudent.getAttendance() < 0 || updatedStudent.getAttendance() > 100) {
            throw new CustomException("Attendance should be between 0 and 100",404);
        }
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    // Update promotion status of student by ID
    @PutMapping("/{id}/updatePromotionStatus")
    public Student updatePromotionStatus(@PathVariable Long id) throws CustomException {
    	
        Student student = studentRepository.findById(id).orElse(null);
    	
        if (student == null) {
            return null;
        }
        boolean promotionStatus = student.getMarks() > 85 && student.getAttendance() > 85;
        student.setPromotion_status(promotionStatus);
        return studentRepository.save(student);
    
    		
    }
}
