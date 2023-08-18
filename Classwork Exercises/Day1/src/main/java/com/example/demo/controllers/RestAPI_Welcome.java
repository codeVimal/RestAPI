package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI_Welcome {
	@GetMapping("disp")
	public String Welcome()
	{
		return "Welcome String Boot!";
	}
}
