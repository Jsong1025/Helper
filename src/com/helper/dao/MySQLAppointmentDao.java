package com.helper.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.helper.entity.Appointment;
import com.helper.entity.User;
import com.helper.util.JdbcUtil;

/**
 * @author Jsong
 * 
 * t_appointment表（约会表）的操作类
 *
 */
public class MySQLAppointmentDao implements AppointmentDao , Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 向约会表中添加约会新的数据
	 */
	public boolean insertAppointment(Appointment appoint) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_appointment(start_time,user_id,time,gender,substance,description,meal_id) value(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,new java.sql.Date(appoint.getStartTime().getTime()));
			pstmt.setInt(2, appoint.getUserId());
			pstmt.setDate(3,new java.sql.Date(appoint.getTime().getTime()));
			pstmt.setInt(4, appoint.getGender());
			pstmt.setString(5, appoint.getSubstanceToString());
			pstmt.setString(6, appoint.getDescription());
			pstmt.setInt(7, appoint.getMealId());

			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 更新约会表中的数据
	 */
	public boolean updateAppointment(Appointment appoint) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_appointment set start_time=? , user_id=? , time=? , gender=? , substance=? , description=? , meal_id=? where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,new java.sql.Date(appoint.getStartTime().getTime()));
			pstmt.setInt(2, appoint.getUserId());
			pstmt.setDate(3,new java.sql.Date(appoint.getTime().getTime()));
			pstmt.setInt(4, appoint.getGender());
			pstmt.setString(5, appoint.getSubstanceToString());
			pstmt.setString(6, appoint.getDescription());
			pstmt.setInt(7, appoint.getMealId());
			pstmt.setInt(8, appoint.getId());

			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 确认约会响应，修改t_appointment表中另一用户数据，并把响应字段设置为‘Y’
	 * 
	 * @param appointmentId	要修改的约会ID
	 * @param userId		确认的另一用户ID
	 */
	public boolean updateAppointmentOtherUser(int appointmentId,int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "update t_appointment set other_user_id = ? ,response = 'Y' where id = ?";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, appointmentId);
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 查询所有约会数据
	 * */
	public ArrayList<Appointment> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_appointment";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<Appointment> appointments = new ArrayList<Appointment>();
			while (rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setId(Integer.parseInt(rs.getString("id")));
				appointment.setStartTime(rs.getDate("start_time"));
				appointment.setEndTime(rs.getDate("end_time"));
				appointment.setCacel(rs.getString("is_cacel"));
				appointment.setBreak(rs.getString("is_break"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setOtherUserId(rs.getInt("other_user_id"));
				appointment.setPayKey(rs.getString("pay_key"));
				appointment.setTime(rs.getDate("time"));
				appointment.setGender(rs.getInt("gender"));
				appointment.setSubstance(rs.getString("substance"));
				appointment.setDescription(rs.getString("description"));
				appointment.setMealId(rs.getInt("meal_id"));
				appointment.setResponse(rs.getString("response").charAt(0));
				appointment.setExamine(rs.getString("examine").charAt(0));

				appointments.add(appointment);
			}

			MySQLUserDao userDao = new MySQLUserDao();
			MySQLMealDao mealDao = new MySQLMealDao();
			MySQLResponserDao responserDao = new MySQLResponserDao();
			for (int i = 0; i < appointments.size(); i++) {
				//查询套餐名称
				int mealId = appointments.get(i).getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointments.get(i).setMeal(mealName);

				//查询用户名
				int userId = appointments.get(i).getUserId();
				User user = userDao.findUserById(userId);
				appointments.get(i).setUser(user);

				//如果有另一用户名，查询另一用户名
				int otherUserId = appointments.get(i).getOtherUserId();
				if (otherUserId != 0) {
					User otherUser = userDao.findUserById(otherUserId);
					appointments.get(i).setOtherUserName(otherUser);
				}
				
				//查询所有响应信息
				int appointmentId = appointments.get(i).getId();
				appointments.get(i).setResponsers(responserDao.findResponserByApponitment(appointmentId));
			}
			return appointments;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(rs, stmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 根据ID查找约会信息
	 */
	public Appointment findAppointmentById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_appointment where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Appointment appointment = null;
			if (rs.next()) {
				appointment = new Appointment();
				appointment.setId(Integer.parseInt(rs.getString("id")));
				appointment.setStartTime(rs.getDate("start_time"));
				appointment.setEndTime(rs.getDate("end_time"));
				appointment.setCacel(rs.getString("is_cacel"));
				appointment.setBreak(rs.getString("is_break"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setOtherUserId(rs.getInt("other_user_id"));
				appointment.setPayKey(rs.getString("pay_key"));
				appointment.setTime(rs.getDate("time"));
				appointment.setGender(rs.getInt("gender"));
				appointment.setSubstance(rs.getString("substance"));
				appointment.setDescription(rs.getString("description"));
				appointment.setMealId(rs.getInt("meal_id"));



				//查询套餐名称
				MySQLMealDao mealDao = new MySQLMealDao();
				int mealId = appointment.getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointment.setMeal(mealName);

				//查询用户名
				MySQLUserDao userDao = new MySQLUserDao();
				int userId = appointment.getUserId();
				User user = userDao.findUserById(userId);
				appointment.setUser(user);

				//如果有另一用户名，查询另一用户名
				int otherUserId = appointment.getOtherUserId();
				if (otherUserId != 0) {
					User otherUser = userDao.findUserById(otherUserId);
					appointment.setOtherUserName(otherUser);
				}
				
				//查询所有响应信息
				MySQLResponserDao responserDao = new MySQLResponserDao();
				int appointmentId = appointment.getId();
				appointment.setResponsers(responserDao.findResponserByApponitment(appointmentId));

			}
			return appointment;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 条件查询约会数据
	 * */
	public ArrayList<Appointment> searchAppointment(int gender,int minAge,int maxAge,String substance) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			if (substance == null) {
				String sql = "select * from t_appointment,t_user where user_id=t_user.id and gender = ? and age < ? and age > ? ;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gender);
				pstmt.setInt(2, maxAge);
				pstmt.setInt(3, minAge);
				System.out.println("OK");
				
			} else {
				String sql = "select * from t_appointment,t_user where user_id=t_user.id and gender = ? and age < ? and age > ? and substance= ? ;";
				pstmt = conn.prepareStatement(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gender);
				pstmt.setInt(2, maxAge);
				pstmt.setInt(3, minAge);
				pstmt.setString(4, substance);
			}
			
			rs = pstmt.executeQuery();
			ArrayList<Appointment> appointments = new ArrayList<Appointment>();
			while (rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setId(Integer.parseInt(rs.getString("id")));
				appointment.setStartTime(rs.getDate("start_time"));
				appointment.setEndTime(rs.getDate("end_time"));
				appointment.setCacel(rs.getString("is_cacel"));
				appointment.setBreak(rs.getString("is_break"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setOtherUserId(rs.getInt("other_user_id"));
				appointment.setPayKey(rs.getString("pay_key"));
				appointment.setTime(rs.getDate("time"));
				appointment.setGender(rs.getInt("gender"));
				appointment.setSubstance(rs.getString("substance"));
				appointment.setDescription(rs.getString("description"));
				appointment.setMealId(rs.getInt("meal_id"));
				appointment.setResponse(rs.getString("response").charAt(0));
				appointment.setExamine(rs.getString("examine").charAt(0));

				appointments.add(appointment);
			}

			MySQLUserDao userDao = new MySQLUserDao();
			MySQLMealDao mealDao = new MySQLMealDao();
			MySQLResponserDao responserDao = new MySQLResponserDao();
			for (int i = 0; i < appointments.size(); i++) {
				//查询套餐名称
				int mealId = appointments.get(i).getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointments.get(i).setMeal(mealName);

				//查询用户名
				int userId = appointments.get(i).getUserId();
				User user = userDao.findUserById(userId);
				appointments.get(i).setUser(user);

				//如果有另一用户名，查询另一用户名
				int otherUserId = appointments.get(i).getOtherUserId();
				if (otherUserId != 0) {
					User otherUser = userDao.findUserById(otherUserId);
					appointments.get(i).setOtherUserName(otherUser);
				}
				
				//查询所有响应信息
				int appointmentId = appointments.get(i).getId();
				appointments.get(i).setResponsers(responserDao.findResponserByApponitment(appointmentId));
			}
			return appointments;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 审核约会
	 * 
	 * @param id		需要审核的约会ID
	 * @param payKey	审核后的消费码
	 */
	public boolean examineAppointment(int id,String payKey){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_appointment set examine='Y',pay_key=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payKey);
			pstmt.setInt(2, id);

			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 取消约会（将约会中is_cacel标志设置为N）
	 * */
	public boolean cancelAppointment(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_appointment set is_cacel='Y' where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 *	查找用户的所有约会（根据邮箱查找） 
	 */
	public ArrayList<Appointment> findAllByEmail(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_appointment,t_user where (t_appointment.user_id=t_user.id or t_appointment.other_user_id=t_user.id )and email=? ;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			ArrayList<Appointment> appointments = new ArrayList<Appointment>();
			while (rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setId(Integer.parseInt(rs.getString("id")));
				appointment.setStartTime(rs.getDate("start_time"));
				appointment.setEndTime(rs.getDate("end_time"));
				appointment.setCacel(rs.getString("is_cacel"));
				appointment.setBreak(rs.getString("is_break"));
				appointment.setUserId(rs.getInt("user_id"));
				appointment.setOtherUserId(rs.getInt("other_user_id"));
				appointment.setPayKey(rs.getString("pay_key"));
				appointment.setTime(rs.getDate("time"));
				appointment.setGender(rs.getInt("gender"));
				appointment.setSubstance(rs.getString("substance"));
				appointment.setDescription(rs.getString("description"));
				appointment.setMealId(rs.getInt("meal_id"));
				
				//查询所有响应信息
				MySQLResponserDao responserDao = new MySQLResponserDao();
				int appointmentId = appointment.getId();
				appointment.setResponsers(responserDao.findResponserByApponitment(appointmentId));

				appointments.add(appointment);
			}
			return appointments;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 *	删除约会（根据id查找） 
	 */
	public boolean deleteAppointment(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_appointment where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
