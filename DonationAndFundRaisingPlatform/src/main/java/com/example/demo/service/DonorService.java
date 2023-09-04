package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.demo.model.TransactionEntity;
import com.example.demo.repository.Repo;

@org.springframework.stereotype.Service
public class DonorService {
	@Autowired
	Repo r;
	public TransactionEntity savedonor(TransactionEntity de)
	{
		return r.save(de);
	}
	public List<TransactionEntity> savedetails(List<TransactionEntity> de)
	{
		return (List<TransactionEntity>)r.saveAll(de);
	}
	public List<TransactionEntity> showinfo()
	{
		return r.findAll();
	}
	public Optional<TransactionEntity> showbyid(int id)
	{
		return r.findById(id);
	}
	public TransactionEntity changeinfo(TransactionEntity de)
	{
		return r.saveAndFlush(de);
	}
	public String updateParam(int id, TransactionEntity de) {
		if(r.existsById(id)){
			r.saveAndFlush(de);
			return "Updated";
		}
		else
			return "Please enter an existing id";
	}
	
	public void deleteinfo(TransactionEntity de)
	{
		r.delete(de);
	}
	public void deleteid(int id)
	{
		r.deleteById(id);
	}
	public List<TransactionEntity> sortinfo(String s)
	{
		return r.findAll(Sort.by(Direction.ASC,s));
	}
	public List<TransactionEntity> getbypage(int pgno,int pgsize, String lastName)
	{
		Page<TransactionEntity> p = r.findAll(PageRequest.of(pgno, pgsize,Sort.by("lastName")));
		return p.getContent();
	}	
	public List<TransactionEntity> sbytid()
	{
		return r.sortbytid();
	}
	public void qdelbyid(int id)
	{
		r.deletemebyid(id);
		return;
	}
	public void updateid6()
	{
		r.updatebyq();
		return;
	}
}
