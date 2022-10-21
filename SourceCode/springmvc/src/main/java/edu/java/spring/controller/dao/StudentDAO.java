package edu.java.spring.controller.dao;

import edu.java.spring.controller.Student;

import java.util.List;

public interface StudentDAO {
    public void insert(Student student);

    public List<Student> list();

}
