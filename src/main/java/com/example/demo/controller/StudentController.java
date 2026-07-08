package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/data")
    public String getData() {
        return "Hi, I am from data";
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = service.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {

        List<Student> students = service.getAllStudents();

        if (students.isEmpty()) {
            return new ResponseEntity<>("No students found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {

        Student student = service.getStudentById(id);

        if (student == null) {
            return new ResponseEntity<>(
                    "Student not found with id : " + id,
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {

        Student updatedStudent = service.updateStudent(student);

        if (updatedStudent == null) {
            return new ResponseEntity<>(
                    "Student not found with id : " + student.getId(),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        Student student = service.getStudentById(id);

        if (student == null) {
            return new ResponseEntity<>(
                    "Student not found with id : " + id,
                    HttpStatus.NOT_FOUND);
        }

        service.deleteStudent(id);

        return new ResponseEntity<>(
                "Student deleted successfully",
                HttpStatus.OK);
    }
}