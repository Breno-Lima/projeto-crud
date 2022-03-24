package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();


    Map<Object, Object> findById(Long id);

    void studentFindById(Student student, Long id);


    void studentFindById(Long id);

    Student get(Integer id);

    void delete(Integer id);

    void deleteById(int id);

    void deleteAll();
}
