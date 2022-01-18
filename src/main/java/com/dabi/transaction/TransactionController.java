package com.dabi.transaction;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dabi.account.Account;
import com.dabi.jar.Jar;
import com.dabi.util.IController;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class TransactionController implements IController<Transaction, TransactionRequest, TransactionResponse> {

	@Autowired
	TransactionService transactionService;

	@Override
	@GetMapping
	public List<TransactionResponse> findAll() {
		return transactionService.findAll().stream().map(transaction -> postProcess(transaction))
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping("/{id}")
	public TransactionResponse findById(@PathVariable int id) {
		return postProcess(transactionService.findById(id));
	}

	@Override
	@PostMapping
	public void save(@RequestBody TransactionRequest transactionRequest) {
		Transaction transaction = preProcess(transactionRequest);
		transactionService.save(transaction);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@RequestBody TransactionRequest transactionRequest, @PathVariable int id) {
		transactionService.update(preProcess(transactionRequest), id);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		transactionService.delete(id);
	}

	@Override
	public Transaction preProcess(TransactionRequest transactionRequest) {
		Account inboundAccount = transactionRequest.getInboundAccountId() == 0 ? null
				: new Account(transactionRequest.getInboundAccountId());
		Account outboundAccount = transactionRequest.getOutboundAccountId() == 0 ? null
				: new Account(transactionRequest.getOutboundAccountId());
		Jar jar = transactionRequest.getJarId() == 0 ? null : new Jar(transactionRequest.getJarId());
		return new Transaction(TransactionType.valueOf(transactionRequest.getTransactionType()),
				transactionRequest.getTransactionDetails(), transactionRequest.getTransactionAmount(),
				transactionRequest.getTransactionDate(), inboundAccount, outboundAccount, jar);
	}

	@Override
	public TransactionResponse postProcess(Transaction transaction) {
		if (transaction == null)
			return null;
		TransactionResponse transactionResponse = new TransactionResponse(String.valueOf(transaction.getId()),
				String.valueOf(transaction.getAmount()), transaction.getDate().toString(), transaction.getDetails(),
				transaction.getType().name(),
				transaction.getInboundAccount() == null ? "" : String.valueOf(transaction.getInboundAccount().getId()),
				transaction.getInboundAccount() == null ? "" : transaction.getInboundAccount().getName(),
				transaction.getOutboundAccount() == null ? ""
						: String.valueOf(transaction.getOutboundAccount().getId()),
				transaction.getOutboundAccount() == null ? "" : transaction.getOutboundAccount().getName());
		return transactionResponse;
	}
}
