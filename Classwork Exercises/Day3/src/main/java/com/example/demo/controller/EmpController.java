package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	EmpService eserv;
	
	@PostMapping("addEmp")
	public Emp add(@RequestBody Emp e) {
		return eserv.saveInfo(e);
	}
	
	@GetMapping("showEmp")
	public List<Emp> get(Emp e){
		return eserv.showInfo();
	}
}
