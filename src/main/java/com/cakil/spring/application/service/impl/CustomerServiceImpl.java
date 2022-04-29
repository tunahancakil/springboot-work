package com.cakil.spring.application.service.impl;

import com.cakil.spring.domain.Customer;
import com.cakil.spring.interfaces.repositories.CustomerRepository;
import com.cakil.spring.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerRepository, Customer> implements CustomerService {

	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
	}

}
