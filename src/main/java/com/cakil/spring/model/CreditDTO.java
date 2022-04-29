package com.cakil.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditDTO {

	private String 	identityNo;
	private String 	name;
	private String 	surname;
	private Integer income;
	private String 	phone;

	public CreditDTO() {
		// TODO Auto-generated constructor stub
	}
}
