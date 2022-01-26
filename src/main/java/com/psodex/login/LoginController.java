package com.psodex.login;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psodex.rest.account.Account;
import com.psodex.rest.account.AccountResponse;
import com.psodex.rest.account.AccountService;
import com.psodex.rest.transaction.Transaction;
import com.psodex.rest.transaction.TransactionResponse;
import com.psodex.rest.transaction.TransactionService;
import com.psodex.rest.user.User;
import com.psodex.rest.user.UserBuilder;
import com.psodex.rest.user.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionService transactionService;

	@GetMapping("/")
	public String init() {
		return "index";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(HttpServletRequest request) {
		Authentication authentication = userService.getAuthentication(preProcess(request));
		if (authentication instanceof UsernamePasswordAuthenticationToken) {
			request.setAttribute("accounts", processAccountResponse(accountService.findAll(authentication)));
			request.setAttribute("transactions",
					processTransactionResponse(transactionService.findAll(authentication)));
			return "dashboard";
		}
		return "index";
	}

	private User preProcess(HttpServletRequest userRequest) {
		return new UserBuilder().email(userRequest.getParameter("email")).password(userRequest.getParameter("password"))
				.build();
	}

	public List<AccountResponse> processAccountResponse(List<Account> accounts) {
		if (accounts == null)
			return null;
		return accounts.stream()
				.map(account -> new AccountResponse(String.valueOf(account.getId()), account.getAccountNumber(),
						account.getName(), account.getBalance(), account.getDescription(), account.getIssuingBank()))
				.collect(Collectors.toList());
	}

	public List<TransactionResponse> processTransactionResponse(List<Transaction> transactions) {
		if (transactions == null)
			return null;
		return transactions.stream()
				.map(transaction -> new TransactionResponse(String.valueOf(transaction.getId()),
						transaction.getAmount(), transaction.getDate().toString(), transaction.getDetails(),
						transaction.getType().name(),
						transaction.getInboundAccount() == null ? ""
								: String.valueOf(transaction.getInboundAccount().getId()),
						transaction.getInboundAccount() == null ? "" : transaction.getInboundAccount().getName(),
						transaction.getOutboundAccount() == null ? ""
								: String.valueOf(transaction.getOutboundAccount().getId()),
						transaction.getOutboundAccount() == null ? "" : transaction.getOutboundAccount().getName()))
				.collect(Collectors.toList());
	}
}
