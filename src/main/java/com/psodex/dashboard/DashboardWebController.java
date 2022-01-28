package com.psodex.dashboard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psodex.rest.account.Account;
import com.psodex.rest.account.AccountResponse;
import com.psodex.rest.account.AccountService;
import com.psodex.rest.jar.Jar;
import com.psodex.rest.jar.JarResponse;
import com.psodex.rest.jar.JarService;
import com.psodex.rest.transaction.Transaction;
import com.psodex.rest.transaction.TransactionResponse;
import com.psodex.rest.transaction.TransactionService;
import com.psodex.rest.user.User;
import com.psodex.rest.user.UserBuilder;
import com.psodex.rest.user.UserService;

@Controller
public class DashboardWebController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionService transactionService;

	@Autowired
	JarService jarService;

	@GetMapping("/")
	public String init() {
		return "login";
	}

	@RequestMapping(value = "/welcome", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(HttpServletRequest request) {
		JSONObject authentication = userService.authenticate(preProcess(request));
		Map<String, Object> tokenMap = authentication.toMap();
		if (!ObjectUtils.isEmpty(tokenMap.get("token"))) {
			return "forward:/dashboard";
		}
		return "login";
	}

	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(HttpServletRequest request) {
		request.setAttribute("accounts", processAccountResponse(accountService.findAll(true)));
		request.setAttribute("transactions", processTransactionResponse(transactionService.findAll(true)));
		request.setAttribute("jars", processJarResponse(jarService.findAll(true)));
		request.setAttribute("activeSideBar", "dashboard");

		return "dashboard";
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
