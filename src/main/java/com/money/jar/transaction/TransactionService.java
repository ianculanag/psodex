package com.money.jar.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);
	}
}
