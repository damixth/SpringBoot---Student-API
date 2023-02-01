package com.example.demo.student;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    @GetMapping
    public List<Student> getStudents() {
		    return studentRepository.findAll();
    }
}
