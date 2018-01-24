package com.sqlite.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 import com.sqlite.dao.DepartmentDao;
import com.sqlite.entities.Department;
import com.sqlite.models.DepartmentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@RestController
@Api(value="部門", description="部門")
public class DepartmentController {
	@Autowired
	DepartmentDao departmentDao;
    @ApiOperation(value = "取得全部部門清單")
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getDepartments() throws Exception{
		List<Department> list = this.departmentDao.findAll();
		return new ResponseEntity<List<Department>>(list, new HttpHeaders(), HttpStatus.OK);
	}
    @ApiOperation(value = "新增部門資料")
	@RequestMapping(value = "/departments", method = RequestMethod.POST)
	public ResponseEntity<Department> addDepartments(@RequestBody DepartmentVo departmentVo) throws Exception{
		Department departmentDto = new Department();
		BeanUtils.copyProperties(departmentVo, departmentDto);
		 
		departmentDto= this.departmentDao.save(departmentDto);
		return new ResponseEntity<Department>(departmentDto, new HttpHeaders(), HttpStatus.OK);
	}
    @ApiOperation(value = "更新部門資料")
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Department> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentVo department) throws Exception{
		Department departmentDto= this.departmentDao.findOne(id);
		BeanUtils.copyProperties(department, departmentDto);
		return new ResponseEntity<Department>(departmentDto, new HttpHeaders(), HttpStatus.OK);
	}
}
