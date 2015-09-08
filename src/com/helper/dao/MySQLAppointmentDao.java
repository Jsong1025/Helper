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
 * t_appointment��Լ����Ĳ�����
 *
 */
public class MySQLAppointmentDao implements AppointmentDao , Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ��Լ��������Լ���µ�����
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
	 * ����Լ����е�����
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
	 * ȷ��Լ����Ӧ���޸�t_appointment������һ�û����ݣ�������Ӧ�ֶ�����Ϊ��Y��
	 * 
	 * @param appointmentId	Ҫ�޸ĵ�Լ��ID
	 * @param userId		ȷ�ϵ���һ�û�ID
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
	 * ��ѯ����Լ������
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
				//��ѯ�ײ�����
				int mealId = appointments.get(i).getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointments.get(i).setMeal(mealName);

				//��ѯ�û���
				int userId = appointments.get(i).getUserId();
				User user = userDao.findUserById(userId);
				appointments.get(i).setUser(user);

				//�������һ�û�������ѯ��һ�û���
				int otherUserId = appointments.get(i).getOtherUserId();
				if (otherUserId != 0) {
					User otherUser = userDao.findUserById(otherUserId);
					appointments.get(i).setOtherUserName(otherUser);
				}
				
				//��ѯ������Ӧ��Ϣ
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
	 * ����ID����Լ����Ϣ
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



				//��ѯ�ײ�����
				MySQLMealDao mealDao = new MySQLMealDao();
				int mealId = appointment.getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointment.setMeal(mealName);

				//��ѯ�û���
				MySQLUserDao userDao = new MySQLUserDao();
				int userId = appointment.getUserId();
				User user = userDao.findUserById(userId);
				appointment.setUser(user);

				//�������һ�û�������ѯ��һ�û���
				int otherUserId = appointment.getOtherUserId();
				if (otherUserId != 0) {
					User otherUser = userDao.findUserById(otherUserId);
					appointment.setOtherUserName(otherUser);
				}
				
				//��ѯ������Ӧ��Ϣ
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
	 * ������ѯԼ������
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
				//��ѯ�ײ�����
				int mealId = appointments.get(i).getMealId();
				String mealName = mealDao.findMealById(mealId).getName();
				appointments.get(i).setMeal(mealName);

				//��ѯ�û���
				int userId = appointments.get(i).getUserId();
				User user = userDao.findUserById(userId);
				appointments.get(i).setUser(user);

				//�������һ�û�������ѯ��һ�û���
				int otherUserId = appointments.get(i).getOtherUserId();
				if (otherUserId != 0) {
					User otherUser = userDao.findUserById(otherUserId);
					appointments.get(i).setOtherUserName(otherUser);
				}
				
				//��ѯ������Ӧ��Ϣ
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
	 * ���Լ��
	 * 
	 * @param id		��Ҫ��˵�Լ��ID
	 * @param payKey	��˺��������
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
	 * ȡ��Լ�ᣨ��Լ����is_cacel��־����ΪN��
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
	 *	�����û�������Լ�ᣨ����������ң� 
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
				
				//��ѯ������Ӧ��Ϣ
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
	 *	ɾ��Լ�ᣨ����id���ң� 
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
