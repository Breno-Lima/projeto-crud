package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Novo aluno adicionado!";
    }

    @GetMapping("/getAll")
    public List<Student> list() {
        return studentService.getAllStudents();
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        studentService.deleteById(id);

    }

    @GetMapping("{id}")
    public void getStudentById(@PathVariable("id") Long id) {
        studentService.studentFindById(id);

    }
/*
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }
    */

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("studentId") int studentId){
        this.studentService.updateStudent(studentId, student);
        return student;
    }
}
