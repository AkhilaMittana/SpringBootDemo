package com.example.demo.poitem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoItemController {
	@Autowired
	public PoItemService poitemservice;
	
	@PostMapping("/poiteminsert")
	public Map poItem_i(@RequestBody PoItem poitem) {
		Map addpoitem = null;
				try {
			addpoitem = poitemservice.poItem_i(poitem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return addpoitem;
	}
	@CrossOrigin
	@PostMapping("/poitemupdate")
	public Map poItem_u(@RequestBody PoItem poitem) {
		return poitemservice.poItem_u(poitem);
	}

	
	@CrossOrigin
	@GetMapping("/get_poitem")
	public List getPoItem(@RequestBody PoItem poitem) {
		return poitemservice.getPoItem(poitem.getPoId());
	}

	@CrossOrigin
	@GetMapping("/getAll_poitems")
	public List getAllPoItem() {
		return poitemservice.getAllDetails();
	}

	}

