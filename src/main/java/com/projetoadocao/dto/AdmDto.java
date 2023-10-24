package com.projetoadocao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class AdmDto{

    private Long id;
    @NotEmpty
    private String nome;
    @Email
    @NotEmpty(message = "Email deve ser informado")
    private String email;
    
    @NotEmpty
    private String senha;
    
}