-- Crea tabla de usuarios
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Crea tabla de roles por usuario (relación N:M simplificada como N:1)
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    roles VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- Crea tabla de categorías
CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Crea tabla de productos
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Inserta categorías
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');

-- Inserta productos
INSERT INTO product (id, name, description, price, category_id) VALUES
(1, 'Smartphone', 'Latest model with OLED display', 799.99, 1),
(2, 'Spring Boot Book', 'Guide to Spring Boot 3', 39.99, 2);

-- Inserta usuarios
INSERT INTO user (id, username, password) VALUES
(1, 'user', '$2a$12$7goGRF2AkiIR0.NlbNKL1egkp9RTa6tPHklA6p/DmaWZbx9xJ7f5q'),
(2, 'admin', '$2a$12$7vs6nCnQziNELxVj/vP/cuN3UDJSo7V9Oi18j3wRDO4kRnhw2DBiu');

-- Asigna roles
INSERT INTO user_roles (user_id, roles) VALUES
(1, 'USER'),
(2, 'USER'),
(2, 'ADMIN');
