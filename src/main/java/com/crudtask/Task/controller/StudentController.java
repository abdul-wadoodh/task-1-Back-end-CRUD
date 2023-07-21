package com.crudtask.Task.controller;

import com.crudtask.Task.model.Student;
import com.crudtask.Task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "*" )
@RestController()
@RequestMapping(value = "/students")

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
        Student updatedStudent = studentService.updateStudent(student, id);
        if (updatedStudent != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

}
