package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Deleted " + id;
    }

    public Student updateStudent(Student student) {
        Student existing = repository.findById(student.getId()).orElse(null);
        if(existing == null) return null;
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        return repository.save(existing);
    }
}