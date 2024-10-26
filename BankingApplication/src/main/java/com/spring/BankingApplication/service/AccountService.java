package com.spring.BankingApplication.service;

import java.util.List;

import com.spring.BankingApplication.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(long id);
	
	List<AccountDto> getAccount();

	AccountDto depositAmount(long id, double amount);
	
	AccountDto withdrawAmount(long id, double amount);
	
	void deleteAccountById(long id);
}
