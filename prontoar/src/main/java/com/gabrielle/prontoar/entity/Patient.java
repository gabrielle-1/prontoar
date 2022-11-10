package com.gabrielle.prontoar.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@ToString
@Entity(name = "api_patient")
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private int age;
    private char gender;
    private String phoneNumber;
    private String socialName;
    private String address;
    private double weight;
    private double height;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthDate;

    public Patient() {
    }

    public Patient(String name, LocalDate birthDate, String cpf, int age, char gender, String phoneNumber,
            String socialName, String address, double weight, double height) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.socialName = socialName;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
