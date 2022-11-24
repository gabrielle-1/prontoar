package com.gabrielle.prontoar.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private String user;
    private String password;

    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Admin() {

    }
}
