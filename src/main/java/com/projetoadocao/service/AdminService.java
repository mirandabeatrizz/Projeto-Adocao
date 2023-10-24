package com.projetoadocao.service;

import com.projetoadocao.entities.Administradores;

import java.util.List;

import com.projetoadocao.dto.AdmDto;

public interface AdminService{
    void saveAdm(AdmDto admDto);

    Administradores findByEmail(String email);

    List<AdmDto> findAllAdms();
}