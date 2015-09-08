package com.helper.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helper.entity.Message;
import com.helper.util.JdbcUtil;

/**
 * @author Jsong
 * 
 * t_messa����Ϣ���Ĳ�����
 *
 */
public class MySQLMessageDao implements MessageDao , Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * �����û�������Ϣ
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
				message.setOtherUser(rs.getInt("t_message.other_user"));
				
				messages.add(message);
			}
			return messages;
			
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
	 * ����ID����ָ����Ϣ
	 */
	public Message findMessageById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_message where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			Message message = null;
			while (rs.next()) {
				message = new Message();
				message.setId(rs.getInt("id"));
				message.setUser(rs.getInt("user"));
				message.setMessage(rs.getString("message"));
				message.setAppointmentId(rs.getInt("appointment_id"));
				message.setOtherUser(rs.getInt("other_user"));
				
			}
			return message;
			
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
	 * ����Լ��ID����ָ����Ϣ
	 */
	public ArrayList<Message> findMessageByAppointmentId(int AppointmentId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_message where appointment_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, AppointmentId);
			rs = pstmt.executeQuery();
			
			ArrayList<Message> messages = new ArrayList<Message>();
			while (rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setUser(rs.getInt("user"));
				message.setMessage(rs.getString("message"));
				message.setAppointmentId(rs.getInt("appointment_id"));
				message.setOtherUser(rs.getInt("other_user"));
				messages.add(message);
			}
			return messages;
			
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
	 * �����Ϣ
	 */
	public boolean insertMessage(Message message) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_message(user,message,appointment_id,other_user) value (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getUser());
			pstmt.setString(2, message.getMessage());
			pstmt.setInt(3, message.getAppointmentId());
			pstmt.setInt(4, message.getOtherUser());
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
	 * ����IDɾ����Ϣ
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

