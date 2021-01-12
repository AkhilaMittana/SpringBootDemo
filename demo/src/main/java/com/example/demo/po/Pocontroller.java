package com.example.demo.po;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class Pocontroller {
	
	@RestController
	public class ItemController {
		@Autowired
		public Poservice poservices;
		
		@PostMapping("/insertdata")
		public Map insertPo(@RequestBody Po port) {
			Map addvalues = null;
					try {
				addvalues = poservices.insertDetails(port);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
					return addvalues;
		}
		 @CrossOrigin
		@PostMapping("/updatedata")
		public Map updatePo(@RequestBody Po port) {
			return poservices.updatePo(port);
		}

		
		@CrossOrigin
		@GetMapping("/getdetails")
		public List get_Detail(@RequestBody Po port) {
			return poservices.get_Detail(port.getPoId());
		}

		@CrossOrigin
		@GetMapping("/getAll_Details")
		public List getAll_Details() {
			return poservices.getAll_d();
			}

		}
	
	}

