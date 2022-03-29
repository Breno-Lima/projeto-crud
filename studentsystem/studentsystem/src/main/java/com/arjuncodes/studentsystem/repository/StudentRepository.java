package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    @Override
    default Optional<Student> findById(Integer aLong) {
        return null;
    }

    @Override
    Student getById(Integer aLong);



}