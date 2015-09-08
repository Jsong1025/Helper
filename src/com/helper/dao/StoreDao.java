package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Store;

/**
 * @author Jsong
 * 
 * t_store表（商家表）的数据持久层接口
 *
 */
public interface StoreDao extends Dao {
	
	//查找所有商家
	public ArrayList<Store> finAll();
	
	//根据ID查找单个商家信息
	public Store findStoreById(int id);
	
	//添加商家
	public boolean insertStore(Store store);
	
	//根据ID删除商家
	public boolean deleteStore(int id);
	
	//更新商家信息
	public boolean updateStore(Store store);
}
