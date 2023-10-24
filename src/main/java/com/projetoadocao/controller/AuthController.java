package com.projetoadocao.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projetoadocao.service.AdminService;

@RestController
public class AuthController {
    
    private AdminService adminService;
    public AuthController(AdminService adminService){
        this.adminService = adminService;
    }
    
}
