package com.money.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.money.account.Account;
import com.money.jar.Jar;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(method=RequestMethod.GET, value="/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transactions")
	public void addTransaction(@RequestBody TransactionRequest transactionRequest) {
		Transaction transaction = instantiateModel(transactionRequest);
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

	private Transaction instantiateModel(TransactionRequest transactionRequest) {
		Account inboundAccount = transactionRequest.getInboundAccountId() == 0 ? null
				: new Account(transactionRequest.getInboundAccountId());
		Account outboundAccount = transactionRequest.getOutboundAccountId() == 0 ? null
				: new Account(transactionRequest.getOutboundAccountId());
		Jar jar = transactionRequest.getJarId() == 0 ? null : new Jar(transactionRequest.getJarId());
		return new Transaction(TransactionType.valueOf(transactionRequest.getTransactionType()),
				transactionRequest.getTransactionDetails(), transactionRequest.getTransactionAmount(),
				transactionRequest.getTransactionDate(), inboundAccount, outboundAccount, jar);
	}
}
