CREATE DATABASE IF NOT EXISTS ormlearn;
USE ormlearn;

CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50) NOT NULL
);

INSERT INTO country (co_code, co_name) VALUES 
('IN', 'India'),
('US', 'United States of America'),
('CN', 'China'),
('JP', 'Japan'),
('DE', 'Germany'),
('FR', 'France'),
('BR', 'Brazil'),
('ZA', 'South Africa');

