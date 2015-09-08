package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Message;

/**
 * @author Jsong
 * 
 * t_messa表（消息表）的数据持久层接口
 *
 */
public interface MessageDao extends Dao {
	
	//查找用户所有消息
	public ArrayList<Message> findAllByEmail(String email);
	
	
	//根据ID查找指定消息
	public Message findMessageById(int id);
	
	 //根据约会ID查找指定消息
	public ArrayList<Message> findMessageByAppointmentId(int AppointmentId);

	 //添加消息
	public boolean insertMessage(Message message);
	
	 //根据ID删除消息
	public boolean deleteMessage(int id);
	
}

