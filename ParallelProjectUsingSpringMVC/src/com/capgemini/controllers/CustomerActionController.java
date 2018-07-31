package com.capgemini.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InputInvalidException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.services.WalletService;

@Controller
public class CustomerActionController {

	@Autowired
	private WalletService walletService;

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public ModelAndView Customer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result){
	try {
		if(result.hasErrors())
			return new ModelAndView("registrationPage");
		else {
		customer = walletService.acceptCustomerDetails(customer);
		return new ModelAndView("registrationsuccesspage", "customer", customer);
	}
	}
	catch(InputInvalidException e)
	{
		e.printStackTrace();
	
	return new ModelAndView("errorPage");
	}
	
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ModelAndView show(@ModelAttribute("customer") Customer customer)throws InputInvalidException {
		try {
			String mobileNo = customer.getMobileNo();
			Customer customer1 = walletService.getCustomerDetails(mobileNo);
			return new ModelAndView("view", "customer1", customer1);

		} catch (InputInvalidException e) {
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}

	@RequestMapping(value = "/withdrawNew", method = RequestMethod.POST)
	public ModelAndView withdraw(@ModelAttribute("customer") Customer customer) throws InsufficientBalanceException, InputInvalidException {
		try {
			String mobileNo = customer.getMobileNo();
			BigDecimal amount = customer.getWallet().getBalance();
			Customer customerNew = walletService.withdraw(mobileNo, amount);
			ModelAndView modelAndView = new ModelAndView("transactionsuccessful", "customerNew", customerNew);
			return modelAndView;

		} catch (InputInvalidException e) {
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}

	@RequestMapping(value = "/depositNew", method = RequestMethod.POST)
	public ModelAndView deposit(@ModelAttribute("customer") Customer customer) throws InputInvalidException {
		String mobileNo = customer.getMobileNo();
		BigDecimal amount = customer.getWallet().getBalance();
		Customer customerNew = walletService.deposit(mobileNo, amount);
		ModelAndView modelAndView = new ModelAndView("transactionsuccessful", "customerNew", customerNew);
		return modelAndView;
		
	}

	@RequestMapping(value = "/transferNew", method = RequestMethod.POST)
	public ModelAndView transfer(@ModelAttribute("customer") Customer customer) throws InsufficientBalanceException, InputInvalidException {
		String mobileNo = customer.getMobileNo();
		String mobileNo2 = customer.getName();
		BigDecimal amount = customer.getWallet().getBalance();
		Customer customerNew = walletService.withdraw(mobileNo, amount);
		Customer customerNew2 = walletService.deposit(mobileNo2, amount);
		ModelAndView modelAndView = new ModelAndView("transactionsuccessful", "customerNew", customerNew);
		return modelAndView;
		
	}

	@RequestMapping(value = "/viewPage", method = RequestMethod.GET)
	public ModelAndView viewCustomer() throws InsufficientBalanceException {
		List<Customer> list = walletService.getAllCustomerDetails();
		ModelAndView modelAndView = new ModelAndView("viewpage", "list", list);
		return modelAndView;

	}
}
