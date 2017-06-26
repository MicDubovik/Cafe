package by.coffeeroom.security.model;


import by.coffeeroom.security.service.CoffeeService;
import by.coffeeroom.security.service.ConfigureService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Calculation order.
 */
public class Calculation {
    /**
     * CoffeeService entity.
     */
    CoffeeService coffeeService;
    /**
     * ConfigureService entity.
     */
    ConfigureService configureService;
    /**
     * Locale entity.
     */
    Locale locale;
    /**
     * Address field
     */
    private String address;
    /**
     * Delivery is free or not field.
     */
    private boolean delivery;
    /**
     *  List Coffee for calculation.
     */
    List<Coffee> coffeeList;
    /**
     * Configuration .Keep entity for calculation.
     */
    Configuration configuration;

    /**
     * Constructor.
     */
    public Calculation() {
    }

    /**
     * Constructor.
     * @param coffeeService
     * @param configureServiceo
     * @param locale
     */
    public Calculation(CoffeeService coffeeService, ConfigureService configureServiceo, Locale locale) {
        this.coffeeService = coffeeService;
        this.configureService = configureServiceo;
        this.locale = locale;
        this.coffeeList = new ArrayList<>();
    }

    /**
     * Получение списка доступных на складе сортов кофе.
     */
    public List<Coffee> getCoffe() {
        List<Coffee> getCoffeeList = new ArrayList<>();

        for (Coffee coffee : coffeeService.getAll()) {
            if (coffee.isExist()) {
                if (locale.getLanguage().equals("en")) {
                    this.coffeeList.add(new Coffee(coffee.isExist(), coffee.getCost(), coffee.getName_en()));
                    getCoffeeList.add(new Coffee(coffee.isExist(), coffee.getCost(), coffee.getName_en()));
                } else if (locale.getLanguage().equals("ru")) {
                    this.coffeeList.add(new Coffee(coffee.isExist(), coffee.getCost(), coffee.getName_ru()));
                    getCoffeeList.add(new Coffee(coffee.isExist(), coffee.getCost(), coffee.getName_en()));
                }

            }
        }
        return getCoffeeList;
    }

    /**
     * Получение крнфигурационных данных из базы ,для расчета
     * стоимости.
     *
     * @return
     */
    public Configuration getConfiguration() {
        Configuration config = null;
        this.configuration = configureService.getAll().get(0);
        config = configureService.getAll().get(0);
        return config;

    }

    /**
     * Расчет стоимости заказа.
     *
     * @return
     */
    public int result(List<Coffee> list, Configuration config) {

        int result = 0;
        int fullResult = 0;


        for (Coffee coffee : list) {
            result += (coffee.getCount() - (coffee.getCount()) / config.getnCups()) * coffee.getCost();
        }

        if (result >= config.getxFreeDelivery()) {
            fullResult = result;
            this.delivery = false;
        } else {
            fullResult = result + config.getmCostDelivery();
            this.delivery = true;
        }

        return fullResult;
    }

    /**
     * Get delivery.
     * @return
     */
    public boolean isDelivery() {
        return delivery;
    }

    /**
     * Set delivery.
     * @param delivery
     */
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    /**
     * Get address.
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get list coffee.
     * @return
     */
    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    /**
     * Set list coffee.
     * @param coffeeList
     */
    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    /**
     * Set configuration
     * @param configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}