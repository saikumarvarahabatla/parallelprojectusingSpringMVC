package com.capgemini.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.beans.Customer;

public interface customerdaoservices extends JpaRepository<Customer, String>{} 