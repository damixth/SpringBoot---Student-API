package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
        return args -> {

            String email1 = "damixth@gmail.com";
            //String email2 = "tharani@gmail.com";

            Student damith = new Student("Damith",
            email1,
            LocalDate.of(1999, Month.OCTOBER, 7),
            LocalDateTime.now());


            repository.findStudentByEmail(email1)
                .ifPresentOrElse(s -> {
                    System.out.println("This Student already exists!" );
                    
                }, () -> {
                    System.out.println("Inserting student" );
                    repository.insert(damith);
                });
        };
    }

}
