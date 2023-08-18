package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Name {
	@Value("${stu}")
	String studentName;
	@GetMapping("name")
	public String getName()
	{
		return "Welcome "+studentName+"!";
	}
}
