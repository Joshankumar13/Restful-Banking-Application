package com.spring.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.BankingApplication.entity.Account;

public interface AccountRepository  extends JpaRepository<Account,Long>{

}
