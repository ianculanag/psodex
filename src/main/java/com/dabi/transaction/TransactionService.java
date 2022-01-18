package com.dabi.transaction;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dabi.account.Account;
import com.dabi.account.AccountService;
import com.dabi.jar.JarService;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	JarService jarService;
	
	@Autowired
	AccountService accountService;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public void addTransaction(Transaction transaction) {
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

	private void transact(Transaction transaction, BigDecimal amount) {
		Account inboundAccount = transaction.getInboundAccount();
		Account outboundAccount = transaction.getOutboundAccount();
		accountService.transact(amount, inboundAccount == null ? 0 : inboundAccount.getId(),
				outboundAccount == null ? 0 : outboundAccount.getId());
	}

	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);
	}
}
