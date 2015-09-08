package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Role;

/**
 * @author Jsong
 * 
 * t_role表（角色表）的数据持久层接口
 *
 */
public interface RoleDao extends Dao {
	
	//查找所有角色信息
	public ArrayList<Role> findAll();
	
	//根据ID查找单个角色
	public Role findRoleById(int id);
	
	//添加角色
	public boolean insertRole(Role role);
	
	//根据ID删除角色
	public boolean deleteRole(int id);
	
	//更新角色信息
	public boolean updateRole(Role role);

}
