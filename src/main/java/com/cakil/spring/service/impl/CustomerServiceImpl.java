package com.cakil.spring.service.impl;

import com.cakil.spring.domain.Customer;
import com.cakil.spring.repositories.CustomerRepository;
import com.cakil.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerRepository, Customer> implements CustomerService {

	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
	}

}
