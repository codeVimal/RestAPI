package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TransactionEntity;
import com.example.demo.service.DonorService;


@RestController
@CrossOrigin
public class Controller {
	@Autowired
	DonorService ss;
	@PostMapping("adddonor")
	public TransactionEntity add(@RequestBody TransactionEntity de)
	{
		return ss.savedonor(de);
	}
	@GetMapping("showdetails")
	public List<TransactionEntity> show()
	{
		return ss.showinfo();
	}
	@GetMapping("showbyid/{donorId}")
	public Optional<TransactionEntity> showid(@PathVariable int donorId)
	{
		return ss.showbyid(donorId);
	}
	@PostMapping("addndonor")
	public List<TransactionEntity> addndetails(@RequestBody List <TransactionEntity> de)
	{
		return ss.savedetails(de);
	}
	@PutMapping("update")
	public TransactionEntity modify(@RequestBody TransactionEntity de)
	{
		return ss.changeinfo(de);
	}
	@PutMapping("updatebyparam")
	public String update(@RequestParam int id, @RequestBody TransactionEntity de) {
		return ss.updateParam(id, de);
	}
	@DeleteMapping("deletedetail")
	public String del(@RequestBody TransactionEntity de)
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
	@GetMapping("sortbyname/{firstName}")
	public List<TransactionEntity> getsortinfo(@PathVariable String firstName)
	{
		return ss.sortinfo(firstName);
	}
	@GetMapping("paging/{pageno}/{pagesize}/{lastName}")
	public List<TransactionEntity> showpageinfo(@PathVariable int pageno, @PathVariable int pagesize, @PathVariable String lastName)
	{
		return ss.getbypage(pageno, pagesize, lastName);
	}
	@GetMapping("sortbytrid")
	public List<TransactionEntity> sortbytraid()
	{
		return ss.sbytid();
	}
	@DeleteMapping("qdelbyid/{id}")
	public void del4(@PathVariable int id) {

		ss.qdelbyid(id);
		return ;
	}
	@PutMapping("qupdate6")
	public void updateidbyq()
	{
		ss.updateid6();
		return;
	}
}
