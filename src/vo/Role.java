package vo;

public class Role {
	
	private int id;				//ID
	private String name;	  //����Ա����
	private int permision ;	  //Ȩ��ֵ
	
	public Role (int id , String name,	int permision)
	{
				this.id=id;
				this.name=name;
				this.permision=permision;
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
	public int getPermision() {
		return permision;
	}
	public void setPermision(int permision) {
		this.permision = permision;
	}
	public String toString() {
		return "Storeinform [id="+ id + ", name=" + name + ", permision=" + permision + " ]";
	}

}
