package com.example.AprilDemoMaven.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AprilDemoMaven.dao.StudentImpl;
import com.example.AprilDemoMaven.model.Student;

import io.swagger.annotations.Api;

@RestController

public class MyController {
	@Autowired
	StudentImpl studentImpl;

	@RequestMapping("/home")
	public String home() {
		// System.out.println("In home Page");
		return "home.jsp";
	}

	@RequestMapping("/save")
	public String save() {
		// System.out.println("In Page to save - form");
		return "success.jsp";
	}

	@GetMapping("/register")
	public String saveStudent(@RequestParam("name") String name, @RequestParam("grade") Integer grade)
			throws ClassNotFoundException, SQLException {
		System.out.println("In register handler");
		Student student = new Student();
		// Validators
		student.setName(name);
		student.setGrade(grade);
		System.out.println(student.getName() + student.getGrade());
		studentImpl.insertStudent(student);
		return "success.jsp";
	}
}
