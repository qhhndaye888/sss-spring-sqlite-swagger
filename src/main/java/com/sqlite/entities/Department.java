package com.sqlite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
@Entity(name = "department")
public class Department {
	@Column(nullable = false) 
    @ApiModelProperty(position = 2, required = true, value = "部門名稱")
	private String name ;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(position = 1, required = true, value = "PK,自動產生，新增不用帶值,更新和刪除需帶值")
	private int id;
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
	public Department(String departmentName) {
		this.name = departmentName;
	}
	public Department(int id , String departmentName) {
		this.name = departmentName;
		this.id = id;
	}
	public Department() {
		
	}
}
