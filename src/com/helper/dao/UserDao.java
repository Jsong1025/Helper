package com.helper.dao;

import java.util.List;

import com.helper.entity.User;

/**
 * @author Jsong
 * 
 * �û����Dao�ӿ�
 *
 */
public interface UserDao extends Dao {

	//���������û�
	public List<User> findAllUser();

	//ͨ���û�����������
	public User findUserById(int id) ;
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);

	//����û�
	public boolean insertUser(User user);

	//�����û�
	public boolean updateUser(User user);

	//ɾ���û�
	public User deleteUser(int id) ;

}
