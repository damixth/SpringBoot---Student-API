package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String>{
    
    Optional<Student> findStudentByEmail(String email);
  
}
