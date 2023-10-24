package com.projetoadocao.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projetoadocao.dto.AdmDto;
import com.projetoadocao.entities.Administradores;
import com.projetoadocao.entities.Role;
import com.projetoadocao.repositories.AdminRepository;
import com.projetoadocao.repositories.RoleRepository;
import com.projetoadocao.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AdmServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AdmServiceImpl (AdminRepository adminRepository,
                            RoleRepository roleRepository,
                            PasswordEncoder passwordEncoder){
            this.adminRepository = adminRepository;
            this.roleRepository = roleRepository;
            this.passwordEncoder = passwordEncoder;
         }
    
    @Override
    public void saveAdm(AdmDto admDto){
        Administradores adm = new Administradores();
        adm.setNome(admDto.getNome());
        adm.setEmail(admDto.getEmail());
        adm.setSenha(passwordEncoder.encode(admDto.getSenha()));
        
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        adm.setRoles(Arrays.asList(role));
        adminRepository.save(adm);
    }

    @Override
    public Administradores findByEmail(String email){
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<AdmDto> findAllAdms(){
        List<Administradores> adms = adminRepository.findAll();
        return adms.stream().map((adm) -> convertEntityToDto(adm)). collect(Collectors.toList());   
    }
 
    private AdmDto convertEntityToDto(Administradores adm){
        AdmDto admDto = new AdmDto();
        //String[] nome = adm.getNome().split(" ");
        admDto.setNome(adm.getNome());
        admDto.setEmail(adm.getEmail());
        return admDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    
}
