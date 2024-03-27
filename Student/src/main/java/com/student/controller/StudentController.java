package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.pojo.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService StudentService;

	@PostMapping("/save")
	ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student student1 = StudentService.createStudent(student);
		return new ResponseEntity<Student>(student1, HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = StudentService.getAllStudent();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {

		return new ResponseEntity<Student>(StudentService.getStudentById(id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {
		StudentService.deleteStudent(id);
		return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student){
		return new ResponseEntity<Student>(StudentService.updateStudent(id, student),HttpStatus.OK);
		
	}

}
