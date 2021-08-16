package model.service;

import model.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> findAll();

    Map<String, String> save(Student student);

    Student findById(int id);

    void remove(int id);

    //validationName..
}
