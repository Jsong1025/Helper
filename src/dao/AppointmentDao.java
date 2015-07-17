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
			String sql = "insert into t_appointment(start_time,end_time,user_id,other_user_id,pay_key,time,gender,substance,description,meal_id) value(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,new java.sql.Date(appoint.getStartTime().getTime()));
			pstmt.setDate(2,new java.sql.Date(appoint.getEndTime().getTime()));
			pstmt.setInt(3, appoint.getUserId());
			pstmt.setInt(4, appoint.getOtherUserId());
			pstmt.setString(5, appoint.getPayKey());
			pstmt.setDate(6,new java.sql.Date(appoint.getTime().getTime()));
			pstmt.setInt(7, appoint.getGender());
			pstmt.setString(8, appoint.getSubstanceToString());
			pstmt.setString(9, appoint.getDescription());
			pstmt.setInt(10, appoint.getMealId());
			
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
