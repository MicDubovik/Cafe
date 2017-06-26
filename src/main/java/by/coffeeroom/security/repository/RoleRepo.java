package by.coffeeroom.security.repository;

import by.coffeeroom.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Role repository.
 */
public interface RoleRepo extends JpaRepository<Role,Long>{

}
