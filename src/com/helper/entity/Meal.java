package com.helper.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jsong
 *	
 *	套餐实体类
 *
 */
public class Meal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;					//ID
	private String name;        	//套餐名称
	private Date startTime;			//开始时间
	private Date endTime;    		//结束时间
	private int num;				//数量
	private String priferemential;	//优惠条件
	private double price;			//价格
	private int storeId;			//所属商家ID
	private String store;			//所属商家
	
	public Meal() {
	}
	

	/* 
	 * 有参构造方法
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