package com.student.service;

import java.util.List;
import com.student.pojo.Student;

public interface IStudentService {
	
	public Student createStudent(Student s);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public void deleteStudent(int id);
	public Student updateStudent(int id, Student s);

}