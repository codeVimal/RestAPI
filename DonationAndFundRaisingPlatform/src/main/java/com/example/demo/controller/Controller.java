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

import com.example.demo.model.DonorEntity;
import com.example.demo.service.Service;

@RestController
public class Controller {
	@Autowired
	Service ss;
	@PostMapping("adddonor")
	public DonorEntity add(@RequestBody DonorEntity de)
	{
		return ss.savedonor(de);
	}
	@GetMapping("showdetails")
	public List<DonorEntity> show()
	{
		return ss.showinfo();
	}
	@GetMapping("showbyid/{donorId}")
	public Optional<DonorEntity> showid(@PathVariable int donorId)
	{
		return ss.showbyid(donorId);
	}
	@PostMapping("addndonor")
	public List<DonorEntity> addndetails(@RequestBody List <DonorEntity> de)
	{
		return ss.savedetails(de);
	}
	@PutMapping("update")
	public DonorEntity modify(@RequestBody DonorEntity de)
	{
		return ss.changeinfo(de);
	}
	@PutMapping("updatebyparam")
	public String update(@RequestParam int id, @RequestBody DonorEntity de) {
		return ss.updateParam(id, de);
	}
	@DeleteMapping("deletedetail")
	public String del(@RequestBody DonorEntity de)
	{
		ss.deleteinfo(de);
		return "Deleted successfully";
	}
	@DeleteMapping("deletebyid/{id}")
	public String delid (@PathVariable int id)
	{
		ss.deleteid(id);
		return "Deleted Successfully";
	}
}
