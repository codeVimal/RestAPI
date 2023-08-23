package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Emp;
import com.example.demo.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo e;
	public Emp saveInfo(Emp ed) {
		return e.save(ed);
	}
	public List<Emp> showInfo(){
		return e.findAll();
	}
}
