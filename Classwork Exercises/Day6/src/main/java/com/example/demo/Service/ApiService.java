package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;

@Service
public class ApiService 
{
    @Autowired
    ChildRepo sr;
    
    public Child saveinfo(Child ss)
    {
    	return sr.save(ss);
    }
    
    public List<Child> showinfo()
    {
    	return sr.findAll();
    }
    
    public List<Child> sortinfo(String name)
    {
    	return sr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,name));
    }
    
    public List<Child> getbypage(int pgno,int pgsize)
    {
    	Page<Child> p = sr.findAll(PageRequest.of(pgno, pgsize));
    	return p.getContent();
    }
    
    public List<Child> sortandpage(String name,int pgno,int pagesize)
    {
    	Sort sort = Sort.by(name).ascending();
    	Page<Child> p = sr.findAll(PageRequest.of(pgno, pagesize, sort));
    	return p.getContent();
    }
}
