package com.helper.entity;

import java.io.Serializable;

/**
 * @author Jsong
 *	
 *	�û�ʵ����
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;			//ID
	private String username;	//�û���
	private String password;	//����
	private String name;		//��ʵ����
	private Character sex;		//�Ա�
	private Integer age;		//����
	private String tel;			//�绰
	private String QQ;			//QQ
	private String email;		//e-mail
	private String location;	//��ס��
	private String description;	//���˽���
	private String picture;		//�û�ͷ��
	
	private Integer roleId;		//��ɫID
	private String role;		//��ɫ��
	
	/*
	 * �вι��췽��
	 * */
	public User(Integer id, String username, String password, String name,
			Character sex, Integer age, String tel, String qQ, String email,
			String location, String description,String picture, Integer roleId, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		QQ = qQ;
		this.email = email;
		this.location = location;
		this.description = description;
		this.picture = picture;
		this.roleId = roleId;
		this.role = role;
	}
	
	/*
	 * �޲ι��췽��
	 * */
	public User() {
	}

	
	/* geter() seter()���� */
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User [QQ=" + QQ + ", age=" + age + ", description="
				+ description + ", email=" + email + ", id=" + id
				+ ", location=" + location + ", name=" + name + ", password="
				+ password + ", picture=" + picture + ", role=" + role
				+ ", roleId=" + roleId + ", sex=" + sex + ", tel=" + tel
				+ ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
