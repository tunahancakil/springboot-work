package com.cakil.spring.application.service;

import com.cakil.spring.application.service.impl.CreditServiceImpl;
import com.cakil.spring.domain.Credit;
import com.cakil.spring.domain.exceptions.DatabaseGeneralException;
import com.cakil.spring.domain.exceptions.SmsException;
import com.cakil.spring.interfaces.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CreditServiceImplUnitTest {

    @Mock
    CreditServiceImpl creditService;

    @Test
    public void shouldReturnCreditLimitIsHigh() {
        Integer limit = creditService.calculateCreditLimit(1000,15000);

        assertThat(limit,is(60000));
    }

    @Test
    public void shouldReturnCreditLimitIsZero() {
        Integer limit = creditService.calculateCreditLimit(100000,0);

        assertThat(limit,is(0));
    }

    @Test
    public void shouldReturnCreditLimitIsTenThousand() {
        Integer limit = creditService.calculateCreditLimit(750,3000);

        assertThat(limit,is(10000));
    }
}