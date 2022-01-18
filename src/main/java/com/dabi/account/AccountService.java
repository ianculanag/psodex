package com.dabi.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dabi.util.IService;

@Service
public class AccountService implements IService<Account> {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(int id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void update(Account account, int id) {
		account.setId(id);
		accountRepository.save(account);
	}

	@Override
	public void delete(int id) {
		accountRepository.deleteById(id);
	}

	public void cashIn(BigDecimal amount, int inboundAccountId) {
		Account account = accountRepository.findById(inboundAccountId).orElse(null);
		account.setBalance(account.getBalance().add(amount));
		accountRepository.save(account);
	}

	// Cash in
	public void transact(BigDecimal amount, int inboundAccountId) {
		Account inboundAccount = accountRepository.findById(inboundAccountId).orElse(null);
		if (inboundAccount != null) {
			inboundAccount.setBalance(inboundAccount.getBalance().add(amount));
			accountRepository.save(inboundAccount);
		}
	}

	// Cash in and cash out
	public void transact(BigDecimal amount, int inboundAccountId, int outboundAccountId) {
		if (inboundAccountId != 0) {
			Account inboundAccount = accountRepository.findById(inboundAccountId).orElse(null);
			if (inboundAccount != null) {
				inboundAccount.setBalance(inboundAccount.getBalance().add(amount));
				accountRepository.save(inboundAccount);
			}
		}
		if (outboundAccountId != 0) {
			Account outboundAccount = accountRepository.findById(outboundAccountId).orElse(null);
			if (outboundAccount != null) {
				outboundAccount.setBalance(outboundAccount.getBalance().subtract(amount));
				accountRepository.save(outboundAccount);
			}
		}
	}
}
