-- Create stock table
CREATE TABLE IF NOT EXISTS stock (
    st_id INT NOT NULL AUTO_INCREMENT,
    st_code VARCHAR(10), 
    st_date DATE,
    st_open DECIMAL(10,2),
    st_close DECIMAL(10,2), 
    st_volume BIGINT,
    PRIMARY KEY (st_id)
);

-- Sample data: Facebook (September 2019)
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-03', 184.00, 182.39, 9779400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-04', 184.65, 187.14, 11308000);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-05', 188.53, 190.90, 13876700);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-06', 190.21, 187.49, 15226800);

-- Sample data: Google stock > 1250
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-22', 1236.67, 1253.76, 954200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-24', 1270.59, 1260.05, 1169800);

-- Top 3 highest volume
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-01-31', 165.60, 166.69, 77233600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2018-10-31', 155.00, 151.79, 60101300);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2018-12-19', 141.21, 133.24, 57404900);

-- Netflix lowest
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-24', 242.00, 233.88, 9547600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-21', 263.83, 246.39, 21397600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-26', 233.92, 253.67, 14402700);
