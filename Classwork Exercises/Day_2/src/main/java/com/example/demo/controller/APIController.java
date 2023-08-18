package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
	@GetMapping("getName")
	
	public String  getName()
	{
		return "the name is Zero";
	}
}
