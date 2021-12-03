package com.money.jar.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@RequestMapping(method=RequestMethod.GET, value="/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts")
	public void addAccount(@RequestBody Account account) {
		accountService.addAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{id}")
	public void updateAccount(@RequestBody Account account, @PathVariable int id) {
		accountService.updateAccount(account, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}
}
