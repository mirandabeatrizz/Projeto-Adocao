package com.projetoadocao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="animais")
public class Animais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(nullable = false, length = 100)
    private String porte;

    @Column(nullable = false, length = 100)
    private int idade;

    @Column(nullable = false, length = 100)
    private String foto;

    @Column(nullable = false, length = 100)
    private String castrado;

    @Column(nullable = false, length = 100)
    private String vacinado;

}
