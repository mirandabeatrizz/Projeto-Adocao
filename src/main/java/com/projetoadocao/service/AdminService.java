package main.java.com.projetoadocao.service;

import main.java.com.projetoadocao.entities.Administradores;
import main.java.com.projetoadocao.dto.AdmDto;

public interface AdminService{
    void saveAdm(AdmDto admDto);

    Administradores findByEmail(String email);

    List<AdmDto> findAllAdms();
}