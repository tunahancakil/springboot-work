package com.cakil.spring.application.service;

import com.cakil.spring.domain.Credit;
import com.cakil.spring.domain.exceptions.DatabaseGeneralException;
import com.cakil.spring.domain.exceptions.SmsException;

public interface CreditService extends BaseService<Credit> {

	Integer getScore(String identityNo) throws DatabaseGeneralException;

	Integer calculateCreditLimit(Integer score, Integer income) throws DatabaseGeneralException;

	void sendSMS(Credit credit) throws SmsException;

	String getStatus(String identityNo, Integer income) throws DatabaseGeneralException;
	
}
