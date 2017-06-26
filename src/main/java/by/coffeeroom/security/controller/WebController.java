package by.coffeeroom.security.controller;

import by.coffeeroom.security.model.*;
import by.coffeeroom.security.service.*;
import by.coffeeroom.security.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class WebController {
    /**
     * OrderService entity.
     */
    OrderService orderService;
    /**
     * UserService entity
     */
    UserService userService;
    /**
     * RoleService entity.
     */
    RoleService roleService;
    /**
     * CoffeeService entity.
     */
    CoffeeService coffeeService;
    /**
     * ConfigureService entity.
     */
    ConfigureService configureService;
    /**
     * MessageSource entity.
     */
    MessageSource messageSource;
    /**
     * Configuration temp entity.
     */
    Configuration config;
    /**
     * List<Coffee> temp entity.
     */
    List<Coffee> orderCoffeeList;
    /**
     * Temp field for keep full price.
     */
    private int sum;
    /**
     * Boolean field for keep and check delivery.
     */
    private boolean delivery;

    /**
     * Constructor.
     * @param orderService
     * @param userService
     * @param roleService
     * @param coffeeService
     * @param configureService
     * @param messageSource
     */
    @Autowired
    public WebController(OrderServiceImpl orderService, UserServiceImpl userService,
                         RoleServiceImpl roleService, CoffeeServiceImpl coffeeService,
                         ConfigureServiceImpl configureService, MessageSource messageSource) {
        this.orderService = orderService;
        this.userService = userService;
        this.roleService = roleService;
        this.coffeeService = coffeeService;
        this.configureService = configureService;
        this.messageSource = messageSource;
    }

    /**
     * Mapping home page.
     * @return
     */
    @RequestMapping(value = {"/", "home"})
    public String home() {

        return "home";
    }

    /**
     * Mapping login page.
     * @return
     */
    @RequestMapping(value = {"/login"})
    public String login2() {
        return "index";
    }

    /**
     * Mapping logout page.
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"/logout"})
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);

        }
        String out = "Logged off";
        model.addAttribute("out", out);
        return "home";
    }

    /**
     * Mapping register.
     * @param user
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(@ModelAttribute User user) {
        return "register";
    }


    /**
     * Mapping for register.
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String newUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail(), true);
        userService.addUser(newUser);
        roleService.addRole(new Role("ROLE_USER", newUser));

        return "home";
    }

    /**
     * Mapping for select.
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model, HttpServletRequest request) {

        Locale locale = RequestContextUtils.getLocale(request);

        Calculation calculation = new Calculation(coffeeService, configureService, locale);
        calculation.getCoffe();
        this.config = calculation.getConfiguration();

        model.addAttribute("calculation", calculation);

        return "select";
    }

    /**
     * Mapping for address.
     * @param calc
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = {"/delivery"})
    public String address(@Valid @ModelAttribute Calculation calc, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "select";
        }

        boolean none = true;
        int sumCups = 0;
        for (Coffee coffee : calc.getCoffeeList()) {
            if (coffee.isSelected()) {
                sumCups += coffee.getCount();
            }

        }
        if (sumCups == 0) {
            model.addAttribute("none", none);
            return "select";
        }

        this.sum = calc.result(calc.getCoffeeList(), this.config);

        this.delivery = calc.isDelivery();

        this.orderCoffeeList = new ArrayList<>();

        for (Coffee coffee : calc.getCoffeeList()) {
            if (coffee.getCount() > 0 && coffee.isSelected()) {
                this.orderCoffeeList.add(coffee);
            }
        }

        Order order = new Order();

        model.addAttribute("order", order);

        return "address";
    }


    /**
     * Mapping for result.
     * @param order
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@Valid @ModelAttribute Order order, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "address";
        }
        String name = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            name = ((UserDetails) principal).getUsername();
        } else {
            name = principal.toString();
        }
        User user = userService.getByName(name);

        Order fullOrder = new Order(order.getAddress(), this.sum, this.orderCoffeeList, user);

        orderService.addOrder(fullOrder);

        model.addAttribute("list", this.orderCoffeeList);
        model.addAttribute("costDelivery", this.config.getmCostDelivery());
        model.addAttribute("delivery", this.delivery);
        model.addAttribute("sum", this.sum);
        model.addAttribute("order", fullOrder);
        return "result";
    }


}