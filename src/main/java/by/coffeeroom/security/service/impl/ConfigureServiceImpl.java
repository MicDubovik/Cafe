package by.coffeeroom.security.service.impl;

import by.coffeeroom.security.model.Configuration;
import by.coffeeroom.security.repository.ConfigureRepo;
import by.coffeeroom.security.service.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation for ConfigureService.
 */
@Service
public class ConfigureServiceImpl implements ConfigureService {
    /**
     * Configuration repository.
     */
    @Autowired
    private ConfigureRepo configureRepo;

    /**
     * Add configuration.
     * @param configuration
     * @return
     */
    @Override
    public Configuration addConfiguration(Configuration configuration) {
        return configureRepo.saveAndFlush(configuration);
    }

    /**
     * Delete configuration
     * @param id
     */
    @Override
    public void delete(Integer id) {
        configureRepo.delete(id);
    }

    /**
     * Edit configuration
     * @param configuration
     * @return
     */
    @Override
    public Configuration editConfiguration(Configuration configuration) {
        return configureRepo.saveAndFlush(configuration);
    }

    /**
     * Get list configuration.
     * @return
     */
    @Override
    public List<Configuration> getAll() {
        return configureRepo.findAll();
    }
}
