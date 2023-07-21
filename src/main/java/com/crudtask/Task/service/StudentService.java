package com.crudtask.Task.service;

import com.crudtask.Task.model.Student;
import com.crudtask.Task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }



    public Student updateStudent(Student student, Integer id) {
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Record not found"));
        updateStudent.setStudentName(student.getStudentName());
        updateStudent.setDepartment(student.getDepartment());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setNumber(student.getNumber());
        studentRepository.save(updateStudent);
        return updateStudent;
    }
    public boolean deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return false;
    }
}
