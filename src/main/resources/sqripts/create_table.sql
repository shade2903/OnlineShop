<-- TABLE USER-->
CREATE TABLE USERS(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255));


<-- TABLE PRICE LIST-->

CREATE TABLE PRICE_LIST(
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(36) NOT NULL,
price double NOT NULL);

<-- TABLE PRICE LIST-->

CREATE TABLE ORDERS(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT,
total_price DOUBLE NOT NULL,
CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES USERS (ID));

<-- TABLE PRICE_ORDER LIST-->

CREATE TABLE ORDER_PRICE_LIST(
id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT,
good_id INT,
CONSTRAINT order_id FOREIGN KEY (order_id) REFERENCES ORDERS (ID),
CONSTRAINT good_id FOREIGN KEY (good_id) REFERENCES PRICE_LIST (ID));



<--INSERT TABLE PRICE_LIST-->

INSERT INTO PRICE_LIST (TITLE, PRICE)
VALUES ('WHISKEY', 35.0);
INSERT INTO PRICE_LIST (TITLE, PRICE)
VALUES ('COLA', 5.0);
INSERT INTO PRICE_LIST (TITLE, PRICE)
VALUES ('SODA', 6.0);
INSERT INTO PRICE_LIST (TITLE, PRICE)
VALUES ('WATER', 1.0);
INSERT INTO PRICE_LIST (TITLE, PRICE)
VALUES ('GIN', 25.0);
INSERT INTO PRICE_LIST (TITLE, PRICE)
VALUES ('BEER', 10.0);


