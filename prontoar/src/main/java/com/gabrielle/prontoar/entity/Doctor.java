package com.gabrielle.prontoar.entity;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name = "api_doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String crm;

    @Column(nullable = false)
    private String name;

    private int age;

    private char gender;

    private String phoneNumber;

    private String address;

    public Doctor(String crm, String name, int age, char gender, String phoneNumber, String address) {
        this.crm = crm;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
