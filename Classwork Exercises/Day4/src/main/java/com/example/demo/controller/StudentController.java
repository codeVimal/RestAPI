package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	StudentService sr;
	
	@GetMapping("getStudent")
	public List<Student> show(){
		return sr.read();
	}
	
	@GetMapping("getStudentId/{id}")
	public Optional<Student> showid(@PathVariable int id){
		return sr.readid(id);
	}
	
	@PostMapping("addStudent")
	public boolean add(@RequestBody Student st) {
		return sr.create(st);
	}
	
	@PutMapping("updateStudent")
	public Student update(@RequestBody Student st) {
		return sr.update(st);
	}
	
	@PutMapping("updateStudentParam")
	public String update(@RequestParam int id, @RequestBody Student st) {
		return sr.updateParam(id, st);
	}
	
	@DeleteMapping("deleteStudent")
	public String delete(@RequestBody Student st) {
		sr.delete(st);
		return "Record removed successfully";
	}
	
	@DeleteMapping("deleteStudentId/{id}")
	public boolean deleteid(@PathVariable int id) {
		boolean check = sr.deleteId(id);
			return check;
	}
	
	@DeleteMapping("deleteStudentParam")
	public boolean deleteparam(@RequestParam int id) {
		boolean check = sr.deleteParam(id);
		return check;
	}
}
