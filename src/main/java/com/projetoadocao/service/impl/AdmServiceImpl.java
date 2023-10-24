import java.lang.reflect.Array;
import java.util.List;

import com.projetoadocao.dto.AdmDto;
import com.projetoadocao.entities.Administradores;
import com.projetoadocao.entities.Role;
import com.projetoadocao.repositories.AdminRepository;
import com.projetoadocao.repositories.RoleRepository;
import com.projetoadocao.service.AdminService;

@Service
public class AdmServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private PasswordEnconder passwordEncoder;

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
        adm.setNome(admDto.getName());
        adm.setEmail(admDto.getEmail());
        adm.setSenha(passwordEncoder.encode(admDto.getSenha()));
        
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        adm.setRoles(Array.asList(role));
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
        javax.management.relation.Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    
}
