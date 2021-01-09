package cn.edu.jsu.lj.vo;

import java.io.Serializable;

public class Consumption implements Serializable {
	private String cusid;//顾客
	private String empid;//员工
	private String project;//项目
	private String price;//价格
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
		return "Consumption [顾客：" + cusid + ", 员工：" + empid + ", 项目：" + project + ", 价格：" + price + "]";
	}
	
}
