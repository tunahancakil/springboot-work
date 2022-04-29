package com.cakil.spring.service;

import com.cakil.spring.domain.Credit;
import com.cakil.spring.exceptions.DatabaseGeneralException;
import com.cakil.spring.exceptions.SmsException;

public interface CreditService extends BaseService<Credit> {

	Integer getScore(String identityNo) throws DatabaseGeneralException;

	Integer calculateCreditLimit(Integer score, Integer income) throws DatabaseGeneralException;

	void sendSMS(Credit credit) throws SmsException;
	
}
