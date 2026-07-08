package com.example.demo.entity;

import jakarta.persistence.*;

@Entity // Make table columns
@Table(name = "students_table")  // Make table
public class Student {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment (1, 2, 3...)

    private Integer id;
    private String name;
    private String email;

    // Default Constructor (For JSON conversion)
    public Student() {}
 
    public Student(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}