package com.projetoadocao.entities;
import java.sql.Date;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="interessados")

public class Interessados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false, length = 100)
    private String telefone;
    
    @Column(nullable = false, length = 100)
    private String cep;
    
    @Column(nullable = false, length = 100)
    private String mensagem;
    
    @ManyToOne
    @JoinColumn(name="animais_id")
    private Animais animais;
}
