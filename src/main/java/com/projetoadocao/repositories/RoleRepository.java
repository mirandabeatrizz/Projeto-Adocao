package main.java.com.projetoadocao.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import main.java.com.projetoadocao.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
    
}
