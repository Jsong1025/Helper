package vo;

import java.util.*;

public class Appointment {
	private int id;				//ID
	private Date startTime;		//发起时间
	private Date endTime;   	//结束时间
	private boolean isCacel;	//取消标志
	private boolean isBreak;	//违约标志
	private int userId;   		//发起用户ID
	private int otherUserId;   	//接受用户ID
	private char payKey;   		//优惠码
	private Date time;   		//时间
	private int gender;			//性别要求   1.男女不限  2.只限男生 3.只限女生
	private ArrayList<String> substance;	//约会内容
	private String description;	//详细说明
	private int mealId;			//套餐ID
	
	/*
	 * 无参构造方法
	 * */
	public Appointment() {
	}
	
	/*
	 * 有参数构造方法
	 */
	public Appointment(int id, Date startTime, Date endTime, boolean isCacel,
			boolean isBreak, int userId, int otherUserId, char payKey,
			Date time, int gender, ArrayList<String> substance,
			String description, int mealId) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isCacel = isCacel;
		this.isBreak = isBreak;
		this.userId = userId;
		this.otherUserId = otherUserId;
		this.payKey = payKey;
		this.time = time;
		this.gender = gender;
		this.substance = substance;
		this.description = description;
		this.mealId = mealId;
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

	public boolean isCacel() {
		return isCacel;
	}

	public void setCacel(boolean isCacel) {
		this.isCacel = isCacel;
	}

	public boolean isBreak() {
		return isBreak;
	}

	public void setBreak(boolean isBreak) {
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public ArrayList<String> getSubstance() {
		return substance;
	}
	
	public String getSubstanceToString() {
		String sub = "";
		for (int i = 0; i < substance.size(); i++) {
			sub += substance.get(i) +",";
		}
		return sub;
	}

	public void setSubstance(ArrayList<String> substance) {
		this.substance = substance;
	}
	
	public void setSubstance(String substance) {
		String[] subs = substance.split(",");
		this.substance = new ArrayList<String>();
		for (int i = 0; i < subs.length; i++) {
			this.substance.add(subs[i]);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	@Override
	public String toString() {
		return "Appointment [description=" + description + ", endTime="
				+ endTime + ", gender=" + gender + ", id=" + id + ", isBreak="
				+ isBreak + ", isCacel=" + isCacel + ", mealId=" + mealId
				+ ", otherUserId=" + otherUserId + ", payKey=" + payKey
				+ ", startTime=" + startTime + ", substance=" + substance
				+ ", time=" + time + ", userId=" + userId + "]";
	}
	
	
}
