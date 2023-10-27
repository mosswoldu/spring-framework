package com.student.management.system.demo.sms.repository;

import com.student.management.system.demo.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
