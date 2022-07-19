package com.example.springthymeleaf.controller;

import com.example.springthymeleaf.entity.Student;
import com.example.springthymeleaf.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    final StudentRepository studentService;

    @RequestMapping(path = "create", method = RequestMethod.GET)
    public String createStudent(Model model) {
//        Student student = new Student("A001", "quang", "quang@gmail.com", "0123456789", 1);
        model.addAttribute("student", new Student());
        return "views/students/create";
    }
    @RequestMapping(path = "create", method = RequestMethod.POST)
    public String processSaveStudent(@Valid @ModelAttribute("student")Student student,
                                     BindingResult bindingResult,
                                     Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("student",student);
            return "view/students/create";
        }
        studentService.save(student);
        return "redirect:admin/students/create";
    }
}
