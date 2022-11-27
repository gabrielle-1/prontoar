package com.gabrielle.prontoar.service;

import org.springframework.stereotype.Service;

import com.gabrielle.prontoar.entity.Admin;

@Service
public class AdminService {

    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public boolean validate(Admin admin) {
        Boolean validPassword = admin.getPassword().equals(PASSWORD);
        Boolean validUser = admin.getUser().equals(USER);

        if (validPassword && validUser)
            return true;
        
        return false;
    }

}
