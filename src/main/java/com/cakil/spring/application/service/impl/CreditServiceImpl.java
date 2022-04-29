package com.cakil.spring.application.service.impl;

import com.cakil.spring.application.service.CreditService;
import com.cakil.spring.domain.Credit;
import com.cakil.spring.domain.exceptions.DatabaseGeneralException;
import com.cakil.spring.domain.exceptions.SmsException;
import com.cakil.spring.interfaces.repositories.CreditRepository;
import com.cakil.spring.interfaces.util.Constants;
import com.cakil.spring.interfaces.util.Enum.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CreditServiceImpl extends BaseServiceImpl<CreditRepository, Credit> implements CreditService {

	@Autowired
	public CreditServiceImpl(CreditRepository repository) {
		super(repository);
	}

	@Override
	public Integer getScore(String identityNo) throws DatabaseGeneralException {
		Random rand = new Random();
		return rand.nextInt(1500);
	}

	@Override
	public Integer calculateCreditLimit(Integer score, Integer income) throws DatabaseGeneralException {
		try {
			if (score >= 1000) {
				return income * Constants.CREDIT_LIMIT_MULTIPLIER;
			} else if (score >= 500 && score < 1000 && income < 5000) {
				return 10000;
			} else {
				return 0;
			}
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new DatabaseGeneralException(e.getMessage());
		}
	}

	@Override
	public void sendSMS(Credit credit) throws SmsException {
		try {
			System.out.println(" SMS sent to " + credit.getCustomer().getPhoneNumber());
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			throw new SmsException(e.getMessage());
		}
	}

	@Override
	public String getStatus(String identityNo, Integer income) {
		Integer score = getScore(identityNo);
		Integer creditLimit = calculateCreditLimit(score, income);

		if (creditLimit == 0) {
			return ApplicationStatus.REJECTED.toString();
		} else {
			return ApplicationStatus.APPROVE.toString();
		}
	}

}
