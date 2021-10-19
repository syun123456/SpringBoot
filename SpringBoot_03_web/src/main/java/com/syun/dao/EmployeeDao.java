package com.syun.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syun.pojo.Department;
import com.syun.pojo.Employee;

@Repository
public class EmployeeDao {
	private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static {
		employees.put(1001, new Employee(1001, "AAA", "aaa@gmail.com", 0, new Department(101, "資訊部")));
		employees.put(1002, new Employee(1002, "BBB", "bbb@gmail.com", 1, new Department(102, "人資部")));
		employees.put(1003, new Employee(1003, "CCC", "ccc@gmail.com", 0, new Department(103, "總務部")));
		employees.put(1004, new Employee(1004, "DDD", "ddd@gmail.com", 1, new Department(104, "財務部")));
		employees.put(1005, new Employee(1005, "EEE", "eee@gmail.com", 0, new Department(105, "營銷部")));

	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
		
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getEmployees(){
		return employees.values();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employees.get(id);
	}
	
	public void delete(Integer id) {
		employees.remove(id);
	}
}
