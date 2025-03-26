-- Insert categories
INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Books');

-- Insert users (passwords are bcrypt encoded!)
INSERT INTO user (username, password) VALUES
                                          ('admin', '$2a$10$vioLOCwTMAl8Zlp8nUYFpeuu0wxy62jen0hzo7zpjxWxMIW2Q2p6W'), -- admin123
                                          ('user1', '$2a$10$DzpAfRdywrgjH3v6Wv28wOMFJocK2jiPURCuHdfrXsrRrlblJcNGK'); -- user123

-- Assign roles
INSERT INTO user_roles (user_id, roles) VALUES (1, 'ADMIN');
INSERT INTO user_roles (user_id, roles) VALUES (2, 'USER');

-- Insert products
INSERT INTO product (name, description, price, category_id) VALUES
                                                                ('iPhone 15', 'Apple smartphone', 999.99, 1),
                                                                ('Clean Code', 'Book by Robert C. Martin', 39.99, 2);
