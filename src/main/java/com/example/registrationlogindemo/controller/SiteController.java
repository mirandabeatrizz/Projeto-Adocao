package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

  
    @GetMapping("/ListaInteressados")
    public String adicionarinteresse(){
        return "ListaInteressados";
    }
    @GetMapping("/CadastroAnimais")
    public String addAnimais(){
        return"CadastroAnimais";
    }
    @GetMapping("/DetalhesAnimal")
    public String DetalhesAnimal(){
        return"DetalhesAnimal";
    }
    
  
    
  


    
}
