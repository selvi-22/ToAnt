package com.example.AprilDemoMaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AprilDemoMaven.dao.MovieDAO;
import com.example.AprilDemoMaven.model.Movie;

import io.swagger.annotations.Api;

@RestController

public class MovieController {
	@Autowired
	MovieDAO movieDAO;

	@RequestMapping("/movie")
	public String home() {
		// System.out.println("In home Page");
		return "addmovie.jsp";
	}

	@GetMapping("/addMovie")
	public String saveMovie() {
		System.out.println("in add movie in controller");
		Movie movie = new Movie();
		movieDAO.saveMovie(movie);
		System.out.println("Added");
		return "success.jsp";
	}

	@GetMapping("/toAddMovie")
	public String addMovie(@RequestParam("name") String name, @RequestParam("length") Integer length,
			@RequestParam("genre") String genre) {
		System.out.println("in add movie in controller");
		Movie movie = new Movie();
		movieDAO.saveMovie(movie);
		System.out.println("Added");
		return "success.jsp";
	}
}
