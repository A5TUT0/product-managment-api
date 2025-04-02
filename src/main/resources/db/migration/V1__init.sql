-- Inserta dos categorías
INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Books');

-- Inserta dos productos
INSERT INTO product (id, name, description, price, category_id) VALUES
(1, 'Smartphone', 'Latest model with OLED display', 799.99, 1),
(2, 'Spring Boot Book', 'Guide to Spring Boot 3', 39.99, 2);
INSERT INTO user (id, username, password) VALUES
(1, 'user', '$2a$12$7goGRF2AkiIR0.NlbNKL1egkp9RTa6tPHklA6p/DmaWZbx9xJ7f5q'),
(2, 'admin', '$2a$12$7vs6nCnQziNELxVj/vP/cuN3UDJSo7V9Oi18j3wRDO4kRnhw2DBiu');

-- Asigna roles
INSERT INTO user_roles (user_id, roles) VALUES
(1, 'USER'),
(2, 'USER'),
(2, 'ADMIN');
