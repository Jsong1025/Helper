package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Store;
import vo.User;

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
	
	/*
	 * 根据ID查找单个商家信息
	 * */
	public Store findStoreById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_store where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setAddress(rs.getString("address"));
				store.setTel(rs.getString("tel"));
				store.setPicture(rs.getString("picture"));
				store.setType(rs.getString("type"));
				store.setIntroduce(rs.getString("introduce"));
				
				return store;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/*
	 * 添加商家
	 */
	public boolean insertStore(Store store) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_store(name,address,tel,type,picture,introduce) value (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setString(2, store.getAddress());
			pstmt.setString(3, store.getTel());
			pstmt.setString(4, store.getType());
			pstmt.setString(5, store.getPicture());
			pstmt.setString(6, store.getIntroduce());
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	/*
	 * 根据ID删除商家
	 */
	public boolean deleteStore(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_store where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	/*
	 * 更新商家信息
	 */
	public boolean updateStore(Store store) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_store set name=?,address=?,tel=?,type=?,picture=?,introduce=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setString(2, store.getAddress());
			pstmt.setString(3, store.getTel());
			pstmt.setString(4, store.getType());
			pstmt.setString(5, store.getPicture());
			pstmt.setString(6, store.getIntroduce());
			pstmt.setInt(7, store.getId());
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
