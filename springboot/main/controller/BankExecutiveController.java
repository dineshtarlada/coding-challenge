package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.enums.RoleType;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.model.User;
import com.springboot.main.service.BankExecutiveService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/Executive")
public class BankExecutiveController {

	@Autowired
	private UserService userService;

	@Autowired
	private BankExecutiveService bankExecutiveService;

	@PostMapping("/add")
	public BankExecutive executiveAdd(@RequestBody BankExecutive bankExecutive) {

		User user = bankExecutive.getUser();

		user.setRole(RoleType.Executive);

		user = userService.insert(user);

		bankExecutive.setUser(user);

		return bankExecutiveService.insert(bankExecutive);

	}

}
