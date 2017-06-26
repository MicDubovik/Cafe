package by.coffeeroom.security.repository;

import by.coffeeroom.security.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Configuration repository .
 */
public interface ConfigureRepo extends JpaRepository<Configuration,Integer> {

   List<Configuration>  findAll();
}
