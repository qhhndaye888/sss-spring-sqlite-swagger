package com.sqlite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqlite.entities.Department;
import com.sqlite.models.DepartmentVo;
@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
