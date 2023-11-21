package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Employee;
import com.springboot.main.respository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/employee/post")
	public Employee insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		
		
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list=employeeRepository.findAll();
		return list;
	}

	public Employee getEmployeeById(int id) throws InvalidIdException {
		// TODO Auto-generated method stub
		Optional<Employee> optional=employeeRepository.findById(id);
		if(!optional.isPresent())
			throw new InvalidIdException("Invalid Employee ID");
		Employee employee=optional.get();
		
		
		return employee;
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

}
