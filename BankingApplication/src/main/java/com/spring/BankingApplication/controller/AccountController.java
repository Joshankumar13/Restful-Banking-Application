package com.spring.BankingApplication.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.BankingApplication.dto.AccountDto;
import com.spring.BankingApplication.service.AccountService;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	// Create account REST API

	@PostMapping("/createAccount")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {

		AccountDto createdAccount = accountService.createAccount(accountDto);
		return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);

	}

	// Get account by Id REST API

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long id) {
		AccountDto AccountById = accountService.getAccountById(id);
		return ResponseEntity.ok(AccountById);
	}

	// Get account REST API

	@GetMapping("/getAccounts")
	public ResponseEntity<List<AccountDto>> getAccount() {
		List<AccountDto> AccountList = accountService.getAccount();
		return ResponseEntity.ok(AccountList);
	}

	// Deposit REST API

	@PutMapping("/depositAmount/{id}")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable long id, @RequestBody Map<String, Double> request) {

		double amount = request.get("amount");
		AccountDto UpdatedAccount = accountService.depositAmount(id, amount);
		return ResponseEntity.ok(UpdatedAccount);

	}
	
	//Withdraw REST API
	
	@PutMapping("/withdrawAmount/{id}")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable long id, @RequestBody Map<String, Double> request) {

		double amount = request.get("amount");
		AccountDto UpdatedAccount = accountService.withdrawAmount(id, amount);
		return ResponseEntity.ok(UpdatedAccount);

	}

	//Delete Account by Id REST API
	
	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable long id){
		accountService.deleteAccountById(id);
		return ResponseEntity.ok("Account deleted Successfully.");
		
	}
	

}
