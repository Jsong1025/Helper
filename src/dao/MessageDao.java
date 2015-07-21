package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Message;

public class MessageDao {
	
	/*
	 * 查找用户所有消息
	 */
	public ArrayList<Message> findAllByEmail(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_message , t_user where t_message.user=t_user.id and t_user.email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			ArrayList<Message> messages = new ArrayList<Message>();
			while (rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("t_message.id"));
				message.setUser(rs.getInt("t_message.user"));
				message.setMessage(rs.getString("t_message.message"));
				message.setAppointmentId(rs.getInt("t_message.appointment_id"));
				
				messages.add(message);
			}
			return messages;
			
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
	 * 添加消息
	 */
	public boolean insertMessage(Message message) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_message(user,message,appointment_id) value (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getUser());
			pstmt.setString(2, message.getMessage());
			pstmt.setInt(3, message.getAppointmentId());
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
	 * 根据ID删除消息
	 */
	public boolean deleteMessage(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_message where id=?";
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
	
}

