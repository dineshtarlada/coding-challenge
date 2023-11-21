package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Account;
import com.springboot.main.model.AccountDetails;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.service.AccountDetailsService;
import com.springboot.main.service.AccountHolderService;
import com.springboot.main.service.AccountService;
import com.springboot.main.service.BankExecutiveService;

@RestController
public class AccountDetailsController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountDetailsService accountDetailsService;

	@Autowired
	private AccountHolderService accountHolderService;

	@Autowired
	private BankExecutiveService bankExecutiveService;

	@PostMapping("/accountdetails/add/{accountHolderId}/{accountId}/{bankExecutiveId}")
	public ResponseEntity<?> insertAccountDetails(@PathVariable("accountHolderId") int accountHolderId,
			@PathVariable("accountId") int accountId, @PathVariable("bankExecutiveId") int bankExecutiveId) {
		try {

			AccountDetails accountDetails = new AccountDetails();
			AccountHolder accountHolder = accountHolderService.getById(accountHolderId);

			Account account = accountService.getById(accountId);

			BankExecutive bankExecutive = bankExecutiveService.getById(bankExecutiveId);

			accountDetails.setAccount(account);
			accountDetails.setAccountHolder(accountHolder);
			accountDetails.setBankExecutive(bankExecutive);
			accountDetails = accountDetailsService.insert(accountDetails);

			return ResponseEntity.ok().body(accountDetails);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
