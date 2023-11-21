package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Account;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.respository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	public Account insert(Account account) {
		
		return accountRepository.save(account);
	}
	public Account getById(int accountId) throws InvalidIdException {
		
		Optional<Account> optional = accountRepository.findById(accountId);
		if (!optional.isPresent()) {
			throw new InvalidIdException("account ID Invalid");
		}
		return optional.get();

}

}
