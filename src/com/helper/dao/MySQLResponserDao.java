package com.helper.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.helper.entity.Responser;
import com.helper.util.JdbcUtil;

/**
 * @author Jsong
 * 
 * t_responser表（响应表）的操作类
 *
 */
public class MySQLResponserDao implements ResponserDao , Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 添加响应
	 * */
	public boolean insertResponser(int appointmentID,int userId,Date time) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_responser(appointment_id,response_user_id,time) value(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, appointmentID);
			pstmt.setInt(2, userId);
			pstmt.setDate(3,new java.sql.Date(time.getTime()));

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
	 * 根据ID查询指定响应
	 */
	public Responser findResponserById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_responser where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			MySQLUserDao dao = new MySQLUserDao();
			Responser  responser = new Responser();
			if (rs.next()) {
				responser.setId(rs.getInt("id"));
				responser.setAppointmentId(rs.getInt("appointment_id"));
				responser.setTime(rs.getDate("time"));
				responser.setResponserUser(dao.findUserById(rs.getInt("response_user_id")));
			} 
			return responser;

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
	 * 查询约会的所有响应信息
	 */
	public ArrayList<Responser> findResponserByApponitment(int appointmentId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_responser where appointment_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, appointmentId);
			rs = pstmt.executeQuery();
			
			ArrayList<Responser> responsers = new ArrayList<Responser>();
			MySQLUserDao dao = new MySQLUserDao();
			if (rs.next()) {
				Responser  responser = new Responser();
				responser.setId(rs.getInt("id"));
				responser.setAppointmentId(rs.getInt("appointment_id"));
				responser.setTime(rs.getDate("time"));
				responser.setResponserUser(dao.findUserById(rs.getInt("response_user_id")));
				responsers.add(responser);
			} 
			return responsers;

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
	 * 查询指定用户是否响应了指定约会
	 */
	public ArrayList<Responser> findResponserByApponitmentUser(int appointmentId,int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_responser where response_user_id = ? and appointment_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userId);
			pstmt.setInt(2, appointmentId);
			rs = pstmt.executeQuery();
			
			ArrayList<Responser> responsers = new ArrayList<Responser>();
			MySQLUserDao dao = new MySQLUserDao();
			if (rs.next()) {
				Responser  responser = new Responser();
				responser.setId(rs.getInt("id"));
				responser.setAppointmentId(rs.getInt("appointment_id"));
				responser.setTime(rs.getDate("time"));
				responser.setResponserUser(dao.findUserById(rs.getInt("response_user_id")));
				responsers.add(responser);
			} 
			return responsers;

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
	 * 根据约会ID删除响应信息
	 */
	public boolean deleteResponserByAppointmentId(int appointmentId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_responser where appointment_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, appointmentId);
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

