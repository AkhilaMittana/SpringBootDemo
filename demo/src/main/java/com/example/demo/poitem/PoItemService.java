package com.example.demo.poitem;

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
public class PoItemService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String,String>poItem_i(PoItem poitem) {

		
		Map<String, String> data = new HashMap<String,String>();
		int result = 0;
		String sql = "INSERT INTO po_item (poId,quantity,price,discount) VALUES (:PoId,:Quantity,:Price,:Discount)";
		try
		{
			SqlParameterSource parameters = new MapSqlParameterSource().addValue("PoId", poitem.getPoId())
					.addValue("Quantity", poitem.getQuantity())
					.addValue("Price",poitem.getPrice())
					.addValue("Discount", poitem.getDiscount());
			//System.out.println(parameters);
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
	public Map poItem_u(PoItem poitem) {
		Map<String, String> data = new HashMap<String, String>();
		int result = 0;
		String sql = "update po_item set price=?where quantity=?";
		try {
			result = jdbcTemplate.update(sql,poitem.getPrice(),poitem.getQuantity());
			if (result > 0)
				data.put("success", "updated successfully");
			else
				data.put("failed", "updation failed");
		} catch (Exception e) {
			data.put("error", "Error occured, please try again!");
	e.printStackTrace();
		}
		
		return data;
	}

	

	public List getPoItem(int id) {
		
		Map dataMap = new HashMap();
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select poid,quantity,price,discount from po_item where poid = ?";
		try {
			dataList = jdbcTemplate.queryForList(sql, id);

			for (Map<String, Object> row : dataList) {
				dataMap.put("poid", row.get("poid"));
				dataMap.put("quantity", row.get("quantity"));
				dataMap.put("price", row.get("price"));
				dataMap.put("discount", row.get("discount"));
				responseList.add(dataList);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");
		}
		
		return responseList;
	}

	public List getAll1() {
		
		Map dataMap = null;
		List responseList = new ArrayList();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String sql = "select * from po_item";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("id", row.get("id"));
				dataMap.put("quantity", row.get("quantity"));
				dataMap.put("price", row.get("price"));
				dataMap.put("discount", row.get("discount"));
				responseList.add(dataMap);
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
		String sql = "select * from po_item";

		try {
			dataList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> row : dataList) {
				dataMap = new HashMap();
				dataMap.put("poid", row.get("poid"));
				dataMap.put("quantity", row.get("quantity"));
				dataMap.put("price", row.get("price"));
				dataMap.put("discount", row.get("discount"));
				responseList.add(dataMap);
			}

		} catch (Exception e) {
			dataMap.put("error", "Error occured");

		}
		
		return responseList;
	}
	






	
	
}
	

