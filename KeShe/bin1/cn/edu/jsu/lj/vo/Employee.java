package cn.edu.jsu.lj.vo;

public class Employee {

	private  String name;//����
	private  String sex;//�Ա�
	private String tel;//�绰����
	private  String id;//�˺�
	private  String code;//����
	
	public Employee() {
		super();
	}

	
	public Employee(String name, String sex, String tel, String id, String code) {
		super();
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.id = id;
		this.code = code;
	}


	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public  String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public  String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public  String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Employee [����=" + name + ", �Ա�=" + sex + ", �绰=" + tel + ", �˺�=" + id + ", ����=" + code + "]";
	}

	
	
}
