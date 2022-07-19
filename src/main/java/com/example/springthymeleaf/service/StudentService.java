package com.example.springthymeleaf.service;


import com.example.springthymeleaf.entity.Student;
import com.example.springthymeleaf.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {
    final StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }
}
