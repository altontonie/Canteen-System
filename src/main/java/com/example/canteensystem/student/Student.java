package com.example.canteensystem.student;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer studentId;

    private String name;
    private String surname;

    @Column(nullable = false, unique = true)
    private String regNo;

    private String allergy;

    @Column(nullable = false)
    private String password;

    public Student() {
    }

    public Student(String name, String surname, String regNo, String allergy, String password) {
        this.name = name;
        this.surname = surname;
        this.regNo = regNo;
        this.allergy = allergy;
        this.password = password;
    }

    public Student(Integer studentId, String name, String surname, String regNo, String allergy, String password) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.regNo = regNo;
        this.allergy = allergy;
        this.password = password;
    }


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", regNo='" + regNo + '\'' +
                ", allergy='" + allergy + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
