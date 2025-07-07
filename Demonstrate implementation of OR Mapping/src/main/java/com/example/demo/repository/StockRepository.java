package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    // Facebook in September 2019
    List<Stock> findByCodeAndDateBetweenOrderByDateAsc(
        String code, LocalDate start, LocalDate end);
    
    // Google where close > 1250
    List<Stock> findByCodeAndCloseGreaterThan(
        String code, BigDecimal closingValue);
    
    // Top 3 by highest volume
    List<Stock> findTop3ByOrderByVolumeDesc();
    
    // Lowest 3 Netflix
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
