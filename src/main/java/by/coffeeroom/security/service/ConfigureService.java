package by.coffeeroom.security.service;

import by.coffeeroom.security.model.Configuration;

import java.util.List;

/**
 * ConfigureService interface.
 */
public interface ConfigureService {
    /**
     * Add configuration.
     *
     * @param configuration
     * @return
     */
    Configuration addConfiguration(Configuration configuration);

    /**
     * Delete configuration.
     * @param id
     */
    void delete(Integer id);

    /**
     * Edit configuration.
     *
     * @param configuration
     * @return
     */
    Configuration editConfiguration(Configuration configuration);

    /**
     * Get list configuration.
     * @return
     */
    List<Configuration> getAll();
}
