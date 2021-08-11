package com.example.canteensystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Boolean isStudent(Student student){
        return studentRepository.existsStudentByRegNoAndPassword(student.getRegNo(),student.getPassword());
    }


    public Student getStudent(Student student) {
        return studentRepository.findStudentByRegNo(student.getRegNo());
    }
}
