package com.gabrielle.prontoar.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Entity(name="api_patient")
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCompanion;
    private double weight;
    private double height;
    private String name;
    private String cpf;
    private int age;
    private LocalDate birthDate;
    private char gender;
    private String phoneNumber;
    private String email;
    @Column(nullable = false)
    private String password;

    public Patient() {
    }

    public Patient(String name, String cpf, int age, String birthDate, char gender, String phoneNumber, String email) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.birthDate = LocalDate.parse(birthDate);
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getNameCompanion() {
        return nameCompanion;
    }

    public void setNameCompanion(String nameCompanion) {
        this.nameCompanion = nameCompanion;
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

    public String getPassword() {
        return password;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
