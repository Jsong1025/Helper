package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Message;

/**
 * @author Jsong
 * 
 * t_messa����Ϣ�������ݳ־ò�ӿ�
 *
 */
public interface MessageDao extends Dao {
	
	//�����û�������Ϣ
	public ArrayList<Message> findAllByEmail(String email);
	
	
	//����ID����ָ����Ϣ
	public Message findMessageById(int id);
	
	 //����Լ��ID����ָ����Ϣ
	public ArrayList<Message> findMessageByAppointmentId(int AppointmentId);

	 //�����Ϣ
	public boolean insertMessage(Message message);
	
	 //����IDɾ����Ϣ
	public boolean deleteMessage(int id);
	
}

