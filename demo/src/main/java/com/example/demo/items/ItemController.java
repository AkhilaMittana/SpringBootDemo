package com.example.demo.items;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ItemController {
	@Autowired
	public Itemservice itemservice;
	
	@PostMapping("/iteminsert")
	public Map insertItems(@RequestBody Item item) {
		Map additem = null;
				try {
			additem = itemservice.insertItems(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PostMapping("/update")
	public Map updateItem(@RequestBody Item item) {
		return itemservice.updateItem(item);
	}

	
	@CrossOrigin
	@GetMapping("/get")
	public List getItem(@RequestBody Item item) {
		return itemservice.get(item.getId());
	}

	@CrossOrigin
	@GetMapping("/getAll")
	public List getAllItem() {
		return itemservice.getAll();
	}

	}