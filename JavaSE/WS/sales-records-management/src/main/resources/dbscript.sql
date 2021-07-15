DROP DATABASE salesdb;

CREATE DATABASE salesdb;

USE salesdb;

CREATE TABLE sales(
 receipt_No INT PRIMARY KEY,
 item_name VARCHAR(50) NOT NULL,
 area VARCHAR(50) NOT NULL,
 qty INT DEFAULT 0,
 amount DOUBLE DEFAULT 0,
 rate DOUBLE DEFAULT 0,
 receipt_date DATE NOT NULL
);