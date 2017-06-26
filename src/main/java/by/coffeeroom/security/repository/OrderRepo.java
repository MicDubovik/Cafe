package by.coffeeroom.security.repository;

import by.coffeeroom.security.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Order repository.
 */
public interface OrderRepo extends JpaRepository<Order,Integer> {

}
