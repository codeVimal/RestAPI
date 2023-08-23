package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo s;
	
	public boolean create(Student st) {
		if(!s.existsById(st.getId())) {
			s.save(st);
			return true;
		}
		else
			return false;
	}
	
	public List<Student> read(){
		return s.findAll();
	}
	
	public Optional<Student> readid(int id){
		return s.findById(id);
	}
	
	public Student update(Student st) {
		return s.saveAndFlush(st);
	}
	
	public String updateParam(int id, Student st) {
		if(s.existsById(id)){
			s.saveAndFlush(st);
			return "Updated";
		}
		else
			return "Please enter an existing id";
	}
	
	public void delete(Student st) {
		s.delete(st);
	}
	
	public boolean deleteId(int id) {
		s.deleteById(id);
		if(!s.existsById(id))
			return true;
		else
			return false;
	}
	
	public boolean deleteParam(int id) {
		s.deleteById(id);
		if(!s.existsById(id))
			return true;
		else
			return false;
	}
}
