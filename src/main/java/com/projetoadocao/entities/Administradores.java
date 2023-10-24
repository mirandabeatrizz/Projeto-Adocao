package com.projetoadocao.entities;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
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

    @ManyToAny(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
        name="adms_roles", // nome da tabela 
        joinColumns={@JoinColumn(name="ADMIN_ID", referencedColumnName="ID")}, // as tabelas
        inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})

        private List<Role> roles = new ArrayList<>();
    
}
