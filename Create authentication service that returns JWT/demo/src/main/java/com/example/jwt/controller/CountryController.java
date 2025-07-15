package com.example.jwt.controller;

import com.example.jwt.model.Country;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountry() {
        Country country = new Country();
        country.setCode("IN");
        country.setName("India");
        return country;
    }
}
