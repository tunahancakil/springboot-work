package com.cakil.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditResultDTO {

	private String identityNo;
	private String status;
	private Integer creditLimit;

	public CreditResultDTO() {
		// TODO Auto-generated constructor stub
	}

}
