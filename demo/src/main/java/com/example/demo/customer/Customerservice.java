package com.example.demo.customer;

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
public class Customerservice {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, String> addCustomer1 (Customer product) {
 
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO Customer ( CustomerID,CustomerName, PhoneNumber, ShipToAddress, ShipToZip, ShipToCity, ShipToState) VALUES (:CustomerName, :PhoneNumber, :ShipToAddress, :ShipToZip, :ShipToCity, :ShipToState)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("CustomerName", product.getCustomerName())
					.addValue("PhoneNumber",product.getPhoneNumber())
					.addValue("ShipToAddress", product.getShipToAddress())
					.addValue("ShipToZip",product.getShipToZip())
					.addValue("ShipToCity",product.getShipToCity())
					.addValue("ShipToState",product.getShipToState());
					

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

	public Map addCustomer(Customer product) {
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "INSERT INTO Customer (CustomerName,PhoneNumber,ShipToAddress,ShipToZip,ShipToCity,ShipToState) VALUES (:CustomerName,:PhoneNumber,:ShipToAddress,:ShipToZip,:ShipToCity,:ShipToState)";
		try
		{
			System.out.println (product.getCustomerName());
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("CustomerName", product.getCustomerName())
					.addValue("PhoneNumber",product.getPhoneNumber())
					.addValue("ShipToAddress", product.getShipToAddress())
					.addValue("ShipToZip",product.getShipToZip())
					.addValue("ShipToCity",product.getShipToCity())
					.addValue("ShipToState",product.getShipToState());
					

			result = namedParameterJdbcTemplate.update(sql, parameters);
			if (result > 0)
				data.put("success", "Record inserted successfully");
			else
				data.put("failed", "Record failed to insert, please try again!");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
			System.out.println(e.getMessage());
			
		}
		
		return data;

	}
public Map<String, String> updateCustomer(Customer product) {
		
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "update item set shipToState=? where customerId =?";
		try {
			result = jdbcTemplate.update(sql,product.getShipToState(), product.getCustomerId());
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
public List getCustomer(int id) {
	
	Map dataMap = new HashMap();
	List responseList = new ArrayList();
	List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	String sql = "select CustomerName, PhoneNumber, ShipToAddress from customer where CustomerId = ?";
	try {
		dataList = jdbcTemplate.queryForList(sql, id);

		for (Map<String, Object> row : dataList) {
			dataMap.put("CustomerName", row.get("CustomerName"));
			dataMap.put("PhoneNumber", row.get("PhoneNumber"));
			dataMap.put("ShipToAddress", row.get("ShipToAddress"));
			
			responseList.add(dataList);
		}

	} catch (Exception e) {
		dataMap.put("error", "Error occured");
	}
	
	return responseList;
}
public List getAllDetails() {
	
	Map dataMap = null;
	List responseList = new ArrayList();
	List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	String sql = "select * from customer";

	try {
		dataList = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> row : dataList) {
			dataMap= new HashMap();
			dataMap.put("CustomerId", row.get("CustomerName"));
			dataMap.put("CustomerName", row.get("CustomerName"));
			dataMap.put("PhoneNumber", row.get("PhoneNumber"));
			dataMap.put("ShipToAddress", row.get("ShipToAddress"));
			dataMap.put("ShipToZip", row.get("ShipToZip"));
			dataMap.put("ShipToCity", row.get("ShipToCity"));
			dataMap.put("ShipToState", row.get("ShipToState"));
			
			responseList.add(dataMap);
		}

	} catch (Exception e) {
		dataMap.put("error", "Error occured");

	}
	
	return responseList;
}

	

}
