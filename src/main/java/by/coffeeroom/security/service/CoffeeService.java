package by.coffeeroom.security.service;

import by.coffeeroom.security.model.Coffee;

import java.util.List;

/**
 * CoffeeService interface.
 */
public interface CoffeeService {
    /**
     * Add coffee.
     *
     * @param coffee
     * @return
     */
    Coffee addCoffee(Coffee coffee);

    /**
     * Delete coffee.
     * @param id
     */
    void delete(Integer id);

    /**
     * Edit coffee.
     * @param coffee
     * @return
     */
    Coffee editCoffee(Coffee coffee);

    /**
     * Get list coffee.
     * @return
     */
    List<Coffee> getAll();
}
