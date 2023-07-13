package com.crudtask.Task.model;

import jakarta.persistence.*;


@Entity
@Table(name = "student")
public class Student {


    @Id
    @GeneratedValue
    private int StudentId;
    private String StudentName;
    private String Email;
    private int number;
    private String Department;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
