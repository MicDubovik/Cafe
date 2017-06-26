package by.coffeeroom.security.repository;

import by.coffeeroom.security.model.Coffee;
import by.coffeeroom.security.model.Configuration;
import by.coffeeroom.security.model.Role;
import by.coffeeroom.security.model.User;
import by.coffeeroom.security.service.CoffeeService;
import by.coffeeroom.security.service.ConfigureService;
import by.coffeeroom.security.service.RoleService;
import by.coffeeroom.security.service.UserService;
import by.coffeeroom.security.service.impl.CoffeeServiceImpl;
import by.coffeeroom.security.service.impl.ConfigureServiceImpl;
import by.coffeeroom.security.service.impl.RoleServiceImpl;
import by.coffeeroom.security.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for fill tables.
 */
@Component
public class FillTable implements CommandLineRunner {
    /**
     * UserService.
     */
    UserService userService;
    /**
     * RoleService.
     */
    RoleService roleService;
    /**
     * ConfigureService.
     */
    ConfigureService configureService;
    /**
     * CoffeeService.
     */
    CoffeeService coffeeService;

    /**
     * Constructor.
     * @param userService
     * @param roleService
     * @param configureService
     * @param coffeeService
     */
    @Autowired
    public FillTable(UserServiceImpl userService, RoleServiceImpl roleService,
                     ConfigureServiceImpl configureService, CoffeeServiceImpl coffeeService) {
        this.userService = userService;
        this.roleService = roleService;
        this.configureService = configureService;
        this.coffeeService = coffeeService;
    }

    /**
     * Fill tables default values.
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {

        Role role = new Role("ADMIN");
        Role role2 = new Role("USER");
        Set<Role> roles1 = new HashSet<>();
        Set<Role> roles2 = new HashSet<>();

        roles1.add(role);
        roles1.add(role2);
        roles2.add(role2);

        List<User> users = userService.getAll();
        if (users.size()==0){
            userService.addUser(new User("michyy","000000","michyy@mail.ru",true));
            userService.addUser(new User("vano","vano01","vano@mail.ru",true));
            roleService.addRole(new Role("ROLE_ADMIN",new User("michyy","0101","michyy@mail.ru",true)));
            roleService.addRole(new Role("ROLE_USER",new User("michyy","0101","michyy@mail.ru",true)));
            roleService.addRole(new Role("ROLE_USER",new User("vano","vano","vano@mail.ru",true)));
            configureService.addConfiguration(new Configuration(5,200,50));
            coffeeService.addCoffee(new Coffee("Amaretto","Амаретто",true,15));
            coffeeService.addCoffee(new Coffee("Cappuccino","Каппучино",true,25));
            coffeeService.addCoffee(new Coffee("Latte","Латте",true,20));
            coffeeService.addCoffee(new Coffee("Americano","Американо",false,23));

        }
    }
}
