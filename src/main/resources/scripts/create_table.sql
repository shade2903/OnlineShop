
CREATE TABLE USERS(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255));

CREATE TABLE GOODS (
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(36) NOT NULL,
price double NOT NULL);

CREATE TABLE ORDERS(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
total_price DOUBLE NOT NULL,
CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES USERS (ID));

CREATE TABLE ORDERS_GOODS(
id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT,
good_id INT,
CONSTRAINT order_id FOREIGN KEY (order_id) REFERENCES ORDERS (ID),
CONSTRAINT good_id FOREIGN KEY (good_id) REFERENCES GOODS (ID));




