package by.coffeeroom.security.service.impl;

import by.coffeeroom.security.model.Role;
import by.coffeeroom.security.repository.RoleRepo;
import by.coffeeroom.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation RoleService.
 */
@Service
public class RoleServiceImpl implements RoleService{
    /**
     * Role repository.
     */
    @Autowired
    private RoleRepo roleRepo;

    /**
     * Add role.
     * @param role
     * @return
     */
    @Override
    public Role addRole(Role role) {
        return roleRepo.saveAndFlush(role);
    }

    /**
     * Delete role.
     * @param id
     */
    @Override
    public void delete(Long id) {
        roleRepo.delete(id);
    }

    /**
     * Edit role.
     * @param role
     * @return
     */
    @Override
    public Role editRole(Role role) {
        return roleRepo.saveAndFlush(role);
    }

    /**
     * Get list roles.
     * @return
     */
    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
