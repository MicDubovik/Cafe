package by.coffeeroom.security.service;

import by.coffeeroom.security.model.Order;

import java.util.List;

/**
 * OrderService interface.
 */
public interface OrderService {
    /**
     * Add order.
     *
     * @param order
     * @return
     */
    Order addOrder(Order order);

    /**
     * Delete order.
     *
     * @param id
     */
    void delete(Long id);

    /**
     * Edit order.
     *
     * @param order
     * @return
     */
    Order editOrder(Order order);

    /**
     * Get list orders.
     * @return
     */
    List<Order> getAll();
}
