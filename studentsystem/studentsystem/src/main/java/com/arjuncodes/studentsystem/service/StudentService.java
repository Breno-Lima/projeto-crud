package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Student;

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

    public Student update();

    Student updateStudent(int studentId, Student student);

    //update

    public default Student updateStudent(Student student, int studentId){
       student.setAddress(student.getAddress());
       student.setName(student.getName());
       return student;
    }
}
