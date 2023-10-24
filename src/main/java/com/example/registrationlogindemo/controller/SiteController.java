package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

  
    @GetMapping("/interesse")
    public String adicionarinteresse(){
        return "FormInteressados";
    }
    @GetMapping("/CadastroAnimais")
    public String addAnimais(){
        return"CadastroAnimais";
    }


    
}
