package vo;

public class Message {
	
	private int id;				//ID
	private int user;			//所属用户ID
	private String message;		//消息文本
	private int appointmentId; //所属约会ID
	
	public Message() {
	}

	public Message(int id, int user, String message, int appointmentId) {
		this.id = id;
		this.user = user;
		this.message = message;
		this.appointmentId = appointmentId;
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
		return "Message [appointmentId=" + appointmentId + ", id=" + id
				+ ", message=" + message + ", user=" + user + "]";
	}
	
}
