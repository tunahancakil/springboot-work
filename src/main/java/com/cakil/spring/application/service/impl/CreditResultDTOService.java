package com.cakil.spring.application.service.impl;

import com.cakil.spring.interfaces.model.CreditResultDTO;
import org.springframework.stereotype.Service;

@Service
public class CreditResultDTOService {

	public CreditResultDTO buildCreditResultDTO(String identityNo, String status, Integer creditLimit) {
		CreditResultDTO creditResultDTO = new CreditResultDTO();
		creditResultDTO.setIdentityNo(identityNo);
		creditResultDTO.setStatus(status);
		creditResultDTO.setCreditLimit(creditLimit);
		return creditResultDTO;
	}

}
