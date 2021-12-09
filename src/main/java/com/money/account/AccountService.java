package com.money.account;

import java.math.BigDecimal;
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

	public Account getAccountById(int id) {
		return accountRepository.findById(id).get();
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

	public void cashIn(BigDecimal amount, int inboundAccountId) {
		Account account = accountRepository.findById(inboundAccountId).orElse(null);
		account.setCurrentBalance(account.getCurrentBalance().add(amount));
		accountRepository.save(account);
	}

	// Cash in
	public void transact(BigDecimal amount, int inboundAccountId) {
		Account inboundAccount = accountRepository.findById(inboundAccountId).orElse(null);
		if (inboundAccount != null) {
			inboundAccount.setCurrentBalance(inboundAccount.getCurrentBalance().add(amount));
			accountRepository.save(inboundAccount);
		}
	}

	// Cash in and cash out
	public void transact(BigDecimal amount, int inboundAccountId, int outboundAccountId) {
		if (inboundAccountId != 0) {
			Account inboundAccount = accountRepository.findById(inboundAccountId).orElse(null);
			if (inboundAccount != null) {
				inboundAccount.setCurrentBalance(inboundAccount.getCurrentBalance().add(amount));
				accountRepository.save(inboundAccount);
			}
		}
		if (outboundAccountId != 0) {
			Account outboundAccount = accountRepository.findById(outboundAccountId).orElse(null);
			if (outboundAccount != null) {
				outboundAccount.setCurrentBalance(outboundAccount.getCurrentBalance().subtract(amount));
				accountRepository.save(outboundAccount);
			}
		}
	}
}
