package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users") // nome da tabela no banco
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar id automatico, serial do postgres, sequencial unico
    private Long id;

    @Column(nullable=false) // obrigatorio
    private String name;

    @Column(nullable=false, unique=true) // unico
    private String email;

    @Column(nullable=false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles", // nome da tabela 
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")}, // as tabelas
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

}
