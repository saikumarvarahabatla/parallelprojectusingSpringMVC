package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.beans.Customer;

@Controller
public class URIController {
	
	@RequestMapping("/")
	public String getIndexPage() {
		return "IndexPage";
	}
	
	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	
	@RequestMapping("/login")
	public String getLoginPage() {
		return "loginPage";
	}

	@RequestMapping("/withdraw")
	public String getWithdrawPage() {
		return "withdraw";
	}

	@RequestMapping("/deposit")
	public String getDepositPage() {
		return "Deposit";
	}
	
	@RequestMapping("/transfer")
	public String getTransferPage() {
		return "transfer";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
}


