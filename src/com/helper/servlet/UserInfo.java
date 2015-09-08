package com.helper.servlet;

import java.io.Serializable;

import net.sf.json.JSONObject;

import com.helper.entity.User;

public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;			//ID
	private String username;	//用户名
	private String email;		//e-mail
	private String picture;		//用户头像
	private Integer roleId;		//角色ID
	
	public UserInfo() {
	}
	
	public UserInfo(Integer id, String username, String email, String picture,
			Integer roleId) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.picture = picture;
		this.roleId = roleId;
	}

	public UserInfo(User user) {
		id = user.getId();
		username = user.getUsername();
		email = user.getEmail();
		picture = user.getPicture();
		roleId = user.getRoleId();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		JSONObject obj= JSONObject.fromObject(this);
		return obj.toString();
	}
	
	

}
