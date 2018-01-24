package com.sqlite.entities;

import java.util.List;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import io.swagger.annotations.ApiModelProperty;

@Entity(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false) 
	@Size(max = 20)
	@ApiModelProperty(position = 1, required = true, value = "員工姓名")
	private String name;
	
	@Column(nullable = false) 
	@Size(max = 10)
	@ApiModelProperty(position = 2, required = true, value = "身份證字號")
	private String rocId;
	
	@Column(nullable = false) 
	@ApiModelProperty(position = 3, required = true, value = "員工編號")
	private String employeeNo;
	
    @OneToMany(fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name="habbit_id",referencedColumnName = "id")
    @Cascade({CascadeType.ALL})
    @ApiModelProperty(position = 4, required = false, value = "興趣清單")
	private List<Habbit> habbits;
    
	@OneToOne
	@JoinColumn(name = "department_id" ,referencedColumnName = "id")
    @ApiModelProperty(position = 5, required = false, value = "部門")
	private Department department;
	
	@Column(nullable = true) 
    @ApiModelProperty(position = 6, required = false, value = "婚姻狀態")
	private boolean marriage;
	
	@Column(nullable = true) 
    @ApiModelProperty(position = 7, required = false, value = "小孩數量")
	private Integer child;
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

	public boolean isMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

	public Integer getChild() {
		return child;
	}

	public void setChild(Integer child) {
		this.child = child;
	}

 

 
 

}
