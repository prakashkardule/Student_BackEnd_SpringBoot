package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.pojo.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
