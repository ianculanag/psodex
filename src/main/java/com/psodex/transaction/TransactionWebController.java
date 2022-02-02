package com.psodex.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psodex.rest.account.Account;
import com.psodex.rest.account.AccountResponse;
import com.psodex.rest.account.AccountService;
import com.psodex.rest.jar.Jar;
import com.psodex.rest.jar.JarResponse;
import com.psodex.rest.jar.JarService;
import com.psodex.rest.transaction.Transaction;
import com.psodex.rest.transaction.TransactionBuilder;
import com.psodex.rest.transaction.TransactionService;
import com.psodex.rest.transaction.TransactionType;

@Controller
public class TransactionWebController {

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountService accountService;

	@Autowired
	JarService jarService;

	@RequestMapping(value = "/add-transaction", method = RequestMethod.GET)
	public String addTransaction(HttpServletRequest request) {
		request.setAttribute("activeSideBar", "add-transaction");
		request.setAttribute("accounts", processAccountResponse(accountService.findAll(true)));
		request.setAttribute("jars", processJarResponse(jarService.findAll(true)));
		return "addTransaction";
	}

	@RequestMapping(value = "/post-transaction", method = { RequestMethod.POST })
	public String postTransaction(HttpServletRequest request) {
		transactionService.save(preProcess(request), true);
		return "redirect:/dashboard";
	}

	private Transaction preProcess(HttpServletRequest transactionRequest) {
		Account inboundAccount = ObjectUtils.isEmpty(transactionRequest.getParameter("inboundAccountId")) ? null
				: new Account(Integer.parseInt(transactionRequest.getParameter("inboundAccountId")));
		Account outboundAccount = ObjectUtils.isEmpty(transactionRequest.getParameter("outboundAccountId")) ? null
				: new Account(Integer.parseInt(transactionRequest.getParameter("outboundAccountId")));
		Jar jar = ObjectUtils.isEmpty(transactionRequest.getParameter("jarId")) ? null
				: new Jar(Integer.parseInt(transactionRequest.getParameter("jarId")));
		return new TransactionBuilder()
				.type(TransactionType.valueOf(transactionRequest.getParameter("transactionType").toUpperCase()))
				.details(transactionRequest.getParameter("transactionDescription"))
				.amount(new BigDecimal(transactionRequest.getParameter("transactionAmount")))
				.date(LocalDate.parse(transactionRequest.getParameter("transactionDate")))
				.inboundAccount(inboundAccount).outboundAccount(outboundAccount).jar(jar).build();
	}

	public List<AccountResponse> processAccountResponse(List<Account> accounts) {
		if (accounts == null)
			return null;
		return accounts.stream()
				.map(account -> new AccountResponse(String.valueOf(account.getId()), account.getAccountNumber(),
						account.getName(), account.getBalance(), account.getDescription(), account.getIssuingBank()))
				.collect(Collectors.toList());
	}

	private List<JarResponse> processJarResponse(List<Jar> jars) {
		if (jars == null)
			return null;
		return jars.stream()
				.map(jar -> new JarResponse(String.valueOf(jar.getId()), jar.getName(), jar.getDescription(),
						String.valueOf(jar.getPercentage()), jar.getAvailableBalance(),
						jar.getDateCreated().toString()))
				.collect(Collectors.toList());
	}

}
