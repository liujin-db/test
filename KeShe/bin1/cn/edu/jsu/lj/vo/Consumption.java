package cn.edu.jsu.lj.vo;

import java.io.Serializable;

public class Consumption implements Serializable {
	private String cusid;//�˿�
	private String empid;//Ա��
	private String project;//��Ŀ
	private String price;//�۸�
	public Consumption() {
	}
	
	
	public Consumption(String cusid, String empid, String project, String price) {
		super();
		this.cusid = cusid;
		this.empid = empid;
		this.project = project;
		this.price = price;
	}


	
	public String getCusid() {
		return cusid;
	}


	public void setCusid(String cusid) {
		this.cusid = cusid;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Consumption [�˿ͣ�" + cusid + ", Ա����" + empid + ", ��Ŀ��" + project + ", �۸�" + price + "]";
	}
	
}
