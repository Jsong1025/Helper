package com.helper.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.helper.entity.User;
import com.helper.util.JdbcUtil;

/**
 * @author Jsong
 * 
 * MySQL数据库实现的Dao接口
 * 此类为数据库helper中t_user表（用户表）的操作类
 *
 */
public class MySQLUserDao implements UserDao ,Serializable {

	private static final long serialVersionUID = 1L;

	public MySQLUserDao() {
	}
	
	/**
	 * 查找所有用户
	 */
	public List<User> findAllUser() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT * FROM t_user ,t_role WHERE role=t_role.id;";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if (rs.getString("sex") != null) {
					user.setSex(rs.getString("sex").charAt(0));
				}
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
			
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if (rs.getString("sex") != null) {
					user.setSex(rs.getString("sex").charAt(0));
				}
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setQQ(rs.getString("QQ"));
				user.setEmail(rs.getString("email"));
				user.setLocation(rs.getString("location"));
				user.setDescription(rs.getString("description"));
				user.setRoleId(rs.getInt("t_role.id"));
				user.setRole(rs.getString("t_role.name"));
				user.setPicture(rs.getString("picture"));
			}
			return user;
			
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

	public User findUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT * FROM t_user ,t_role WHERE role=t_role.id and t_user.username=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if (rs.getString("sex") != null) {
					user.setSex(rs.getString("sex").charAt(0));
				}
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setQQ(rs.getString("QQ"));
				user.setEmail(rs.getString("email"));
				user.setLocation(rs.getString("location"));
				user.setDescription(rs.getString("description"));
				user.setRoleId(rs.getInt("t_role.id"));
				user.setRole(rs.getString("t_role.name"));
				user.setPicture(rs.getString("picture"));
			}
			return user;
			
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
	
	public User findUserByEmail(String email) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT * FROM t_user ,t_role WHERE role=t_role.id and t_user.email=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				if (rs.getString("sex") != null) {
					user.setSex(rs.getString("sex").charAt(0));
				}
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
			throw new RuntimeException(e);
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
	 * 根据ID删除用户
	 */
	private boolean delete(int id) {
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
			throw new RuntimeException(e);
		} finally {
			try {
				JdbcUtil.close(null, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}



	public User deleteUser(int id) {
		User user = findUserById(id);
		if (delete(id)) {
			return user;
		}
		else {
			return null;
		}
	}

}
