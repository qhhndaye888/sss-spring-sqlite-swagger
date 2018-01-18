package com.sqlite.entities;

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

@Entity(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false) 
	@Size(max = 20)
	private String name;
	@Column(nullable = false) 
	@Size(max = 10)
	private String rocId;
	@Column(nullable = false) 
	private String employeeNo;
    @OneToMany
    @JoinColumn(name="habbit_id",referencedColumnName = "id")
	private List<Habbit> habbits;
	@OneToOne
	@JoinColumn(name = "department_id" ,referencedColumnName = "id")
	private Department department;
 
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
	

	public List<Habbit> getHabbits() {
		return habbits;
	}

	public void setHabbits(List<Habbit> habbits) {
		this.habbits = habbits;
	}
   
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

 

 
 

}
