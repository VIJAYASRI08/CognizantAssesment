package com.example.demo;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryService;
import com.example.demo.service.exception.CountryNotFoundException;
import com.example.demo.repository.CountryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    private static CountryRepository countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        countryService = context.getBean(CountryRepository.class);

        // Run test method
        testFindCountryByCode();
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start");

        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }

        LOGGER.info("End");
    }

}

