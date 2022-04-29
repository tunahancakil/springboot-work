package com.cakil.spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class Customer extends AbstractBaseEntity {

    @Column(name = "IDENTITY_NO")
    private String identityNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "INCOME")
    private Integer income;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Credit> creditList = new ArrayList<>();

    public Customer() {
        super();
    }

    public Customer(String name, String surname, String identityNo, Integer income, String phoneNumber) {
        super();
        this.name = name;
        this.surname = surname;
        this.identityNo = identityNo;
        this.income = income;
        this.phoneNumber = phoneNumber;
    }

    public void addCredit(Credit credit) {
        creditList.add(credit);
    }
}
