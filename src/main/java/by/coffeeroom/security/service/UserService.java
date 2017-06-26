package by.coffeeroom.security.service;

import by.coffeeroom.security.model.User;

import java.util.List;

/**
 * UserService interface.
 */
public interface UserService {
    /**
     * Add user.
     *
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * Delete user.
     *
     * @param name
     */
    void delete(String name);

    /**
     * Get user by name.
     *
     * @param name
     * @return
     */
    User getByName(String name);

    /**
     * Edit user.
     *
     * @param user
     * @return
     */
    User editUser(User user);

    /**
     * Get users list.
     * @return
     */
    List<User> getAll();
}
