package com.example.demo.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class Itemservice {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, String> insertItems(Item item) {

		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO item (id,name,description,price) VALUES (:Id,:Name,:Description,:Price)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource().addValue("Id", item.getId())
					.addValue("Name", item.getName())
					.addValue("Description",item.getDescription())
					.addValue("Price", item.getPrice());

			result = namedParameterJdbcTemplate.update(sql, parameters);
			if (result > 0)
				data.put("success", "Record inserted successfully");
			else
				data.put("failed", "Record failed to insert, please try again!");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
			
		}
		
		return data;

	}
	public Map<String, String> updateItem(Item item) {
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "update item set price=? where name=?";
		try {
			result = jdbcTemplate.update(sql,item.getPrice(),item.getName());
			if (result > 0)
				data.put("success", "updated successfully");
			else
				data.put("failed", "updation failed");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
	        System.out.println(e.getMessage());
		}
		
		return data;
	}

	

	public List get(int id) {
		
		Map dataMap = new HashMap();
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select id,name,description,price from item where id = ?";
		try {
			dataList = jdbcTemplate.queryForList(sql, id);

			for (Map<String, Object> row : dataList) {
				dataMap.put("id", row.get("id"));
				dataMap.put("name", row.get("name"));
				dataMap.put("phoneNumber", row.get("description"));
				dataMap.put("email", row.get("price"));
				responseList.add(dataList);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");
		}
		
		return responseList;
	}

	public List getAll() {
		
		Map dataMap = null;
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select * from item";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("id", row.get("id"));
				dataMap.put("name", row.get("name"));
				dataMap.put("description", row.get("description"));
				dataMap.put("price", row.get("price"));
				responseList.add(dataMap);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");

		}
		
		return responseList;
	}

}