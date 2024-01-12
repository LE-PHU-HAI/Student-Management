package com.example.jibc5.repository;

import com.example.jibc5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingOrEmailContaining(String name, String email);
}
