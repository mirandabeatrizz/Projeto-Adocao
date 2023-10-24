package com.projetoadocao.security;


import com.projetoadocao.entities.Role;
import com.projetoadocao.entities.Administradores;
import com.projetoadocao.repositories.AdminRepository;

import org.hibernate.mapping.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomAdmDetailsService  implements UserDetailsService{

    private AdminRepository adminRepository;

    public CustomAdmDetailsService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;

    }
    @Override
     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Administradores adm = adminRepository.findByEmail(email);

        if (adm != null) {
            return new org.springframework.security.core.userdetails.User(adm.getEmail(),
                    adm.getSenha(),
                    mapRolesToAuthorities(adm.getRoles()));
        }else{
            throw new UsernameNotFoundException("Usuário ou senha inválidos.");
        }
    }
     private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
