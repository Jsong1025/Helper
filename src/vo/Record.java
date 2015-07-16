package vo;

import java.util.*;

public class Record {
	private int id;				//ID
	private Date startTime;	//���ʼʱ��
	private Date endTime;   //�����ʱ��
	private char isCacel;
	private char isBreak;
	private int userId;   //�����û�id
	private int otherUserId;   //�����û�id
	private char payKey;   //�����û�id
	
	
	public Record (int id,Date startTime,	Date endTime,  char isCacel,char isBreak,
	int userId, int otherUserId,  char payKey){
		this.id=id;
		this.startTime=startTime;
		this.endTime=endTime;
		this.isCacel=isCacel;
		this.isBreak=isBreak;
		this.userId=userId;
		this.otherUserId=otherUserId;
		this.payKey=payKey;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public char getIsCacel() {
		return isCacel;
	}
	public void setIsCacel(char isCacel) {
		this.isCacel = isCacel;
	}
	public char getIsBreak() {
		return isBreak;
	}
	public void setIs_break(char isBreak) {
		this.isBreak = isBreak;
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
	public char getPayKey() {
		return payKey;
	}
	public void setPayKey(char payKey) {
		this.payKey = payKey;
	}
	public String toString() {
		return "User [ id="+ id + ",start_time=" + startTime + ",end_time=" + endTime+ ",is_cacel="
				+ isCacel + ", is_break=" + isBreak+ ", user_id=" +userId+ ",other_user_id=" + otherUserId+ ",pay_key=" + payKey+ "]";
	}
}
