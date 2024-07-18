package com.example.AprilDemoMaven.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AprilDemoMaven.dao.UserDAO;
import com.example.AprilDemoMaven.model.User;

import io.swagger.annotations.Api;

@RestController

public class UserController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping("/userhome")
	public String home() {
		System.out.println("In user  home");
		return "adduser.jsp";
	}

	@RequestMapping("/toadduser")
	public String saveUser() {
		System.out.println("In user home ot save");
		User user = new User("rama", 4567890, "rama@gmail.com");
		userDAO.save(user);
		return "success.jsp";
	}
}
