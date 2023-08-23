package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo b;
	
	public List<Book> read(){
		return b.findAll();
	}
	
	public Optional<Book> readid(int id) {
		return b.findById(id);
	}
	
	public boolean create(Book bk) {
		if(!b.existsById(bk.getId())) {
			b.save(bk);
			return true;			
		}
		else
			return false;
	}
	
	public Book updateId(int id, Book bk) {
		if(b.existsById(id)) {
			return b.saveAndFlush(bk);
		}
		else {
			System.out.println("Please enter a valid id");
			return bk;
		}
	}
	
	public boolean deleteId(int id) {
		if(b.existsById(id)) {
			b.deleteById(id);
			return true;
		}
		else
			return false;
	}
}
