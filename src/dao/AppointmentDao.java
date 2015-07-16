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
	 * 查询约会
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
		
	}
	
	
}
