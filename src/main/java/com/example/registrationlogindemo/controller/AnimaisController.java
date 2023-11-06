package com.example.registrationlogindemo.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.registrationlogindemo.entity.Animais;
import com.example.registrationlogindemo.entity.Imagens;
import com.example.registrationlogindemo.repository.AnimaisRepository;
import com.example.registrationlogindemo.repository.ImagemRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/animais")
public class AnimaisController {
    @Autowired
    private AnimaisRepository animaisRepository;

    @Autowired
    private ImagemRepository imagensRepository;


    public AnimaisController(AnimaisRepository animaisRepository){
        this.animaisRepository = animaisRepository;
    }
    
    @PostMapping("/adicionar")
    public Animais adicionarAnimais(@RequestBody Animais animais){        
        animais.setFile1(UploadController.getListaImagems().get(0).getCaminho());
        animais.setFile2(UploadController.getListaImagems().get(1).getCaminho());
        animais.setFile3(UploadController.getListaImagems().get(2).getCaminho());
        UploadController.zerarLista();
        return animaisRepository.save(animais);
    }

    @PutMapping("/editar/{id}")
    public Animais editarAnimais(@PathVariable Long id, @RequestBody Animais novoAnimal){
        return animaisRepository.findById(id).map(animais -> {
            animais.setNome(novoAnimal.getNome());
            animais.setTipo(novoAnimal.getTipo());
            animais.setPorte(novoAnimal.getPorte());
            animais.setIdade(novoAnimal.getIdade());
            animais.setCastrado(novoAnimal.getCastrado());
            animais.setVacinado(novoAnimal.getVacinado());
            animais.setDescricao(novoAnimal.getDescricao());
            return animaisRepository.save(animais);
        })
        .orElseGet(() ->{
            novoAnimal.setId(id);
            return animaisRepository.save(novoAnimal);
        });

        
    }

    @GetMapping("/listar")
    public List<Animais> listarAnimais(){
        return animaisRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Animais> buscarAutor(@PathVariable Long id){
        return animaisRepository.findById(id);
        //throw new EntityNotFoundException();
    }

     @DeleteMapping("/excluir/{id}")
    public void excluirAnimais(@PathVariable Long id){
        animaisRepository.deleteById(id);
       // throw new EntityNotFoundException();
    }
    
}
