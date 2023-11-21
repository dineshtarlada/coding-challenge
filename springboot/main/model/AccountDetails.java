package com.springboot.main.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@CreationTimestamp

	@Column(name = "date_of_creation", nullable = false, updatable = false)
	private Date dateOfCreation;

	@ManyToOne
	private Account account;

	@ManyToOne
	private AccountHolder accountHolder;

	@ManyToOne
	private BankExecutive bankExecutive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public BankExecutive getBankExecutive() {
		return bankExecutive;
	}

	public void setBankExecutive(BankExecutive bankExecutive) {
		this.bankExecutive = bankExecutive;
	}

}
