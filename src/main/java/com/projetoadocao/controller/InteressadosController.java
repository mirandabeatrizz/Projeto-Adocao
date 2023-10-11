package com.projetoadocao.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoadocao.entities.Interessados;
import com.projetoadocao.repositories.InteressadosRepository;



@RestController
@RequestMapping("/interesse")
public class InteressadosController {
    @Autowired
    private InteressadosRepository interessadosRepository;

    public InteressadosController(InteressadosRepository interessadosRepository){
        this.interessadosRepository = interessadosRepository;
    }

    @PostMapping("/add")
    public Interessados addInteressados( @RequestBody Interessados interessados){
        return interessadosRepository.save(interessados);
    }

    @GetMapping("/listar")
    public List<Interessados> listarInteressados(){
        return interessadosRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Interessados> buscarInteressados(@PathVariable Long id){
        return interessadosRepository.findById(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirInteressado(@PathVariable Long id){
        interessadosRepository.deleteById(id);
    }
    
}
