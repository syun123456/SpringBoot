package com.syun.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.syun.pojo.Department;

@Repository
public class DepartmentDao {
	
	private static Map<Integer, Department> departments = new HashMap<Integer, Department>();
	
	static {
		departments.put(101, new Department(101, "資訊部"));
		departments.put(102, new Department(102, "人資部"));
		departments.put(103, new Department(103, "總務部"));
		departments.put(104, new Department(104, "財務部"));
		departments.put(105, new Department(105, "營銷部"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartmentById(Integer id) {
		return departments.get(id);
	}
	
}
