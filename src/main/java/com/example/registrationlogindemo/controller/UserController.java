package com.example.registrationlogindemo.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * @return
     
    @GetMapping("/listar")
    public List <User> listarUsuarios(){
        return UserRepository.findAll();
    }*/
    
    @PutMapping("/editar/{id}")
    public User editaUser(@PathVariable Long id, @RequestBody User novoUser){
        return userRepository.findById(id).map(user ->{
            user.setName(novoUser.getName());
            user.setEmail(novoUser.getEmail());
            user.setPassword(novoUser.getPassword());
            return userRepository.save(user);
        })
        .orElseGet(() ->{
            throw new EntityNotFoundException();
        });
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
