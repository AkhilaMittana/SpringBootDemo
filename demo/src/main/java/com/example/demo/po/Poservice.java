package com.example.demo.po;

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
	public class Poservice {
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Autowired
		private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

		public Map<String, String> insertDetails(Po port ) {

			
			Map<String, String> data = new HashMap<String, String>();
			int result = 0;
			String sql = "INSERT INTO po (poId,customerId,poDate,poTotal,poShipToAddress,poShipToZip,poShipToCity,poShipToState,poBillToAddress,poBillToCity,poBillToState,poStatus)"
					+ " VALUES (:PoId,:CustomerId,:PoDate,:PoTotal,:PoShipToAddress,:PoShipToZip,:PoShipToCity,:PoShipToState,:PoBillToAddress,:PoBillToCity,:PoBillToState,:PoStatus)";
			try
			{
				System.out.println(port.getCustomerId());
				SqlParameterSource parameters = new MapSqlParameterSource().addValue("PoId", port.getPoId())
						.addValue("CustomerId", port.getCustomerId())
						.addValue("PoDate",port.getPoDate())
						.addValue("PoTotal", port.getPoTotal())
	                    .addValue("PoShipToAddress", port.getPoShipToAddress())
	                    .addValue("PoShipToZip", port.getPoShipToZip())
	                    .addValue("PoShipToCity", port.getPoShipToCity())
	                    .addValue("PoShipToState", port.getPoShipToState())
	                    .addValue("PoBillToAddress", port.getPoBillToAddress())
	                    .addValue("PoBillToCity", port.getPoBillToCity())
	                    .addValue("PoBillToState", port.getPoBillToState())
	                    .addValue("PoStatus", port.getPoStatus());

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
		public Map<String, String> updatePo(Po port) {
			
			Map<String, String> data = new HashMap<String, String>();
			int result = 0;
			String sql = "update item set poStatus=? where customerId=?";
			try {
				result = jdbcTemplate.update(sql,port.getPoStatus(),port.getCustomerId());
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

		

		public List get_Detail(int id) {
			
			Map dataMap = new HashMap();
			List responseList = new ArrayList();
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			String sql = "select poId,customerId,poDate,poTotal,poShipToAddress,poShipToZip,poShipToCity,poShipToState,poBillToAddress,poBillToCity,poBillToState,poStatus from po where poId = ?";
			try {
				dataList = jdbcTemplate.queryForList(sql, id);

				for (Map<String, Object> row : dataList) {
					dataMap.put("poId", row.get("PoId"));
					dataMap.put("customerId", row.get("CustomerId"));
					dataMap.put("poDate",row.get("PoDate"));
					dataMap.put("poTotal", row.get("PoTotal"));
					dataMap.put("poShipToAddress", row.get("PoShipToAddress"));
					dataMap.put("poShipToZip", row.get("PoShipToZip"));
					dataMap.put("poShipToCity", row.get("PoShipToCity"));
					dataMap.put("poShipToState", row.get("PoShipToState"));
					dataMap.put("poBillToAddress", row.get("PoBillToAddress"));
					dataMap.put("poBillToCity", row.get("PoBillToCity"));
					dataMap.put("poBillToState", row.get("PoBillToState"));
					dataMap.put("poStatus", row.get("PoStatus"));
					responseList.add(dataList);
				}

			} catch (Exception e) {
				dataMap.put("error", "Error occured");
			}
			
			return responseList;
		}

		public List getAllPoItems1() {
			
			Map dataMap = null;
			List responseList = new ArrayList();
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			String sql = "select * from item";

			try {
				dataList = jdbcTemplate.queryForList(sql);

				for (Map<String, Object> row : dataList) {
					dataMap = new HashMap();
					dataMap.put("poId", row.get("PoId"));
					dataMap.put("customerId", row.get("CustomerId"));
					dataMap.put("poDate",row.get("PoDate"));
					dataMap.put("poTotal", row.get("PoTotal"));
					dataMap.put("poShipToAddress", row.get("PoShipToAddress"));
					dataMap.put("poShipToZip", row.get("PoShipToZip"));
					dataMap.put("poShipToCity", row.get("PoShipToCity"));
					dataMap.put("poShipToState", row.get("PoShipToState"));
					dataMap.put("poBillToAddress", row.get("PoBillToAddress"));
					dataMap.put("poBillToCity", row.get("PoBillToCity"));
					dataMap.put("poBillToState", row.get("PoBillToState"));
					dataMap.put("poStatus", row.get("PoStatus"));
					responseList.add(dataMap);
				}

			} catch (Exception e) {
				dataMap.put("error", "Error occured");

			}
			
			return responseList;
		}
		public List getAll_d() {
			Map dataMap = null;
			List responseList = new ArrayList();
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			String sql = "select * from item";

			try {
				dataList = jdbcTemplate.queryForList(sql);

				for (Map<String, Object> row : dataList) {
					dataMap = new HashMap();
					dataMap.put("poId", row.get("PoId"));
					dataMap.put("customerId", row.get("CustomerId"));
					dataMap.put("poDate",row.get("PoDate"));
					dataMap.put("poTotal", row.get("PoTotal"));
					dataMap.put("poShipToAddress", row.get("PoShipToAddress"));
					dataMap.put("poShipToZip", row.get("PoShipToZip"));
					dataMap.put("poShipToCity", row.get("PoShipToCity"));
					dataMap.put("poShipToState", row.get("PoShipToState"));
					dataMap.put("poBillToAddress", row.get("PoBillToAddress"));
					dataMap.put("poBillToCity", row.get("PoBillToCity"));
					dataMap.put("poBillToState", row.get("PoBillToState"));
					dataMap.put("poStatus", row.get("PoStatus"));
					responseList.add(dataMap);
				}

			} catch (Exception e) {
				dataMap.put("error", "Error occured");
             }
			
			return responseList;
			
		}

	}


