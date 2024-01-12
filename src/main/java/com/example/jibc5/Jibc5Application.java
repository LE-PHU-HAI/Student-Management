package com.example.jibc5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jibc5.entity.Student;
import com.example.jibc5.repository.StudentRepository;

@SpringBootApplication
public class Jibc5Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Jibc5Application.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
	}

}
