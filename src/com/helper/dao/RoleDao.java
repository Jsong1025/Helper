package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Role;

/**
 * @author Jsong
 * 
 * t_role����ɫ�������ݳ־ò�ӿ�
 *
 */
public interface RoleDao extends Dao {
	
	//�������н�ɫ��Ϣ
	public ArrayList<Role> findAll();
	
	//����ID���ҵ�����ɫ
	public Role findRoleById(int id);
	
	//��ӽ�ɫ
	public boolean insertRole(Role role);
	
	//����IDɾ����ɫ
	public boolean deleteRole(int id);
	
	//���½�ɫ��Ϣ
	public boolean updateRole(Role role);

}
