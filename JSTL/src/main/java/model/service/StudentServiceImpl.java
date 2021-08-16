package model.service;

import model.bean.Student;

import model.repository.StudentRepository;
import model.repository.StudentRepositoryImpl;
import model.service.commons.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentServiceImpl implements StudentService {

    private StudentRepository repository = new StudentRepositoryImpl();


    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, String> save(Student student) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validate.validateName(student.getName()) != null
            || Validate.validatePoint(student.getPoint()) != null
        ) {
            mapMessage.put("name", Validate.validateName(student.getName()));
            mapMessage.put("point", Validate.validatePoint(student.getPoint()));
        } else {
        repository.save(student);
        }
        return mapMessage;
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
