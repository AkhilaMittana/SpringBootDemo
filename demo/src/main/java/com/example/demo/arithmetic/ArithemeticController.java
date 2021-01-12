package com.example.demo.arithmetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithemeticController {
	@Autowired
	public DivServices ds;
	@Autowired
	public AddServices as;
	@Autowired
	public SubServices ss;
	@Autowired
	public MulServices ms;
	
	@PostMapping(value="/division")
	public String division(@RequestBody Arithemetic n) {
		return ds.division(n);
	}
	@PostMapping(value="/add")
	public String add(@RequestBody Arithemetic n) {
		return as.add(n);
	}
	@PostMapping(value="/sub")
	public String sub(@RequestBody Arithemetic n) {
		return ss.sub(n);
	}
	@PostMapping(value="/mul")
	public String mul(@RequestBody Arithemetic n) {
		return ms.mul(n);
	}
}
