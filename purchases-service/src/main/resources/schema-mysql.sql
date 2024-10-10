USE `purchase-db`;

-- DROP TABLE IF EXISTS customer_phonenumbers;
-- DROP TABLE IF EXISTS delivery;
-- DROP TABLE IF EXISTS customers;
-- DROP TABLE IF EXISTS furniture;
DROP TABLE IF EXISTS purchase;
-- drop table IF EXISTS transport_details;



-- CREATE TABLE IF NOT EXISTS customers (
--     id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     customer_id VARCHAR(36) UNIQUE,
--     customer_first_name VARCHAR(50),
--     customer_last_name VARCHAR(50),
--     email_address VARCHAR(50),
--     street_address VARCHAR(50),
--     city VARCHAR(50),
--     province VARCHAR(50),
--     country VARCHAR(50),
--     postal_code VARCHAR(9)
--     );


-- CREATE TABLE IF NOT EXISTS delivery (
--     id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     delivery_id VARCHAR(36) UNIQUE,
--     first_name VARCHAR(255),
--     last_name VARCHAR(255),
--     address VARCHAR(255),
--     email VARCHAR(255),
--     warehouse_location VARCHAR(255),
--     delivery_date DATE,
--     eta VARCHAR(255),
--     shipping_number VARCHAR(255)
--     );

-- CREATE TABLE IF NOT EXISTS furniture (
--     id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     furniture_id VARCHAR(36) UNIQUE,
--     furniture_name VARCHAR(50),
--     description VARCHAR(255),
--     category VARCHAR(50),
--     furniture_condition VARCHAR(50),
--     country VARCHAR(50),
--     manufacturer_name VARCHAR(50),
--     furniture_cost DOUBLE,
--     currency_type VARCHAR(50)
--     );

-- CREATE TABLE IF NOT EXISTS customer_phonenumbers (
--     customer_id INTEGER,
--     type VARCHAR(50),
--     number VARCHAR(50)
--     );

CREATE TABLE IF NOT EXISTS purchase (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    purchase_id VARCHAR(36),
    delivery_id VARCHAR(36),
    customer_id VARCHAR(36),
    furniture_id VARCHAR(36),
    payment_type VARCHAR(50),
    purchase_date DATE,
    status VARCHAR(50),
    customer_first_name VARCHAR(255),
    customer_last_name VARCHAR(255),
    furniture_name VARCHAR(255),
    furniture_cost DOUBLE,
    currency_type VARCHAR(50),
    furniture_condition VARCHAR(50),
    shipping_number VARCHAR(255),
    warehouse_location VARCHAR(255),
    delivery_date DATE,
    eta VARCHAR(255),
    country VARCHAR(255)
    );
