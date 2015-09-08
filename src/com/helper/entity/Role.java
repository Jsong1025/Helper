package com.helper.entity;

import java.io.Serializable;

/**
 * @author Jsong
 *	
 *	��ɫʵ����
 *
 */
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;				//ID
	private String name;	  	//��ɫ��
	private int permision ;	  	//Ȩ����
	
	public Role() {
	}
	
	public Role (int id , String name,	int permision)
	{
				this.id=id;
				this.name=name;
				this.permision=permision;
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
	public int getPermision() {
		return permision;
	}
	public void setPermision(int permision) {
		this.permision = permision;
	}
	
	
	public String toString() {
		return "Storeinform [id="+ id + ", name=" + name + ", permision=" + permision + " ]";
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
