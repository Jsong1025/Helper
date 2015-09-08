package com.helper.dao;

import java.util.List;

import com.helper.entity.User;

/**
 * @author Jsong
 * 
 * 用户表的Dao接口
 *
 */
public interface UserDao extends Dao {

	//查找所有用户
	public List<User> findAllUser();

	//通过用户名查找密码
	public User findUserById(int id) ;
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);

	//添加用户
	public boolean insertUser(User user);

	//更新用户
	public boolean updateUser(User user);

	//删除用户
	public User deleteUser(int id) ;

}
