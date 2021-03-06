package com.helper.entity;

import java.io.Serializable;
import java.util.*;

/**
 * @author Jsong
 *	
 *	约会实体类
 *
 */
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;				//ID
	private Date startTime;		//发起时间
	private Date endTime;   	//结束时间
	private boolean isCacel;	//取消标志
	private boolean isBreak;	//违约标志
	private int userId;   		//发起用户ID
	private User user;	//发起用户名
	private int otherUserId;   	//接受用户ID
	private User otherUser; //接受用户名
	private String payKey;   	//优惠码
	private Date time;   		//时间
	private int gender;			//性别要求   1.男女不限  2.只限男生 3.只限女生
	private ArrayList<String> substance;	//约会内容
	private String description;	//详细说明
	private int mealId;			//套餐ID
	private String meal;		//套餐名称
	private boolean examine;	//审核标志
	private boolean response;	//响应标志
	
	private ArrayList<Responser> responsers;
	
	/*
	 * 无参构造方法
	 * */
	public Appointment() {
	}
	

	public boolean isResponse() {
		return response;
	}
	
	public char isResponseChar() {
		if (response) {
			return 'Y';
		}else {
			return 'N';
		}
	}
	
	public void setResponse(char examine) {
		if (examine == 'N') {
			this.response = false;
		} else {
			this.response = true;
		}
	}
	
	public ArrayList<Responser> getResponsers() {
		return responsers;
	}

	public void setResponsers(ArrayList<Responser> responsers) {
		this.responsers = responsers;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setOtherUser(User otherUser) {
		this.otherUser = otherUser;
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
	
	public char isCacelChar() {
		if (isCacel) {
			return 'Y';
		}else {
			return 'N';
		}
	}

	public boolean isCacel() {
		return isCacel;
	}

	public void setCacel(boolean isCacel) {
		this.isCacel = isCacel;
	}
	
	public void setCacel(String isCacel) {
		char flag = isCacel.charAt(0);
		if (flag == 'N') {
			this.isCacel = false;
		} else {
			this.isCacel = true;
		}
	}
	
	public void setCacel(char isCacel) {
		if (isCacel == 'N') {
			this.isCacel = false;
		} else {
			this.isCacel = true;
		}
	}

	public boolean isBreak() {
		return isBreak;
	}
	
	public char isBreakChar() {
		if (isBreak) {
			return 'Y';
		}else {
			return 'N';
		}
	}

	public void setBreak(boolean isBreak) {
		this.isBreak = isBreak;
	}
	
	public void setBreak(String isBreak) {
		char flag = isBreak.charAt(0);
		if (flag == 'N') {
			this.isBreak = false;
		} else {
			this.isBreak = true;
		}
	}
	
	public void setBreak(char isBreak) {
		if (isBreak == 'N') {
			this.isBreak = false;
		} else {
			this.isBreak = true;
		}
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

	public String getMeal() {
		return meal;
	}


	public void setMeal(String meal) {
		this.meal = meal;
	}

	public boolean isExamine() {
		return examine;
	}
	
	public char isExamineChar() {
		if (examine) {
			return 'Y';
		} else {
			return 'N';
		}
	}

	public void setExamine(boolean examine) {
		this.examine = examine;
	}
	
	public void setExamine(char examine) {
		if (examine == 'N') {
			this.examine = false;
		} else {
			this.examine = true;
		}
	}
	
	public void setExamine(String examine) {
		char isExamine = examine.charAt(0);
		if (isExamine == 'N') {
			this.examine = false;
		} else {
			this.examine = true;
		}
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
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
	
	public String getGenderString() {
		if(gender == 1){
			return "男女不限";
		}else if(gender ==2){
			return "只限男生";
		} else {
			return "只限女生";
		}
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
	
	public void setSubstance(String[] substance) {
		this.substance = new ArrayList<String>();
		for (int i = 0; i < substance.length; i++) {
			this.substance.add(substance[i]);
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getOtherUser() {
		return otherUser;
	}

	public void setOtherUserName(User otherUser) {
		this.otherUser = otherUser;
	}


	@Override
	public String toString() {
		return "Appointment [description=" + description + ", endTime="
				+ endTime + ", examine=" + examine + ", gender=" + gender
				+ ", id=" + id + ", isBreak=" + isBreak + ", isCacel="
				+ isCacel + ", meal=" + meal + ", mealId=" + mealId
				+ ", otherUser=" + otherUser + ", otherUserId=" + otherUserId
				+ ", payKey=" + payKey + ", response=" + response
				+ ", responsers=" + responsers + ", startTime=" + startTime
				+ ", substance=" + substance + ", time=" + time + ", user="
				+ user + ", userId=" + userId + "]";
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
		Appointment other = (Appointment) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
