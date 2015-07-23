package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Meal;

/**
 * @author Jsong
 * 
 * 此类为数据库helper中t_meal表（套餐表）的操作类
 *
 */
public class MealDao {
	
	/**
	 * 查找所有套餐
	 * */
	public ArrayList<Meal> finAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_meal,t_store where store_id=t_store.id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<Meal> meals = new ArrayList<Meal>();
			while (rs.next()) {
				Meal meal = new Meal();
				meal.setId(rs.getInt("id"));
				meal.setName(rs.getString("name"));
				meal.setStartTime(rs.getDate("start_time"));
				meal.setEndTime(rs.getDate("end_time"));
				meal.setNum(rs.getInt("num"));
				meal.setPriferemential(rs.getString("priferemential"));
				meal.setPrice(rs.getDouble("price"));
				meal.setStoreId(rs.getInt("store_id"));
				meal.setStore(rs.getString("t_store.name"));
				
				meals.add(meal);
			}
			return meals;
			
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
	
	/**
	 * 根据ID查找套餐
	 * */
	public Meal findMealById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_meal,t_store where store_id=t_store.id and t_meal.id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Meal meal = new Meal();
				meal.setId(rs.getInt("id"));
				meal.setName(rs.getString("name"));
				meal.setStartTime(rs.getDate("start_time"));
				meal.setEndTime(rs.getDate("end_time"));
				meal.setNum(rs.getInt("num"));
				meal.setPriferemential(rs.getString("priferemential"));
				meal.setPrice(rs.getDouble("price"));
				meal.setStoreId(rs.getInt("store_id"));
				meal.setStore(rs.getString("t_store.name"));
				
				return meal;
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
	
	/**
	 * 添加套餐
	 */
	public boolean insertMeal(Meal meal) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_meal(name,start_time,end_time,num,price,priferemential,store_id) value (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, meal.getName());
			pstmt.setDate(2, new java.sql.Date(meal.getStartTime().getTime()));
			pstmt.setDate(3, new java.sql.Date(meal.getEndTime().getTime()));
			pstmt.setInt(4, meal.getNum());
			pstmt.setDouble(5, meal.getPrice());
			pstmt.setString(6, meal.getPriferemential());
			pstmt.setInt(7, meal.getStoreId());
			
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
	
	/**
	 * 根据ID删除套餐
	 */
	public boolean deleteRole(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_meal where id=?";
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
	
	/**
	 * 更新套餐信息
	 */
	public boolean updateMeal(Meal meal) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_meal set name=? , start_time=? , end_time=? , num=? , price=? , priferemential=? , store_id=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, meal.getName());
			pstmt.setDate(2, new java.sql.Date(meal.getStartTime().getTime()));
			pstmt.setDate(3, new java.sql.Date(meal.getEndTime().getTime()));
			pstmt.setInt(4, meal.getNum());
			pstmt.setDouble(5, meal.getPrice());
			pstmt.setString(6, meal.getPriferemential());
			pstmt.setInt(7, meal.getStoreId());
			pstmt.setInt(8, meal.getId());
			
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
