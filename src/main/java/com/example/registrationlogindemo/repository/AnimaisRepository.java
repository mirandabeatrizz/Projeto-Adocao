package com.example.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registrationlogindemo.entity.Animais;

public interface AnimaisRepository extends JpaRepository<Animais, Long> {
    
}
