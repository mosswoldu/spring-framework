package com.student.management.system.demo.sms;

import com.student.management.system.demo.sms.model.Student;
import com.student.management.system.demo.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Student std= new Student("Ramesh","Ali","ramesh@miu.com");
		studentRepository.save(std);
		Student std1= new Student("Sujit","Shiresta","sujit.shresta@miu.com");
		studentRepository.save(std1);
		Student std3= new Student("John","Doe","jdoe@miu.com");
		studentRepository.save(std3);

	}
}
