package com.projetoadocao.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoadocao.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
    
}
