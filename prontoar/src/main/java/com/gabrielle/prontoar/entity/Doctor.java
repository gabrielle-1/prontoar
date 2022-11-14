package com.gabrielle.prontoar.entity;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name = "api_doctor")
public class Doctor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String crm;

    public Doctor() {
    }

    public Doctor(String name, String email, String phoneNumber, int age, String address, char gender, Long id,
            String crm) {
        super(name, email, phoneNumber, age, address, gender);
        this.id = id;
        this.crm = crm;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

}
