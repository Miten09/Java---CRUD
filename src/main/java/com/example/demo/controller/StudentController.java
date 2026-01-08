package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Frontend se connect karne ke liye zaroori
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentsById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}