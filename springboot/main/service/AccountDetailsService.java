package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.AccountDetails;
import com.springboot.main.respository.AccountDetailsRepository;

@Service
public class AccountDetailsService {
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public AccountDetails insert(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}

}
