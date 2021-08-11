package com.example.canteensystem.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunnerStudent(StudentRepository repository){
        return args -> {
            Student alton = new Student(
                    "alton",
                    "nyamz",
                    "E00",
                    "nuts",
                    "123");
            Student ivy = new Student(
                    "ivy",
                    "nyamz",
                    "E022",
                    "",
                    "001");
            repository.saveAll(
                    List.of(alton,ivy)
            );
        };
    }
}
