package com.projetoadocao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("")
    public String adicionarAnimais(){
        return "CadastroAnimais";
    }
    @GetMapping("/interesse")
    public String adicionarinteresse(){
        return "FormInteressados";
    }
    
}
