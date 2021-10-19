package com.syun.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syun.dao.DepartmentDao;
import com.syun.dao.EmployeeDao;
import com.syun.pojo.Department;
import com.syun.pojo.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/emps")
	public String empList(Model model) {
		Collection<Employee> employees = employeeDao.getEmployees();
		
		model.addAttribute("emps", employees);
		
		return "employee/list";
	}
	
	@GetMapping("/emp")
	public String toAddPage(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		
		model.addAttribute("departments", departments);
		
		return "employee/add";
	}
	
	@PostMapping("/emp")
	public String addEmp(Employee employee) {
		System.out.println(employee);
		
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@GetMapping("/emp/{id}")
	public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
		Employee employee = employeeDao.getEmployeeById(id);
		model.addAttribute("emp", employee);
		
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("departments", departments);
		
		return "employee/update";
	}
	
	@RequestMapping("/updateEmp")
	public String updateEmp(Employee employee) {
		
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@RequestMapping("/delemp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		
		return "redirect:/emps";
	}
}
