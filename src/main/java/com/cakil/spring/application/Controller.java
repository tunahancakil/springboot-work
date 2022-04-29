package com.cakil.spring.application;

import com.cakil.spring.domain.Credit;
import com.cakil.spring.domain.Customer;
import com.cakil.spring.application.service.CreditService;
import com.cakil.spring.application.service.CustomerService;
import com.cakil.spring.application.service.impl.CreditResultDTOService;
import com.cakil.spring.interfaces.model.CreditDTO;
import com.cakil.spring.interfaces.model.CreditResultDTO;
import com.cakil.spring.interfaces.util.Enum;
import com.cakil.spring.interfaces.util.Enum.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controller extends BaseController {

	@Autowired
	private CreditService creditService;

	@Autowired
	private CreditResultDTOService creditResultDTOService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/processGetScore")
	public ResponseEntity<Object> processGetScore(@RequestBody CreditDTO creditDTO) {
		Customer customer = new Customer(creditDTO.getName(), creditDTO.getSurname(), creditDTO.getIdentityNo(), creditDTO.getIncome(), creditDTO.getPhone());
		customerService.save(customer);
		Integer score = creditService.getScore(customer.getIdentityNo());
		Integer creditLimit = creditService.calculateCreditLimit(score, customer.getIncome());
		ApplicationStatus status = ApplicationStatus.valueOf(creditService.getStatus(customer.getIdentityNo(),customer.getIncome()));
		Credit credit = new Credit(score, status, creditLimit, customer);
		customer.addCredit(credit);
		customerService.save(customer);
		creditService.sendSMS(credit);
		CreditResultDTO creditResultDTO = creditResultDTOService.buildCreditResultDTO(customer.getIdentityNo(), credit.getStatus().getMessage(), credit.getCreditLimit());
		return buildOKResponseEntity(creditResultDTO);
	}
}
