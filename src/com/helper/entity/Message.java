package com.helper.entity;

import java.io.Serializable;

/**
 * @author Jsong
 *	
 *	消息实体类
 *
 */
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;				//ID
	private int user;			//所属用户ID
	private int otherUser;		//发起用户
	private String message;		//消息文本
	private int appointmentId; //所属约会ID
	
	public Message() {
	}

	public Message(int id, int user,int otherUser, String message, int appointmentId) {
		this.id = id;
		this.user = user;
		this.otherUser = otherUser;
		this.message = message;
		this.appointmentId = appointmentId;
	}

	public int getOtherUser() {
		return otherUser;
	}

	public void setOtherUser(int otherUser) {
		this.otherUser = otherUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", otherUser="
				+ otherUser + ", message=" + message + ", appointmentId="
				+ appointmentId + "]";
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
		Message other = (Message) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
