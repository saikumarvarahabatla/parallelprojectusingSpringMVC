package com.capgemini.services;

import java.math.BigDecimal;
import java.util.ArrayList;



import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InputInvalidException;
import com.capgemini.exceptions.InsufficientBalanceException;

public interface WalletService {
 Customer acceptCustomerDetails(Customer customer);
 
 Customer withdraw(String mobileNo, BigDecimal amount) throws InputInvalidException, InsufficientBalanceException;
 
 Customer deposit(String mobileNo, BigDecimal amount) ;
 
 Customer getCustomerDetails(String mobileNo) throws InputInvalidException;

 ArrayList<Customer> getAllCustomerDetails();


}
