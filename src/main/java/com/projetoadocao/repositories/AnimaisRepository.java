package com.projetoadocao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoadocao.entities.Animais;

public interface AnimaisRepository extends JpaRepository<Animais, Long> {
    
}
