package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Appointment;

public class AppointmentDao {

	/**
	 * 添加约会
	 * */
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
	 * 查询所有约会
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

				appointments.add(appointment);
			}

			UserDao userDao = new UserDao();
			MealDao mealDao = new MealDao();
			for (int i = 0; i < appointments.size(); i++) {
				//查询套餐名称
				int mealId = appointments.get(i).getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointments.get(i).setMeal(mealName);

				//查询用户名
				int userId = appointments.get(i).getUserId();
				String userName = userDao.findUserById(userId).getName();
				appointments.get(i).setUserName(userName);

				//如果有另一用户名，查询另一用户名
				int otherUserId = appointments.get(i).getOtherUserId();
				if (otherUserId != 0) {
					String otherUserName = userDao.findUserById(otherUserId).getName();
					appointments.get(i).setOtherUserName(otherUserName);
				}
			}
			return appointments;

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
			
			if (rs.next()) {
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


				UserDao userDao = new UserDao();
				MealDao mealDao = new MealDao();

				//查询套餐名称
				int mealId = appointment.getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointment.setMeal(mealName);

				//查询用户名
				int userId = appointment.getUserId();
				String userName = userDao.findUserById(userId).getName();
				appointment.setUserName(userName);

				//如果有另一用户名，查询另一用户名
				int otherUserId = appointment.getOtherUserId();
				if (otherUserId != 0) {
					String otherUserName = userDao.findUserById(otherUserId).getName();
					appointment.setOtherUserName(otherUserName);
				}

				return appointment;
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
	 *	查找用户的所有约会 
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

				appointments.add(appointment);
			}
			return appointments;

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

	public static void main(String[] args) {
		AppointmentDao dao = new AppointmentDao();
		ArrayList<Appointment> appointments = dao.findAll();
		System.out.println(appointments);

		Appointment newApp = appointments.get(0);
		dao.insertAppointment(newApp);

		appointments = dao.findAll();
		System.out.println(appointments);
	}

}
