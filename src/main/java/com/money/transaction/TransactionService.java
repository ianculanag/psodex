package com.money.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.jar.JarService;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	JarService jarService;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public void addTransaction(Transaction transaction) {
		if (TransactionType.INCOME == transaction.getType()) {
			jarService.topUp(transaction.getAmount());
		}
		
		transactionRepository.save(transaction);
	}

	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);
	}
}
