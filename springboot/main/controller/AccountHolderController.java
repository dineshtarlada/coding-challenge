package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.service.AccountHolderService;
import com.springboot.main.service.BankExecutiveService;

@RestController
@RequestMapping("/accountholder")
public class AccountHolderController {

	@Autowired
	private AccountHolderService accountHolderService;
	
	@Autowired
	private BankExecutiveService bankExecutiveService;

	@PostMapping("/add")
	public AccountHolder insertAccountHolder(@RequestBody AccountHolder accountHolder) {

		return accountHolderService.insert(accountHolder);

	}

	@GetMapping("all/{type}")
	public List<AccountHolder> getallAccountHoldersByAccountType(@PathVariable("type") String type) {

		return accountHolderService.getallAccountHoldersByAccountType(type);

	}
	@GetMapping("/getallbyexecutive/{eid}")
	public ResponseEntity<?> getAccountHoldersByExecutive(@PathVariable("eid") int eid) {

		try {
			BankExecutive bankExecutive = bankExecutiveService.getById(eid);
			List<AccountHolder> list = accountHolderService.getAccountHoldersByExecutive(eid);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	
	
	
	
	
	
	
}
