-- Create country table
CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(100) NOT NULL
);

-- Sample data
INSERT INTO country (co_code, co_name) VALUES ('BV', 'Bouvet Island');
INSERT INTO country (co_code, co_name) VALUES ('DJ', 'Djibouti');
INSERT INTO country (co_code, co_name) VALUES ('GP', 'Guadeloupe');
INSERT INTO country (co_code, co_name) VALUES ('GS', 'South Georgia and the South Sandwich Islands');
INSERT INTO country (co_code, co_name) VALUES ('LU', 'Luxembourg');
INSERT INTO country (co_code, co_name) VALUES ('SS', 'South Sudan');
INSERT INTO country (co_code, co_name) VALUES ('TF', 'French Southern Territories');
INSERT INTO country (co_code, co_name) VALUES ('UM', 'United States Minor Outlying Islands');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');
