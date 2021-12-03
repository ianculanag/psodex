package com.money.jar.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(method=RequestMethod.GET, value="/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transactions")
	public void addTransaction(@RequestBody Transaction transaction) {
		transactionService.addTransaction(transaction);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/transactions")
	public void updateTransaction(@RequestBody Transaction transaction) {
		transactionService.updateTransaction(transaction);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/transactions/{id}")
	public void deleteTransaction(@PathVariable int id) {
		transactionService.deleteTransaction(id);
	}
}
