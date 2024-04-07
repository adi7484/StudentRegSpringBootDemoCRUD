package com.wileyedge.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private long id;
	private String name;
	private int age;
	private int marks;
	private int attendance;
	private boolean promotion_status=false;
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public boolean isPromotion_status() {
		return promotion_status;
	}
	public void setPromotion_status(boolean promotion_status) {
		this.promotion_status = promotion_status;
	}
	
	public Student(long id, String name, int age, int marks, int attendance, boolean promotion_status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.attendance = attendance;
		this.promotion_status = promotion_status;
	}
	public Student() {
		super();
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + ", attendance="
				+ attendance + ", promotion_status=" + promotion_status + "]";
	}
	
	
	
}
