package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Meal;

public class MealDao {
	
	/*
	 * 查找所有套餐
	 * */
	public ArrayList<Meal> finAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_meal";
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
	
	
}
