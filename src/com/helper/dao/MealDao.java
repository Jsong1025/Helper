package com.helper.dao;

import java.util.ArrayList;

import com.helper.entity.Meal;

/**
 * @author Jsong
 * 
 * t_meal������ݳ־ò�ӿ�
 *
 */
public interface MealDao extends Dao {
	
	//���������ײ�
	public ArrayList<Meal> finAll();
	
	//����ID�����ײ�
	public Meal findMealById(int id);
	
	//����ײ�
	public boolean insertMeal(Meal meal) ;
	
	//����IDɾ���ײ�
	public boolean deleteRole(int id);
	
	//�����ײ���Ϣ
	public boolean updateMeal(Meal meal);
	
}
