package com.example.demo.countryservice.service;

import com.example.demo.countryservice.entity.Country;
import com.example.demo.countryservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountryByCode(String coCode) {
        return countryRepository.findById(coCode).orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String coCode, Country updatedCountry) {
        Optional<Country> existing = countryRepository.findById(coCode);
        if (existing.isPresent()) {
            Country country = existing.get();
            country.setCoName(updatedCountry.getCoName());
            return countryRepository.save(country);
        }
        return null;
    }

    public void deleteCountry(String coCode) {
        countryRepository.deleteById(coCode);
    }

    public List<Country> findCountriesByPartialName(String partialName) {
        return countryRepository.findByCoNameContainingIgnoreCase(partialName);
    }
}