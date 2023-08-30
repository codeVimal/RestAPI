package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Child;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController 
{
     @Autowired
     ApiService sser;
     
     @PostMapping("AddDetail")
     public Child add(@RequestBody Child ss)
     {
    	 return sser.saveinfo(ss);
     }
     
     @GetMapping("ShowDetails")
     public List<Child> show()
     {
    	 return sser.showinfo();
     }
     
     @GetMapping("SortDetails/{str}")
     public List<Child> getsortinfo(@PathVariable String str)
     {
    	 return sser.sortinfo(str);
     }
     
     @GetMapping("Paging/{pgno}/{pagesize}")
     public List<Child> showpageinfo(@PathVariable int pgno,@PathVariable int pagesize)
     {
    	 return sser.getbypage(pgno, pagesize);
     }
     
     @GetMapping("SortAndPage/{pageno}/{pagesize}/{str}")
     public List<Child> pageandsort(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String str)
     {
    	 return sser.sortandpage(str, pageno, pagesize);
     }
}
