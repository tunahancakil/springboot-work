package com.cakil.spring.domain;

import com.cakil.spring.interfaces.util.Enum.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "is_deleted=false")
@Getter
@Setter
public class Credit extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "SCORE")
	private Integer score;

	@Column(name = "APPLICATION_STATUS")
	@Enumerated(EnumType.STRING)
	private ApplicationStatus status;

	@Column(name = "CREDIT_LIMIT")
	private Integer creditLimit;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;

	public Credit() {
		super();
	}

	public Credit(Integer score, ApplicationStatus status, Integer creditLimit, Customer customer) {
		super();
		this.score = score;
		this.status = status;
		this.creditLimit = creditLimit;
		this.customer = customer;
	}

}
