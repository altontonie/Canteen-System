package com.example.canteensystem.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findStudentByStudentId(Integer studentId);

    Boolean existsStudentByRegNoAndPassword(String regNo, String password);

    Student findStudentByRegNo(String regNo);

}
