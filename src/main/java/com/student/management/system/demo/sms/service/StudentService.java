package com.student.management.system.demo.sms.service;

import com.student.management.system.demo.sms.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> getStudents();
    public Student saveStudent(Student student);
    Student getStudentByID(Long id);
    public Student updateStudent(Student student);

    void deleteStudent(Long id);
}
