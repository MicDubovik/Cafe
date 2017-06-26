package by.coffeeroom.security.service.impl;

import by.coffeeroom.security.model.User;
import by.coffeeroom.security.repository.UserRepo;
import by.coffeeroom.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public void delete(String name) {
        delete(name);
    }

    @Override
    public User getByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public User editUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
