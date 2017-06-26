package by.coffeeroom.security.repository;

import by.coffeeroom.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String username);

}
