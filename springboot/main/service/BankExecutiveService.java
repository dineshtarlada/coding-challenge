package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.respository.BankExecutiveRepository;

@Service
public class BankExecutiveService {

	

	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;

	public BankExecutive insert(BankExecutive bankExecutive) {
		// TODO Auto-generated method stub
		return bankExecutiveRepository.save(bankExecutive);
	}

	public BankExecutive getById(int bankExecutiveId) throws InvalidIdException {
		Optional<BankExecutive> optional = bankExecutiveRepository.findById(bankExecutiveId);
		if (!optional.isPresent()) {
			throw new InvalidIdException("bankExecutive ID Invalid");
		}
		return optional.get();

}

	
}