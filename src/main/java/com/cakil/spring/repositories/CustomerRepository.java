package com.cakil.spring.repositories;

import com.cakil.spring.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer> {
}