package bg.distilery.init;

import bg.distilery.models.user.UserRole;
import bg.distilery.models.user.enums.UserRoleEnum;
import bg.distilery.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRoles implements CommandLineRunner {
    private final UserRoleRepository roleRepository;

    public InitRoles(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (UserRoleEnum name : UserRoleEnum.values()) {

            if (!roleRepository.existsByName(name)){
                UserRole userRole = new UserRole(name);
                roleRepository.save(userRole);
            }
        }
    }

}
