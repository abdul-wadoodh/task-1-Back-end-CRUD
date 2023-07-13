package com.crudtask.Task.controller;

import com.crudtask.Task.model.Student;
import com.crudtask.Task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getStudents();

    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
