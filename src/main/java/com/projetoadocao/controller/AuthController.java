package com.projetoadocao.controller;

import java.util.List;
import javax.naming.Binding;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoadocao.dto.AdmDto;
import com.projetoadocao.entities.Administradores;
import com.projetoadocao.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
    
    private AdminService adminService;
    public AuthController(AdminService adminService){
        this.adminService = adminService;
    }
    @GetMapping("/cadastro")
    public void FormularioCadastro(Model model){
        AdmDto adm = new AdmDto();
        model.addAttribute("adm", adm);
    }
    @PostMapping("/addCad")
    public void cadastro(@Valid @ModelAttribute("adm") AdmDto adm,
                            BindingResult result,
                            Model model){
            Administradores existing = adminService.findByEmail(adm.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "Ja existe alguem com este email");
            }
            if (result.hasErrors()){
                model.addAttribute("adm", adm);
            }
            adminService.saveAdm(adm);
            }
    @GetMapping("/adms")
    public void listaAdms(Model model){
        List<AdmDto> adms = adminService.findAllAdms();
        model.addAttribute("adms", adms);
    }
    
}
