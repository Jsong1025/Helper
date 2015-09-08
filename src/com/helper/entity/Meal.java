package com.helper.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jsong
 *	
 *	�ײ�ʵ����
 *
 */
public class Meal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;					//ID
	private String name;        	//�ײ�����
	private Date startTime;			//��ʼʱ��
	private Date endTime;    		//����ʱ��
	private int num;				//����
	private String priferemential;	//�Ż�����
	private double price;			//�۸�
	private int storeId;			//�����̼�ID
	private String store;			//�����̼�
	
	public Meal() {
	}
	

	/* 
	 * �вι��췽��
	 * */
	public Meal(int id, String name, Date startTime, Date endTime, int num,
			String priferemential, double price, int storeId,String store) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.num = num;
		this.priferemential = priferemential;
		this.price = price;
		this.storeId = storeId;
		this.store = store;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getPriferemential() {
		return priferemential;
	}


	public void setPriferemential(String priferemential) {
		this.priferemential = priferemential;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public String getStore() {
		return store;
	}


	public void setStore(String store) {
		this.store = store;
	}


	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", num=" + num + ", priferemential="
				+ priferemential + ", price=" + price + ", storeId=" + storeId
				+ ", store=" + store + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		if (id != other.id)
			return false;
		return true;
	}

}