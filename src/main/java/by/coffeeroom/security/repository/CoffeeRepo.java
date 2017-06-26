package by.coffeeroom.security.repository;


import by.coffeeroom.security.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository Coffe.
 */
public interface CoffeeRepo extends JpaRepository<Coffee, Integer> {
    /**
     * List all coffee.
     * @return
     */
    List<Coffee> findAll();
}
