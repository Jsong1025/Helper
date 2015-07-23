package vo;

import java.sql.Date;

public class Responser {
	
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

}
