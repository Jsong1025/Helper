package vo;

/**
 * @author Jsong
 *	
 *	用户实体类
 *
 */
public class User {
	
	private int id;				//ID
	private String username;	//用户名
	private String password;	//密码
	private String name;		//真实姓名
	private char sex;			//性别
	private int age;			//年龄
	private String tel;			//电话
	private String QQ;			//QQ
	private String email;		//e-mail
	
	/*
	 * 有参构造方法
	 * */
	public User(int id, String username, String password, String name,
			char sex, int age, String tel, String QQ, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.QQ = QQ;
		this.email = email;
	}
	
	/*
	 * 无参构造方法
	 * */
	public User() {
	}

	
	/* geter() seter()方法 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [QQ=" + QQ + ", age=" + age + ", email=" + email + ", id="
				+ id + ", name=" + name + ", password=" + password + ", sex="
				+ sex + ", tel=" + tel + ", username=" + username + "]";
	}
	
}
