package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Appointment;

/**
 * @author Jsong
 * 
 * t_appointment��Լ��������ݳ־ò�ӿ�
 *
 */
public interface AppointmentDao extends Dao {

	//��Լ��������Լ���µ�����
	public boolean insertAppointment(Appointment appoint);
	
	//����Լ����е�����
	public boolean updateAppointment(Appointment appoint) ;

	//ȷ��Լ����Ӧ���޸�t_appointment������һ�û����ݣ�������Ӧ�ֶ�����Ϊ��Y��
	public boolean updateAppointmentOtherUser(int appointmentId,int userId);
	
	
	//��ѯ����Լ������
	public ArrayList<Appointment> findAll() ;
	
	
	//����ID����Լ����Ϣ
	public Appointment findAppointmentById(int id);
	
	//������ѯԼ������
	public ArrayList<Appointment> searchAppointment(int gender,int minAge,int maxAge,String substance);
	
	//���Լ��
	public boolean examineAppointment(int id,String payKey);
	
	//ȡ��Լ�ᣨ��Լ����is_cacel��־����ΪN��
	public boolean cancelAppointment(int id);


	//�����û�������Լ�ᣨ����������ң� 
	public ArrayList<Appointment> findAllByEmail(String email);
	
	//ɾ��Լ�� 
	public boolean deleteAppointment(int id);

}
