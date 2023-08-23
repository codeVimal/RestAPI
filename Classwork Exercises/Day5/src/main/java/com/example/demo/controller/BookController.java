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

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bser;
	
	@GetMapping("getBook")
	public List<Book> show(){
		return bser.read();
	}
	
	@GetMapping("getBookId/{id}")
	public Optional<Book> showid(@PathVariable int id) {
		return bser.readid(id);
	}
	
	@PostMapping("addBook")
	public boolean add(@RequestBody Book bk) {
		return bser.create(bk);
	}
	
	@PutMapping("updateBook")
	public Book updateId(@RequestParam int id, @RequestBody Book bk) {
		return bser.updateId(id, bk);
	}
	
	@DeleteMapping("deleteBook/{id}")
	public boolean delete(@PathVariable int id) {
		return bser.deleteId(id);
	}
}
