package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.IStudentRepo;
import com.student.pojo.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo studentRepo;

	@Override
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void deleteStudent(int id) {
		Student student = studentRepo.findById(id).get();
		if (student != null) {
			studentRepo.delete(student);
		}
	}

	
	@Override
	public Student updateStudent(int id, Student s) {
		Student oldS = studentRepo.findById(id).get();
		if (oldS != null) {
			s.setId(id);
			return studentRepo.save(s);
		}
		return null;
	}

}

