package com.sqlite.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

 
public class EmployeeVo {
 
	private int id;
 
	private String name;
 
	private String rocId;
	 
	private String employeeNo;
 
	private List<HabbitVo> habbits;
 
	private DepartmentVo department;
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getRocId() {
		return rocId;
	}

	public void setRocId(String rocId) {
		this.rocId = rocId;
	}
	

	public List<HabbitVo> getHabbits() {
		return habbits;
	}

	public void setHabbits(List<HabbitVo> habbits) {
		this.habbits = habbits;
	}
   
	public DepartmentVo getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVo department) {
		this.department = department;
	}

 

 
 

}
