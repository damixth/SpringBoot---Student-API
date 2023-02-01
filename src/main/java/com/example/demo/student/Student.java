package com.example.demo.student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("students")
public class Student{

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    private LocalDateTime created;

    public Student(String name, String email, LocalDate dob, LocalDateTime created) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.created = created;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

}