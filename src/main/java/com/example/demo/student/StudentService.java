package com.example.demo.student;

import java.time.LocalDateTime;
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
    
        if(studentRepository
        .findStudentByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("This email already exists!" );
        }

        student.setCreated(LocalDateTime.now());
    
        studentRepository.save(student);
    
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
