package com.projetoadocao.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoadocao.entities.Administradores;
import com.projetoadocao.repositories.AdminRepository;

//@RestController
@Controller
@RequestMapping("/adm/users")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    private AdminController(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @GetMapping("/teste")
    public String teste(){
        return "CadastroAnimais";
    }
    @PostMapping("/adicionar")
    public Administradores adicionarAdm(@RequestBody Administradores admin){
        return adminRepository.save(admin);
    }

    @PutMapping("/editar/{id}")
    public Administradores editarAdmin(@PathVariable Long id, @RequestBody Administradores novoAdmin){
        return adminRepository.findById(id).map(admin -> {
            admin.setLogin(novoAdmin.getLogin());
            admin.setSenha(novoAdmin.getSenha());
            return adminRepository.save(admin);
            
           
        })
        .orElseGet(() ->{
            novoAdmin.setId(id);
            return adminRepository.save(novoAdmin);
        });
    }

    @GetMapping("/listar")
    public List<Administradores> listarAdmin(){
        return adminRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Administradores> buscarAdmin(@PathVariable Long id){
        return adminRepository.findById(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirAdmin(@PathVariable Long id){
        adminRepository.deleteById(id);
        
    }    
}
