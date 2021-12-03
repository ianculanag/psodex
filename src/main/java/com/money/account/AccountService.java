package com.money.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public void addAccount(Account account) {
		accountRepository.save(account);
	}

	public void updateAccount(Account account, int id) {
		account.setId(id);
		accountRepository.save(account);
	}

	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
	}
}
