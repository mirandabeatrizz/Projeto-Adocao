package com.projetoadocao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoadocao.entities.Interessados;

public interface InteressadosRepository  extends JpaRepository<Interessados, Long>{
    
}
