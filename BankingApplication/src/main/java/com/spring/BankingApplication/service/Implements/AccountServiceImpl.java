package com.spring.BankingApplication.service.Implements;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.BankingApplication.dto.AccountDto;
import com.spring.BankingApplication.entity.Account;
import com.spring.BankingApplication.mapper.AccountMapper;
import com.spring.BankingApplication.repository.AccountRepository;
import com.spring.BankingApplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {

		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account doesn't exists."));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public List<AccountDto> getAccount() {
		List<Account> accountList = accountRepository.findAll();
		return AccountMapper.mapToAccountDtoList(accountList);
	}

	@Override
	public AccountDto depositAmount(long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account doesn't exists."));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrawAmount(long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account doesn't exists."));
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance.");
		} else {
			double total = account.getBalance() - amount;
			account.setBalance(total);
			Account savedAccount = accountRepository.save(account);
			return AccountMapper.mapToAccountDto(savedAccount);
		}

	}

	@Override
	public void deleteAccountById(long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account doesn't exists."));
		
		accountRepository.deleteById(id);
		
	}

}
