package com.helper.dao;

import java.util.ArrayList;
import java.util.Date;

import com.helper.entity.Responser;

/**
 * @author Jsong
 * 
 * t_responser����Ӧ�������ݳ־ò�ӿ�
 *
 */
public interface ResponserDao extends Dao {
	
	//�����Ӧ
	public boolean insertResponser(int appointmentID,int userId,Date time);
	
	 //����ID��ѯָ����Ӧ
	public Responser findResponserById(int id);
	
	//��ѯԼ���������Ӧ��Ϣ
	public ArrayList<Responser> findResponserByApponitment(int appointmentId);
	
	//��ѯָ���û��Ƿ���Ӧ��ָ��Լ��
	public ArrayList<Responser> findResponserByApponitmentUser(int appointmentId,int userId);
	
	//����Լ��IDɾ����Ӧ��Ϣ
	public boolean deleteResponserByAppointmentId(int appointmentId);

}

