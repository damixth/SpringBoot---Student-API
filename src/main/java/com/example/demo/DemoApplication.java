package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@SpringBootApplication
@EnableMongoRepositories
public class DemoApplication implements CommandLineRunner{

    @Autowired
    StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
       
        System.out.println("------------------ CREATE Students --------------------------\n");
        
        createStudents();
        
    }

    private void createStudents() {

        System.out.println("Data creation started...");

        Student damith = new Student("Damith",
                     "damixth@gmail.com",
                     LocalDate.of(1999, Month.OCTOBER, 7));
        Student tharani = new Student(
                    "tharani",
                    "tharani@gmail.com",
                    LocalDate.of(1999, Month.JUNE, 24));

        studentRepository.saveAll(List.of(damith, tharani));

		
    }
}

