package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JdbcUtil;
import vo.Role;

/**
 * @author Jsong
 * 
 * 此类为数据库helper中t_role表（角色表）的操作类
 *
 */
public class RoleDao {
	
	/**
	 * 查找所有角色信息
	 */
	public ArrayList<Role> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_role";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<Role> roles = new ArrayList<Role>();
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setPermision(rs.getInt("permision"));
				
				roles.add(role);
			}
			return roles;
			
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
	 * 根据ID查找单个角色
	 * */
	public Role findRoleById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_role where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setPermision(rs.getInt("permision"));
				
				return role;
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
	 * 添加角色
	 */
	public boolean insertRole(Role role) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_role(name,permision) value (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role.getName());
			pstmt.setInt(2, role.getPermision());
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
	 * 根据ID删除角色
	 */
	public boolean deleteRole(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_role where id=?";
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
	
	/**
	 * 更新角色信息
	 */
	public boolean updateRole(Role role) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_role set name=?,permision=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role.getName());
			pstmt.setInt(2, role.getPermision());
			pstmt.setInt(3, role.getId());
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
