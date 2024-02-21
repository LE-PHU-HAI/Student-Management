package com.example.jibc5.service;

import java.util.List;

import com.example.jibc5.entity.Student;

import org.springframework.data.domain.Page;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    List<Student> searchStudents(String keyword);

    Page<Student> getAllStudentsPaginated(int pageNo, int pageSize);
}

