package bg.distilery.repositories;

import bg.distilery.models.user.UserRole;
import bg.distilery.models.user.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(UserRoleEnum user);

    boolean existsByName(UserRoleEnum role);
}
