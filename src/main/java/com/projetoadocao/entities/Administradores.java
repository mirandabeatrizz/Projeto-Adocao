package com.projetoadocao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="admin")
public class Administradores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String email; 

    @Column(nullable = false)
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
        name="adms_roles", // nome da tabela 
        joinColumns={@JoinColumn(name="ADMIN_ID", referencedColumnName="ID")}, // as tabelas
        inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})

    private List<Role> roles = new ArrayList<>();
    
}
