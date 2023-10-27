package com.student.management.system.demo.sms.controller;


import com.student.management.system.demo.sms.model.Student;
import com.student.management.system.demo.sms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to handle student lists and return model and view
    @GetMapping("/api/student")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        //return is view
        // go to bootstatp 5 css cdn
        //copy the css link
        // componnet then to table
        return "students";
    }

    @GetMapping("/api/student/new")
    public String createStudentForm(Model model) {
        //craete student object to hold from data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/api/student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/api/student";
    }

    @GetMapping("/api/student/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentByID(id));
        return "edit_student";
    }

    @PostMapping("api/student/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student, Model model) {
        //get student from db
        Student existingStudent = studentService.getStudentByID(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        //save
        studentService.updateStudent(existingStudent);
        return "redirect:/api/student";
    }

    @GetMapping("/api/student/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/api/student";

    }
}