package com.springboot.main.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
