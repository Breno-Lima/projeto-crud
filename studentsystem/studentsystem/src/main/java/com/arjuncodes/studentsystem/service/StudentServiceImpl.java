package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Student update() {
        return null;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return null;
    }


    @Override
    public Map<Object, Object> findById(Long id) {
        return null;
    }

    @Override
    public void studentFindById(Student student, Long id) {

    }

    @Override
    public void studentFindById(Long id) {

    }

    @Override
    public Student get(Integer id) {
        return null;
    }


}