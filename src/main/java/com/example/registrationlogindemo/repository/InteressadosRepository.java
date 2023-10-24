package com.example.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registrationlogindemo.entity.Interessados;


public interface InteressadosRepository  extends JpaRepository<Interessados, Long>{
    
}
