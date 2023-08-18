package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorGame {
	@Value("${col}")
	String yourFavColor;
	@GetMapping("color")
	public String getMyFav()
	{
		return "My favorite color is "+yourFavColor;
	}
}
