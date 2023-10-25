package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

  
    @GetMapping("/Interessados")
    public String adicionarinteresse(){
        return "Interessados";
    }
    @GetMapping("/CadastroAnimais")
    public String addAnimais(){
        return"CadastroAnimais";
    }


    
}
