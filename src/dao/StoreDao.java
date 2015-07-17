package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Store;

public class StoreDao {
	
	/*
	 * 查找所有商家
	 * */
	public ArrayList<Store> finAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_store";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<Store> stores = new ArrayList<Store>();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setAddress(rs.getString("address"));
				store.setTel(rs.getString("tel"));
				store.setPicture(rs.getString("picture"));
				store.setType(rs.getString("type"));
				store.setIntroduce(rs.getString("introduce"));
				
				stores.add(store);
			}
			return stores;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(rs, stmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
