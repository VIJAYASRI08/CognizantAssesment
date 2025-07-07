package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start: testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(country -> LOGGER.debug("Country: {}", country));
        LOGGER.info("End: testGetAllCountries");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start: testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End: testFindCountryByCode");
    }

    private static void testAddCountry() {
        LOGGER.info("Start: testAddCountry");

        Country country = new Country("XY", "Xylophone Land");
        countryService.addCountry(country);

        try {
            Country retrieved = countryService.findCountryByCode("XY");
            LOGGER.debug("Added Country: {}", retrieved);
        } catch (Exception e) {
            LOGGER.error("Country not found after adding: {}", e.getMessage());
        }

        LOGGER.info("End: testAddCountry");
    }
}
