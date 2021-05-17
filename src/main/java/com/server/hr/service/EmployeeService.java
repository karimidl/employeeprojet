package com.server.hr.service;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.Exceptions.UserNotFoundException;
import com.server.hr.model.Employee;
import com.server.hr.reposi.EmployeeRepo;



@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		
		this.employeeRepo = employeeRepo;
	}
	public Employee addEmployee(Employee employee) {
		employee.setMatricule(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	public java.util.List<Employee> findAllEmployee(){
		return employeeRepo.findAll();
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("Agent N°" +id+ "pas trouvé"));
	}
	public void deletEemployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	

}
