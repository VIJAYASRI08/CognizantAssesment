package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.CountryNotFoundException;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Get all countries
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Get a specific country by code
    @Transactional(readOnly = true)
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        return countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country not found with code: " + code));
    }

    // Add a new country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // For testing custom query methods like: findByNameContaining, etc.
    @Transactional(readOnly = true)
    public List<Country> findByNameContaining(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameContainingOrderByNameAsc(String keyword) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(keyword);
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameStartingWith(String prefix) {
        return countryRepository.findByNameStartingWithIgnoreCase(prefix);
    }
}
