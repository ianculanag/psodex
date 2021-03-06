package com.dabi.transaction;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dabi.account.Account;
import com.dabi.account.AccountService;
import com.dabi.jar.Jar;
import com.dabi.jar.JarService;
import com.dabi.user.UserService;
import com.dabi.util.IService;

@Service
public class TransactionService implements IService<Transaction> {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	JarService jarService;

	@Autowired
	AccountService accountService;

	@Autowired
	UserService userService;

	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAllByUserId(userService.getLoggedInUserId());
	}

	@Override
	public Transaction findById(int id) {
		return transactionRepository.findByIdAndUserId(id, userService.getLoggedInUserId()).get();
	}

	@Override
	public void save(Transaction transaction) {
		TransactionType type = transaction.getType();
		BigDecimal amount = transaction.getAmount();
		if (TransactionType.INCOME == type) {
			jarService.topUp(amount);
			Account inboundAccount = transaction.getInboundAccount();
			accountService.transact(amount, inboundAccount == null ? null : inboundAccount.getId());
		}
		if (TransactionType.TRANSFER == type) {
			transact(transaction, amount);
		}

		if (TransactionType.EXPENSE == type || TransactionType.INVESTMENT == type || TransactionType.SAVINGS == type) {
			if (transaction.getJar() != null) {
				jarService.withdrawBalance(amount, transaction.getJar().getId());
			}
			transact(transaction, amount);
		}
		transactionRepository.save(transaction);
	}

	@Override
	public void update(Transaction transaction, int id) {
		transactionRepository.save(transaction);
	}

	@Override
	public void delete(int id) {
		transactionRepository.deleteById(id);
	}

	private void transact(Transaction transaction, BigDecimal amount) {
		Account inboundAccount = transaction.getInboundAccount();
		Account outboundAccount = transaction.getOutboundAccount();
		accountService.transact(amount, inboundAccount == null ? 0 : inboundAccount.getId(),
				outboundAccount == null ? 0 : outboundAccount.getId());
	}

	public void setUser(Transaction transaction) {
		transaction.setUser(userService.getLoggedInUser());
	}
}
