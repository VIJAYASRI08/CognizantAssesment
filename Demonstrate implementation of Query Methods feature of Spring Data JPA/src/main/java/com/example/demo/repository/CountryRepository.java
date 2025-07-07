package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // 1. Contains search
    List<Country> findByNameContainingIgnoreCase(String text);
    
    // 2. Contains search, sorted ascending by name
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);
    
    // 3. Starts with (e.g. 'Z')
    List<Country> findByNameStartingWithIgnoreCase(String prefix);
}
