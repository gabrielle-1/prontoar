package com.gabrielle.prontoar.unitary.service;


import com.gabrielle.prontoar.entity.Admin;
import com.gabrielle.prontoar.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)

public class AdminServiceTest {
    
    Admin admin;
    AdminService adminService;
    
    @BeforeEach
    public void setup(){
        this.admin = new Admin();
    }    
    
    @Test
    public void adminTestServiceCreateReturningAdmin(){
        var validate = this.adminService.validate(admin);
        Assertions.assertTrue(validate, "validado com sucesso");
    }
    
     @Test
    public void adminTestServiceCreateReturningAdminNotExist(){
        var validate = this.adminService.validate(admin);
        Assertions.assertFalse(null, "erro");
    }
    
}
