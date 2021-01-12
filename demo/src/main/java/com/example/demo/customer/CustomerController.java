package com.example.demo.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	public Customerservice customerservices;
	   
	@PostMapping("/productinsert")
	public Map addCustomer(@RequestBody Customer product) {
		Map addproduct = null;
				try {
			addproduct = customerservices.addCustomer(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return addproduct;
	    }
	@CrossOrigin
	@PostMapping("/productupdate")
	public Map updateCustomer(@RequestBody Customer product) {
		  return customerservices.updateCustomer(product);
	    }
	@CrossOrigin
	@GetMapping("/getcustomer_p")
	public List getCustomer(@RequestBody Customer product) {
		return customerservices.getCustomer(product.getCustomerId());
	}

	@CrossOrigin
	@GetMapping("/getAllCustomer")
	public List getAllDetails() {
		return customerservices.getAllDetails();
	}
	

	}


