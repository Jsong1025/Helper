package vo;

import java.util.*;;

public class Appointment {
	private int id;				//ID
	private int mealId;    //�̼�id
	private int userId;   //�����û�id
	private int otherUserId;   //�����û�id
	private int recordId;     //��¼
	
	public Appointment (int id,int mealId,	int userId,  int otherUserId,int recordId)
	{
				this.id=id;
				this.mealId=mealId;
				this.userId=userId;
				this.otherUserId=otherUserId;
				this.recordId=recordId;
			}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOtherUserId() {
		return otherUserId;
	}
	public void setOtherUserId(int otherUserId) {
		this.otherUserId = otherUserId;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String toString() {
		return "User [ id="+ id + ",mealId=" + mealId + ",userId=" + userId+ ",otherUserIde="
				+ otherUserId + ", recordId=" + recordId + "]";
	}
	
}
