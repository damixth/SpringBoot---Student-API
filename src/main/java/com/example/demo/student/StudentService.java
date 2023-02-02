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

    public void addNewStudent(Student student){
        System.out.println("Added new student");
    }


    public void deleteStudent(String studentId) {
        boolean exists = studentRepository.existsById(studentId);
        
        if(!exists){
            throw new IllegalStateException(
                "Student with id " + studentId + " does not exist"
            );
        }
        studentRepository.deleteById(studentId);
    }
}
