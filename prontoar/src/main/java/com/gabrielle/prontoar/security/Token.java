package com.gabrielle.prontoar.security;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Token {

    private String token;

    public Token(String token) {
        super();
        this.token = token;
    }
}
