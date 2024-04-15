DROP SCHEMA IF EXISTS MarketfyDB;
CREATE SCHEMA MarketfyDB;
USE MarketfyDB;

CREATE TABLE users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50) UNIQUE NOT NULL,
    pass VARCHAR(100)NOT NULL ,
    first  VARCHAR(30) NOT NULL,
    last VARCHAR(30) NOT NULL, 
    role VARCHAR(30) NOT NULL,
    active BOOLEAN NOT NULL);
    
CREATE TABLE users_extra(
	user_id INT PRIMARY KEY NOT NULL,
    preferred VARCHAR(50),
    bio VARCHAR(300),
    tags  JSON,
    foreign key (user_id) REFERENCES users(user_id));
        
CREATE TABLE products (
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL ,
    price  NUMERIC(8,2) NOT NULL,
    IMAGE LONGBLOB,
    synopsis TEXT,
    inventory INT NOT NULL);
    
    
CREATE TABLE orders (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
    total_items INT,
    total NUMERIC(8,2),
	order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (user_id) REFERENCES users(user_id));
    
CREATE TABLE order_items(
	order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
	product_id INT NOT NULL, 
    qty INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id));
    
CREATE TABLE wishlist_items (
    wishlist_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id), 
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

INSERT INTO users (email, pass, first, last, role, active)
VALUES
    ('user1@example.com', 'password1', 'John', 'Doe', 'admin', false),
    ('user2@example.com', 'password2', 'Jane', 'Smith', 'user', false),
    ('user3@example.com', 'password3', 'Alice', 'Johnson', 'user', false),
    ('user4@example.com', 'password4', 'Bob', 'Williams', 'user', false);


INSERT INTO products (title, author, price, IMAGE, synopsis, inventory)
VALUES
    ('Book11', 'Author 1', 19.99, NULL, 'Synopsis 1', 100),
    ('Book12', 'Author 2', 29.99, NULL, 'Synopsis 2', 50),
    ('Book13', 'Author 3', 24.99, NULL, 'Synopsis 3', 75),
    ('Book14', 'Author 4', 14.99, NULL, 'Synopsis 4', 120),
    ('Book15', 'Author 5', 34.99, NULL, 'Synopsis 5', 80),
    ('Book16', 'Author 6', 39.99, NULL, 'Synopsis 6', 60),
    ('Book17', 'Author 7', 49.99, NULL, 'Synopsis 7', 90),
    ('Book18', 'Author 8', 44.99, NULL, 'Synopsis 8', 110),
    ('Book19', 'Author 9', 54.99, NULL, 'Synopsis 9', 70),
    ('Book 20', 'Author 10', 19.99, NULL, 'Synopsis 10', 100);



