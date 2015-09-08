package com.helper.entity;

import java.io.Serializable;

/**
 * @author Jsong
 *	
 *	�̼�ʵ����
 *
 */
public class Store implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;				//ID
	private String name;		//�̼���
	private String address;	  	//�̼ҵ�ַ
	private String tel;			//�̼���ϵ��ʽ
	private String type;		//�̼�����
	private String picture;     //�̼�ͼƬ
	private String introduce;   //�̼ҽ���


	/*
	 * �вι��췽��
	 * */
	public Store(int id, String name, String address, String tel,
			String type, String picture, String introduce) 
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.type = type;
		this.picture = picture;
		this.introduce=introduce;
	}

	/*
	 * �޲������췽��
	 * */
	public Store() {
	}


	/* geter() seter()���� */

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "Storeinform [id="+ id + ", name=" + name + ", address=" + address + ", tel="
		+ tel + ", type=" + type + ", picture=" + picture + ", introduce=" + introduce +" ]";
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
		Store other = (Store) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}