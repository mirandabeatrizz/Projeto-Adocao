package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

  
    @GetMapping("/listaInteressados")
    public String adicionarinteresse(){
        return "listaInteressados";
    }
    @GetMapping("/cadastroAnimais")
    public String addAnimais(){
        return"cadastroAnimais";
    }
    @GetMapping("/todosAnimais")
    public String todosAnimais(){
        return"todosAnimais";
    }
     @GetMapping("/infoAnimal")
    public String infoAnimal(){
        return"infoAnimal";
    }
       @GetMapping("/teste")
    public String teste(){
        return"teste";
    }
    
  
    
  


    
}
