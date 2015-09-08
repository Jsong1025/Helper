package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Appointment;

/**
 * @author Jsong
 * 
 * t_appointment表（约会表）的数据持久层接口
 *
 */
public interface AppointmentDao extends Dao {

	//向约会表中添加约会新的数据
	public boolean insertAppointment(Appointment appoint);
	
	//更新约会表中的数据
	public boolean updateAppointment(Appointment appoint) ;

	//确认约会响应，修改t_appointment表中另一用户数据，并把响应字段设置为‘Y’
	public boolean updateAppointmentOtherUser(int appointmentId,int userId);
	
	
	//查询所有约会数据
	public ArrayList<Appointment> findAll() ;
	
	
	//根据ID查找约会信息
	public Appointment findAppointmentById(int id);
	
	//条件查询约会数据
	public ArrayList<Appointment> searchAppointment(int gender,int minAge,int maxAge,String substance);
	
	//审核约会
	public boolean examineAppointment(int id,String payKey);
	
	//取消约会（将约会中is_cacel标志设置为N）
	public boolean cancelAppointment(int id);


	//查找用户的所有约会（根据邮箱查找） 
	public ArrayList<Appointment> findAllByEmail(String email);
	
	//删除约会 
	public boolean deleteAppointment(int id);

}
