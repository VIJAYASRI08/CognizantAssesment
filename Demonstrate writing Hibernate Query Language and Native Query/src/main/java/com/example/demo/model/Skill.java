package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private List<Employee> employeeList;

    // Getters, setters, toString
}
