package com.dabi.account;

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

import com.dabi.util.IController;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class AccountController implements IController<Account, AccountRequest, AccountResponse> {

	@Autowired
	AccountService accountService;

	@Override
	@GetMapping
	public List<AccountResponse> findAll() {
		return accountService.findAll().stream().map(account -> postProcess(account)).collect(Collectors.toList());
	}

	@Override
	@GetMapping("/{id}")
	public AccountResponse findById(@PathVariable int id) {
		return postProcess(accountService.findById(id));
	}

	@Override
	@PostMapping
	public void save(@RequestBody AccountRequest accountRequest) {
		Account account = preProcess(accountRequest);
		accountService.save(account);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@RequestBody AccountRequest accountRequest, @PathVariable int id) {
		accountService.update(preProcess(accountRequest), id);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		accountService.delete(id);
	}

	@Override
	public Account preProcess(AccountRequest accountRequest) {
		return new Account(accountRequest.getAccountNumber(), accountRequest.getAccountName(),
				accountRequest.getBalance(), accountRequest.getDescription(), accountRequest.getIssuingBank());
	}

	@Override
	public AccountResponse postProcess(Account account) {
		if (account == null)
			return null;
		AccountResponse accountResponse = new AccountResponse(String.valueOf(account.getId()),
				account.getAccountNumber(), account.getName(), account.getBalance(), account.getDescription(),
				account.getIssuingBank());
		return accountResponse;
	}
}
