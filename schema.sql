DROP DATABASE IF EXISTS db;

CREATE DATABASE db;

USE db;

CREATE TABLE breadstuff_type(
   id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   type VARCHAR(100)
);

INSERT INTO breadstuff_type(id, type)
VALUES (1, "chleb zytni"),
       (2, "drozdzowka"),
       (3, "chleb pszenny"),
       (4, "ciabata"),
       (5, "rozek z budyniem"),
       (6, "kajzerka");

CREATE TABLE store(
   id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   name VARCHAR(100),
   phone_number VARCHAR(20),
   email VARCHAR(100)
);

INSERT INTO store(id, name, phone_number, email)
VALUES (1, "Staszek", "777888999", "staszek@gmail.com");

CREATE TABLE breadstuff(
   id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   amount INTEGER,
   price DECIMAL(6,2),
   type_id BIGINT NOT NULL,
   store_id BIGINT NOT NULL,
   FOREIGN KEY (type_id) REFERENCES breadstuff_type (id),
   FOREIGN KEY (store_id) REFERENCES store (id)
);

INSERT INTO breadstuff(id, amount, price, type_id, store_id)
VALUES (1, 3, 3.20, 2, 1),
       (2, 10, 3.30, 1, 1),
       (3, 4, 1.20, 4, 1);


