package com.helper.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Jsong
 *	
 *	约会响应实体类
 *
 */
public class Responser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;				//ID
	private int appointmentId;	//约会ID
	private User responserUser;	//响应用户
	private Date time;			//响应时间
	
	public Responser(int id, int appointmentId, User responserUser, Date time) {
		this.id = id;
		this.appointmentId = appointmentId;
		this.responserUser = responserUser;
		this.time = time;
	}
	
	public Responser() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public User getResponserUser() {
		return responserUser;
	}

	public void setResponserUser(User responserUser) {
		this.responserUser = responserUser;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Responser [appointmentId=" + appointmentId + ", id=" + id
				+ ", responserUser=" + responserUser + ", time=" + time + "]";
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
		Responser other = (Responser) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
