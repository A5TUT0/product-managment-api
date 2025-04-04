-- Creates user table
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Creates user roles table (N:M relationship simplified as N:1)
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    roles VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- Creates category table
CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Creates product table
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Inserts categories
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');

-- Inserts products
INSERT INTO product (id, name, description, price, category_id) VALUES
(1, 'Smartphone', 'Latest model with OLED display', 799.99, 1),
(2, 'Spring Boot Book', 'Guide to Spring Boot 3', 39.99, 2);

-- Inserts users
INSERT INTO user (id, username, password) VALUES
(1, 'user', '$2a$12$7goGRF2AkiIR0.NlbNKL1egkp9RTa6tPHklA6p/DmaWZbx9xJ7f5q'),
(2, 'admin', '$2a$12$7vs6nCnQziNELxVj/vP/cuN3UDJSo7V9Oi18j3wRDO4kRnhw2DBiu');

-- Assigns roles
INSERT INTO user_roles (user_id, roles) VALUES
(1, 'USER'),
(2, 'USER'),
(2, 'ADMIN');
