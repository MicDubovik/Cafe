package by.coffeeroom.security.service;

import by.coffeeroom.security.model.Role;

import java.util.List;

/**
 * RoleService interface.
 */
public interface RoleService {

    /**
     * Add role.
     *
     * @param role
     * @return
     */
    Role addRole(Role role);

    /**
     * Delete role.
     *
     * @param id
     */
    void delete(Long id);

    /**
     * Edit role.
     *
     * @param role
     * @return
     */
    Role editRole(Role role);

    /**
     * Get role.
     * @return
     */
    List<Role> getAll();
}
