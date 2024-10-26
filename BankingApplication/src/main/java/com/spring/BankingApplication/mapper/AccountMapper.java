package com.spring.BankingApplication.mapper;

import java.util.ArrayList;
import java.util.List;

import com.spring.BankingApplication.dto.AccountDto;
import com.spring.BankingApplication.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());

		return account;

	}

	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());

		return accountDto;

	}

	public static List<AccountDto> mapToAccountDtoList(List<Account> accountList) {
		List<AccountDto> accountDtoList = new ArrayList<>();

		for (Account account : accountList) {
			AccountDto accountDto = mapToAccountDto(account);
			accountDtoList.add(accountDto);
		}

		return accountDtoList;

	}

}
