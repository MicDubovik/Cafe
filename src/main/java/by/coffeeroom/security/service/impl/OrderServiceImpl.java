package by.coffeeroom.security.service.impl;

import by.coffeeroom.security.model.Order;
import by.coffeeroom.security.repository.OrderRepo;
import by.coffeeroom.security.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation OrderService.
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * Order repository.
     */
    @Autowired
    private OrderRepo orderRepo;

    /**
     * Add order.
     * @param order
     * @return
     */
    @Override
    public Order addOrder(Order order) {
        return orderRepo.saveAndFlush(order);
    }

    /**
     * Delete order.
     * @param id
     */
    @Override
    public void delete(Long id) {
        delete(id);
    }

    /**
     * Edit order.
     * @param order
     * @return
     */
    @Override
    public Order editOrder(Order order) {
        return orderRepo.saveAndFlush(order);
    }

    /**
     * Get list orders.
     * @return
     */
    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }
}
