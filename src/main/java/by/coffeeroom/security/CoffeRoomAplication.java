package by.coffeeroom.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * SpringbootStarter.
 */
@SpringBootApplication
public class CoffeRoomAplication extends WebMvcConfigurerAdapter {
    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CoffeRoomAplication.class, args);
    }

    /**
     * LocaleResolver for configuration locale.
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {


        return new CookieLocaleResolver();
    }

    /**
     * LocaleResolver for configuration locale.
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    /**
     * LocaleResolver for to switch locale.
     *
     * @return
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
