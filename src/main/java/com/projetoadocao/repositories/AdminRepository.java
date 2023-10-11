package com.projetoadocao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoadocao.entities.Administradores;

public interface AdminRepository extends JpaRepository<Administradores, Long>{
    
}
