package com.helper.entity;

import java.io.Serializable;
import java.util.*;

/**
 * @author Jsong
 *	
 *	Լ��ʵ����
 *
 */
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;				//ID
	private Date startTime;		//����ʱ��
	private Date endTime;   	//����ʱ��
	private boolean isCacel;	//ȡ����־
	private boolean isBreak;	//ΥԼ��־
	private int userId;   		//�����û�ID
	private User user;	//�����û���
	private int otherUserId;   	//�����û�ID
	private User otherUser; //�����û���
	private String payKey;   	//�Ż���
	private Date time;   		//ʱ��
	private int gender;			//�Ա�Ҫ��   1.��Ů����  2.ֻ������ 3.ֻ��Ů��
	private ArrayList<String> substance;	//Լ������
	private String description;	//��ϸ˵��
	private int mealId;			//�ײ�ID
	private String meal;		//�ײ�����
	private boolean examine;	//��˱�־
	private boolean response;	//��Ӧ��־
	
	private ArrayList<Responser> responsers;
	
	/*
	 * �޲ι��췽��
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
			return "��Ů����";
		}else if(gender ==2){
			return "ֻ������";
		} else {
			return "ֻ��Ů��";
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
