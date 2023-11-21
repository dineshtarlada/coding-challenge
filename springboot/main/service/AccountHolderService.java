package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.respository.AccountHolderRepository;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	public AccountHolder insert(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		return accountHolderRepository.save(accountHolder);
	}

	public AccountHolder getById(int accountHolderId) throws InvalidIdException {
		Optional<AccountHolder> optional = accountHolderRepository.findById(accountHolderId);
		if (!optional.isPresent()) {
			throw new InvalidIdException("accountHolder ID Invalid");
		}
		return optional.get();

}

	public  List<AccountHolder> getallAccountHoldersByAccountType(String type) {
		// TODO Auto-generated method stub
		return accountHolderRepository.getallAccountHoldersByAccountType(type);
	}
	public List<AccountHolder> getAccountHoldersByExecutive(int eid) {
		// TODO Auto-generated method stub
		return accountHolderRepository.getAccountHoldersByExecutive(eid);
	}
}
