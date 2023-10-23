package main.java.com.projetoadocao.controller;

import main.java.com.projetoadocao.service.AdminService;

@RestController
public class AuthController {
    
    private AdminService adminService;
    public AuthController(AdminService adminService){
        this.adminService = adminService;
    }
    
}
