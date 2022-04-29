package com.cakil.spring.interfaces.repositories;

import com.cakil.spring.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer> {
}