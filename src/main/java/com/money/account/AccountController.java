package com.money.account;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "/accounts")
	public List<AccountResponse> getAllAccounts() {
		return accountService.getAllAccounts().stream().map(account -> prepareResponse(account))
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
	public AccountResponse getAccountById(@PathVariable int id) {
		return prepareResponse(accountService.getAccountById(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts")
	public void addAccount(@RequestBody AccountRequest accountRequest) {
		Account account = instantiateModel(accountRequest);
		accountService.addAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{id}")
	public void updateAccount(@RequestBody AccountRequest accountRequest, @PathVariable int id) {
		accountService.updateAccount(instantiateModel(accountRequest), id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}

	private Account instantiateModel(AccountRequest accountRequest) {
		return new Account(accountRequest.getAccountNumber(), accountRequest.getAccountName(),
				accountRequest.getBalance(), accountRequest.getDescription(), accountRequest.getIssuingBank());
	}

	private AccountResponse prepareResponse(Account account) {
		if (account == null) return null;
		AccountResponse accountResponse = new AccountResponse(account.getId(), account.getAccountNumber(),
				account.getName(), account.getBalance(), account.getDescription(),
				account.getIssuingBank());
		return accountResponse;
	}
}
