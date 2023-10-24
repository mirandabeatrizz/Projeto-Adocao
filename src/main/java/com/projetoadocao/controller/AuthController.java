package com.projetoadocao.controller;

import javax.naming.Binding;

import org.springframework.web.bind.annotation.RestController;

import com.projetoadocao.dto.AdmDto;
import com.projetoadocao.entities.Administradores;
import com.projetoadocao.service.AdminService;

@RestController
public class AuthController {
    
    private AdminService adminService;
    public AuthController(AdminService adminService){
        this.adminService = adminService;
    }
    @GetMapping("/cadastro")
    public String FormularioCadastro(Model model){
        AdmDto adm = new AdmDto();
        model.addAttribute("adm", adm);
    }
    @PostMapping("/addCad")
    public String cadastro(@Valid @ModelAttribute("adm") AdmDto adm,
                            BindingResult result,
                            Model model){
            Administradores existing = adminService.findByEmail(adm.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "Ja existe alguem com este email");
            }
            if (result.hasErros()){
                model.addAttribute("adm", adm);
            }
            adminService.saveAdm(adm);
            }
    @GetMapping("/adms")
    public String listaAdms(Model model){
        List<AdmDto> adms = adminService.findAllAdms();
        model.addAttribute("adms", adms);
    }
    
}
