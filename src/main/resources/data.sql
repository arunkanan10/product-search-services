DROP TABLE IF EXISTS product_inventory;
DROP TABLE IF EXISTS product_details;
DROP TABLE IF EXISTS seller_details;
DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category (
  id INT PRIMARY KEY,
  category_name VARCHAR(250) NOT NULL
);

CREATE TABLE product_details (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  sku VARCHAR(250) NOT NULL,
  brand VARCHAR(250) NOT NULL,
  price DOUBLE,
  color VARCHAR(250) NOT NULL,
  size VARCHAR(250) NOT NULL,
  product_category_id INT,
  FOREIGN KEY (product_category_id) REFERENCES product_category(id)
);

CREATE TABLE seller_details (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  seller_name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  phone_number VARCHAR(15) NOT NULL
);

CREATE TABLE product_inventory (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_id int NOT NULL,
  seller_id int NOT NULL,
  inventory int NOT NULL,
  FOREIGN KEY (seller_id) REFERENCES seller_details(id),
  FOREIGN KEY (product_id) REFERENCES product_details(id)
);

-- product_category
INSERT INTO product_category (id, category_name) VALUES (1, 'Shirts');
INSERT INTO product_category (id, category_name) VALUES (2, 'Pants');

-- seller_details
INSERT INTO seller_details (seller_name, address, phone_number) VALUES ('Shop 1', 'Chennai', '1234567890');
INSERT INTO seller_details (seller_name, address, phone_number) VALUES ('Shop 2', 'Bangalore', '1234567890');


-- product_details
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Formal Shirts', 'abc12345', 'Peter England', 1000.50, 'Blue', 'XL', 1);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Formal Shirts', 'abc12346', 'Peter England', 999.50, 'Red', 'M', 1);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Casual Shirts', 'abc12347', 'Allen Solly', 950.50, 'White', 'S', 1);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Casual Shirts', 'abc12348', 'Raymond', 1500, 'Blue', 'XL', 1);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Casual Shirts', 'abc12310', 'Raymond', 5000, 'Blue', 'M', 1);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Casual Shirts', 'abc12311', 'Allen Solly', 3000, 'Blue', 'S', 1);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Jeans', 'abc12312', 'Raymond', 7000, 'Blue', '34', 2);
INSERT INTO product_details (product_name, sku, brand, price, color, size, product_category_id) VALUES
    ('Formal Pants', 'abc12313', 'Allen Solly', 65000, 'Blue', '32', 2);

-- product_inventory
INSERT INTO product_inventory (product_id, seller_id, inventory) VALUES (1, 1, 10);
INSERT INTO product_inventory (product_id, seller_id, inventory) VALUES (2, 1, 2);
INSERT INTO product_inventory (product_id, seller_id, inventory) VALUES (3, 2, 5);
INSERT INTO product_inventory (product_id, seller_id, inventory) VALUES (4, 2, 7);
INSERT INTO product_inventory (product_id, seller_id, inventory) VALUES (5, 1, 20);
INSERT INTO product_inventory (product_id, seller_id, inventory) VALUES (6, 2, 1);
