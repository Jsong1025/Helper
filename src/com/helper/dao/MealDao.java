package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Meal;

/**
 * @author Jsong
 * 
 * t_meal表的数据持久层接口
 *
 */
public interface MealDao extends Dao {
	
	//查找所有套餐
	public ArrayList<Meal> finAll();
	
	//根据ID查找套餐
	public Meal findMealById(int id);
	
	//添加套餐
	public boolean insertMeal(Meal meal) ;
	
	//根据ID删除套餐
	public boolean deleteRole(int id);
	
	//更新套餐信息
	public boolean updateMeal(Meal meal);
	
}
