package com.psodex.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psodex.rest.account.Account;
import com.psodex.rest.transaction.Transaction;
import com.psodex.rest.transaction.TransactionBuilder;
import com.psodex.rest.transaction.TransactionService;
import com.psodex.rest.transaction.TransactionType;

@Controller
public class TransactionWebController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/add-transaction", method = RequestMethod.GET)
	public String addTransaction(HttpServletRequest request) {
		request.setAttribute("activeSideBar", "add-transaction");
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
		// TODO: jar
		return new TransactionBuilder()
				.type(TransactionType.valueOf(transactionRequest.getParameter("transactionType").toUpperCase()))
				.details(transactionRequest.getParameter("transactionDescription"))
				.amount(new BigDecimal(transactionRequest.getParameter("transactionAmount")))
				.date(LocalDate.parse(transactionRequest.getParameter("transactionDate")))
				.inboundAccount(inboundAccount).outboundAccount(outboundAccount).build();
	}

}
