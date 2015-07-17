package vo;

import java.util.Date;

public class Meal {
	private int id;					//ID
	private String name;        	//套餐名称
	private Date startTime;			//开始时间
	private Date endTime;    		//结束时间
	private int num;				//数量
	private String priferemential;	//优惠条件
	private double price;			//价格
	private int storeId;			//所属商家ID
	
	public Meal() {
	}
	

	/* 
	 * 有参构造方法
	 * */
	public Meal(int id, String name, Date startTime, Date endTime, int num,
			String priferemential, double price, int storeId) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.num = num;
		this.priferemential = priferemential;
		this.price = price;
		this.storeId = storeId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getPriferemential() {
		return priferemential;
	}


	public void setPriferemential(String priferemential) {
		this.priferemential = priferemential;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	@Override
	public String toString() {
		return "Meal [endTime=" + endTime + ", id=" + id + ", name=" + name
				+ ", num=" + num + ", price=" + price + ", priferemential="
				+ priferemential + ", startTime=" + startTime + ", storeId="
				+ storeId + "]";
	}
	
}