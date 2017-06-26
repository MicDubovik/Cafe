package by.coffeeroom.security.service.impl;

import by.coffeeroom.security.model.Coffee;
import by.coffeeroom.security.repository.CoffeeRepo;
import by.coffeeroom.security.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation for CoffeService.
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {
    /**
     * Coffee repository.
     */
    @Autowired
    private CoffeeRepo coffeeRepo;

    /**
     * Add coffee.
     * @param coffee
     * @return
     */
    @Override
    public Coffee addCoffee(Coffee coffee) {
        return coffeeRepo.saveAndFlush(coffee);
    }

    /**
     * Delete coffee.
     * @param id
     */
    @Override
    public void delete(Integer id) {
        coffeeRepo.delete(id);
    }

    /**
     * edit coffee.
     * @param coffee
     * @return
     */
    @Override
    public Coffee editCoffee(Coffee coffee) {
        return coffeeRepo.saveAndFlush(coffee);
    }

    /**
     * Get list all coffee.
     * @return
     */
    @Override
    public List<Coffee> getAll() {
        return coffeeRepo.findAll();
    }
}
