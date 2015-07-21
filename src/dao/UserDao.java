package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.User;

public class UserDao {

	public UserDao() {
	}
	
	/*
	 * 查找所有用户
	 */
	public ArrayList<User> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT * FROM t_user ,t_role WHERE role=t_role.id;";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<User> users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setQQ(rs.getString("QQ"));
				user.setEmail(rs.getString("email"));
				user.setLocation(rs.getString("location"));
				user.setDescription(rs.getString("description"));
				user.setRoleId(rs.getInt("t_role.id"));
				user.setRole(rs.getString("t_role.name"));
				user.setPicture(rs.getString("picture"));
				
				users.add(user);
			}
			return users;
			
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
	 * 通过用户名查找密码
	 */
	public User findPasswordByUserName(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select username,password from t_user where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				return user;
			}else {
				return null;
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
	 * 添加用户
	 * */
	public boolean insertUser(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_user(email,password) value (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
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
	
	public boolean insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_user(username,password,email,name,sex,age,tel,QQ,location,description,role) value (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, Character.toString(user.getSex()));
			pstmt.setInt(6, user.getAge());
			pstmt.setString(7, user.getTel());
			pstmt.setString(8, user.getQQ());
			pstmt.setString(9, user.getLocation());
			pstmt.setString(10, user.getDescription());
			pstmt.setInt(11, user.getRoleId());
			
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
	 *  根据邮箱查询权限
	 */
	public int findPermision(String email){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select permision from t_user,t_role where email=? and t_user.role=t_role.id;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("permision");
			}
			else {
				return 0;
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
		return 0;
	}

	/*
	 * 根据email查询用户所有信息
	 * */
	public User findInfoByEmail(String email){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_user where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setTel(rs.getString("tel"));
				user.setQQ(rs.getString("QQ"));
				user.setEmail(rs.getString("email"));
				user.setLocation(rs.getString("location"));
				user.setDescription(rs.getString("description"));
				user.setPicture(rs.getString("picture"));
				return user;
			}else {
				return null;
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
	 * 根据ID查找指定用户
	 */
	public User findUserById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT * FROM t_user ,t_role WHERE role=t_role.id and t_user.id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setQQ(rs.getString("QQ"));
				user.setEmail(rs.getString("email"));
				user.setLocation(rs.getString("location"));
				user.setDescription(rs.getString("description"));
				user.setRoleId(rs.getInt("t_role.id"));
				user.setRole(rs.getString("t_role.name"));
				user.setPicture(rs.getString("picture"));
				return user;
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
	 * 更新用户所有信息,通过ID查询
	 * */
	public boolean updateUser(User user){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_user set username=?,password=?,name=?,age=?,sex=?,tel=?,QQ=?,location=?,description=?, role=? where id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getAge());
			pstmt.setString(5, Character.toString(user.getSex()));
			pstmt.setString(6, user.getTel());
			pstmt.setString(7, user.getQQ());
			pstmt.setString(8, user.getLocation());
			pstmt.setString(9, user.getDescription());
			pstmt.setInt(10, user.getRoleId());
			pstmt.setInt(11, user.getId());

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
	 * 更新用户所有信息,通过邮箱查询
	 */
	public boolean updateInfoByEmail(User user){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_user set username=?,password=?,name=?,age=?,sex=?,tel=?,QQ=?,location=?,description=? where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getAge());
			pstmt.setString(5, Character.toString(user.getSex()));
			pstmt.setString(6, user.getTel());
			pstmt.setString(7, user.getQQ());
			pstmt.setString(8, user.getLocation());
			pstmt.setString(9, user.getDescription());
			pstmt.setString(10, user.getEmail());

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
	 * 根据ID删除用户
	 */
	public boolean deleteUser(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_user where id=?";
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

	public static void main(String[] args) {
	}

}
