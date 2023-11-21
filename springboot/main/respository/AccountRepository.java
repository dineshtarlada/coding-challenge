package com.springboot.main.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
