package com.capgemini.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.daoservices.customerdaoservices;
import com.capgemini.exceptions.InputInvalidException;
import com.capgemini.exceptions.InsufficientBalanceException;

@Component(value = "WalletServices")
public class WalletServiceImpl implements WalletService {

	@Autowired
	private customerdaoservices daoservices;

	
	@Override
	public Customer acceptCustomerDetails(Customer customer) {
		return daoservices.save(customer);
	}

	
	@Override
	 public Customer withdraw(String mobileNo, BigDecimal amount) throws InputInvalidException, InsufficientBalanceException {
		Customer customer = daoservices.findOne(mobileNo);
		System.out.println(customer);
		System.out.println(customer.getWallet().getBalance().compareTo(amount));
		if(customer.getWallet().getBalance().compareTo(amount)!=1)throw new InsufficientBalanceException("Not enough Balance");
		else {
			BigDecimal newBal=customer.getWallet().getBalance().subtract(amount);
			Wallet newWallet=new Wallet(newBal);
			customer.setWallet(newWallet);
			daoservices.save(customer);
		}
		return customer;
	}

	
	@Override
	public Customer deposit(String mobileNo, BigDecimal amount) {
		Customer customer = daoservices.findOne(mobileNo);
		BigDecimal newBal = customer.getWallet().getBalance().add(amount);
		Wallet newWallet = new Wallet(newBal);
		customer.setWallet(newWallet);
		daoservices.save(customer);
	
	return customer;

	}


	
	@Override
	public Customer getCustomerDetails(String mobileNo) throws InputInvalidException {
		Customer customer = daoservices.findOne(mobileNo);
		if (customer == null) {
			throw new InputInvalidException("Mobile number does not exist");
		}
		return customer;
	}

	
	public ArrayList<Customer> getAllCustomerDetails() {
		return (ArrayList<Customer>) daoservices.findAll();
	}

	
}
