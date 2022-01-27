package com.psodex.transaction;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransactionWebController {

	@RequestMapping(value = "/add-transaction", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		request.setAttribute("activeSideBar", "add-transaction");
		return "addTransaction";
	}
}
