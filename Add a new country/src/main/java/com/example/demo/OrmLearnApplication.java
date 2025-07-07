package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import com.example.demo.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testAddCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");

        Country country = new Country("XY", "Xyland");

        countryService.addCountry(country);

        try {
            Country retrieved = countryService.findCountryByCode("XY");
            LOGGER.debug("Retrieved Country: {}", retrieved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }

        LOGGER.info("End testAddCountry");
    }
}
