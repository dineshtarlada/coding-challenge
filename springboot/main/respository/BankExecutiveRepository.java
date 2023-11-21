package com.springboot.main.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;

public interface BankExecutiveRepository extends JpaRepository<BankExecutive, Integer>{

	

}
