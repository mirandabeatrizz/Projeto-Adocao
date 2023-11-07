package com.example.registrationlogindemo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registrationlogindemo.entity.Animais;
import com.example.registrationlogindemo.entity.Interessados;
import com.example.registrationlogindemo.repository.InteressadosRepository;
import com.example.registrationlogindemo.repository.AnimaisRepository;

@RestController
@RequestMapping("/interesse")
public class InteressadosController {
    @Autowired
    private InteressadosRepository interessadosRepository;
     @Autowired
    private AnimaisRepository animaisRepository;

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
    @GetMapping("/exibirAnimais/{id}")
    public String exibirDetalhesAnimal(@PathVariable Long id, Model model) {
    Optional<Animais> animalOptional = animaisRepository.findById(id);
    if (animalOptional.isPresent()) {
        Animais animal = animalOptional.get();
        model.addAttribute("animal", animal);
        return "DetalhesAnimal"; // Nome do template Thymeleaf
    } else {
        // Trate o caso em que o animal não é encontrado (por exemplo, redirecione ou retorne uma mensagem de erro)
        return "animal_nao_encontrado"; // Crie um novo template para esse caso, se necessário
    }
}
    
}
