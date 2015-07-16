package vo;

public class Meal {
	private int id;				//ID
	private String name;        //�ײ���
	private String start_time;	//���ʼʱ��
	private String end_time;   //�����ʱ��
	private int num;			//����
	private String priferemential;			//��Ż�
	private double price;			//�۸�
	private int store_id;		//�̼Һ�
	
	/*
	 * 有参构�?方法
	 * */
	public Meal(int id, String name, String start_time, String end_time,
			int num, String priferemential, double price, int store_id) {
		this.id = id;
		this.name = name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.num = num;
		this.priferemential = priferemential;
		this.price = price;
		this.store_id = store_id;
		
	}
	
	/*
	 * 无参构�?方法
	 * */
	public Meal() {
	}

	
	/* geter() seter()方法 */
	
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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getnum() {
		return num;
	}

	public void setnum(int num) {
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

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	@Override
	public String toString() {
		return "User [ id="+ id + ", name=" + name + ", start_time=" + start_time+ ", end_time="
				+ end_time + ", num=" + num + ", priferemential=" + priferemential + ", price=" + price + ",store_id=" + store_id + "]";
	}
	
}