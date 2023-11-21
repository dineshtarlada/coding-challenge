package com.springboot.main.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

	@Query(value="select * from account_holder ah join account_details ad on ah.id=ad.account_holder_id join account a on ad.account_id=a.id where a.type=1?",nativeQuery = true)
	List<AccountHolder> getallAccountHoldersByAccountType(String type);


	@Query(value="select * from account_holder ah join account_details ad on ah.id=ad.account_holder_id join bank_executive b on ad.bank_executive_id =b.id where b.id=1?",nativeQuery = true)
	List<AccountHolder> getAccountHoldersByExecutive(int eid);
}
