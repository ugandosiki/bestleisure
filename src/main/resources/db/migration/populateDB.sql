INSERT INTO roles(name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');
INSERT INTO users(role, name, email, password)
VALUES (1, 'Eugene', 'qwerty12345@gmail.com', 'password'),
       (1, 'Vladik', 'qwrqwrqw@gmail.com', 'password'),
       (2, 'Igor', 'user@gmail.com', 'password');
INSERT INTO categories(name)
VALUES ('Ukraine'),
       ('Poland');
INSERT INTO subcategories(name, category)
VALUES ('Kyiv', 1),
       ('Warshaw', 2);
INSERT INTO images(path)
VALUES ('img1.jpg'),
       ('img2.jpg');
INSERT INTO posts(user, category, subcategory_id, title, description)
VALUES (2, 1, 1, 'Baghdad', 'Hachovnia pod 11 obsh'),
       (2, 2, 2, 'Polska zabava', 'Origin Polish kulebiaka');
INSERT INTO banners(post, image_id, title, description)
VALUES (1, 1, 'Reklama Coke Cola', 'Lorem ipsum...'),
       (2, 2, 'Reklama Pepsi Cola', 'Lorem ipsum..')