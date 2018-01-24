
package com.sqlite;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sqlite.dao.DepartmentDao;
import com.sqlite.dao.EmployeeDao;
import com.sqlite.dao.HabbitDao;
import com.sqlite.entities.Department;
import com.sqlite.entities.Employee;
import com.sqlite.entities.Habbit;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(DepartmentDao departmentDao, HabbitDao habbitDao,EmployeeDao employeeDao) {
		return (args) -> {
			if (departmentDao.findAll().size() == 0) {
				departmentDao.save(new Department("基金業務部"));
				departmentDao.save(new Department("行銷企劃部"));
				departmentDao.save(new Department("總經理室"));
				departmentDao.save(new Department("研發部"));
				departmentDao.save(new Department("行銷部"));
				departmentDao.save(new Department("財務部"));
			}
			if (habbitDao.findAll().size() == 0) {
				habbitDao.save(new Habbit("看電影"));
				habbitDao.save(new Habbit("爬山"));
				habbitDao.save(new Habbit("看書"));
				habbitDao.save(new Habbit("發呆"));
				habbitDao.save(new Habbit("寫程式"));
			}
			
			if(employeeDao.findAll().size()==0) {
				Employee employee = new Employee();
				employee.setRocId("A12345678");
				employee.setName("Roger");
				Department dep =  new Department();
				dep.setId(1);
				employee.setEmployeeNo("A1204");
				employee.setDepartment(dep);
				employee.setMarriage(Boolean.FALSE);
				employee.setChild(0);
				List<Habbit> list = new ArrayList<Habbit>();				
				list.add(habbitDao.getOne(1));
				employee.setHabbits(list);
				employeeDao.save(employee);
				
			}
		};
	}
}
