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
VALUES (1, "Staszek", "777888999", "staszek@gmail.com"),
    (2, "Okruszek", "660099111", "okruszek@gmail.com"),
    (3, "Otrebusy", "600600600", "otrebusy@gmail.com");

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
       (3, 4, 1.20, 4, 1),
       (4, 2, 4.00, 2, 2),
       (5, 11, 5.20, 1, 3),
       (6, 5, 1.50, 4, 2);

CREATE TABLE payment(
   id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   status TINYINT(1),
   sum DECIMAL(6,2)
);

INSERT INTO payment(id, status, sum)
VALUES (1, true, 33.50),
       (2, false, 4.80),
       (3, true, 5.30);

CREATE TABLE user(
     id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     first_name VARCHAR(50),
     last_name VARCHAR(100),
     email VARCHAR(100)
);

INSERT INTO user(id, first_name, last_name, email)
VALUES (1, "Zofia", "Hacz", "zofia.hacz@gmail.com"),
       (2, "Adam", "Grzywa", "adam.grzywa@gmail.com"),
       (3, "Aurelia", "Mitura", "aurelia.mitura1@gmail.com");

CREATE TABLE address(
     id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     city VARCHAR(50),
     street VARCHAR(100),
     home_number VARCHAR(50),
     user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT INTO address(id, city, street, home_number, user_id)
VALUES (1, "Warszawa", "Ananasowa", "33/13", 1),
       (2, "Warszawa", "Grzybowska", "23/1", 2),
       (3, "Warszawa", "Plac Unii", "1/12", 3);


CREATE TABLE orders(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_id BIGINT NOT NULL,
    payment_id BIGINT NOT NULL,
    store_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (payment_id) REFERENCES payment(id),
    FOREIGN KEY (store_id) REFERENCES store(id)
);

INSERT INTO orders(id, user_id, payment_id, store_id)
VALUES (1, 1, 1, 1),
       (2, 2, 2, 2),
       (3, 3, 3, 3);

CREATE TABLE delivery(
     id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     date_time DATETIME,
     status TINYINT(1),
     orders_id BIGINT NOT NULL,
     FOREIGN KEY (orders_id) REFERENCES orders(id)
);

INSERT INTO delivery(id, date_time, status, orders_id)
VALUES (1, "2019-11-01T07:30:00", true, 1),
       (2, "2019-11-02T07:30:00", false, 2),
       (3, "2019-11-01T07:00:00", true, 3);

