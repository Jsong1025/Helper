package com.helper.dao;

import java.util.ArrayList;
import java.util.Date;

import com.helper.entity.Responser;

/**
 * @author Jsong
 * 
 * t_responser表（响应表）的数据持久层接口
 *
 */
public interface ResponserDao extends Dao {
	
	//添加响应
	public boolean insertResponser(int appointmentID,int userId,Date time);
	
	 //根据ID查询指定响应
	public Responser findResponserById(int id);
	
	//查询约会的所有响应信息
	public ArrayList<Responser> findResponserByApponitment(int appointmentId);
	
	//查询指定用户是否响应了指定约会
	public ArrayList<Responser> findResponserByApponitmentUser(int appointmentId,int userId);
	
	//根据约会ID删除响应信息
	public boolean deleteResponserByAppointmentId(int appointmentId);

}

