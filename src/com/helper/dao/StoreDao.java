package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Store;

/**
 * @author Jsong
 * 
 * t_store���̼ұ������ݳ־ò�ӿ�
 *
 */
public interface StoreDao extends Dao {
	
	//���������̼�
	public ArrayList<Store> finAll();
	
	//����ID���ҵ����̼���Ϣ
	public Store findStoreById(int id);
	
	//����̼�
	public boolean insertStore(Store store);
	
	//����IDɾ���̼�
	public boolean deleteStore(int id);
	
	//�����̼���Ϣ
	public boolean updateStore(Store store);
}
