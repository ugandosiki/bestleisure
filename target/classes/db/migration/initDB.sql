CREATE TABLE IF NOT EXISTS roles
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE
);
CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    role_id  INTEGER      NOT NULL,
    name     VARCHAR(200) NOT NULL,
    email    VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(50)  NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
CREATE TABLE IF NOT EXISTS categories
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);
CREATE TABLE IF NOT EXISTS subCategories
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) UNIQUE,
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);
CREATE TABLE IF NOT EXISTS posts
(
    id             BIGSERIAL PRIMARY KEY,
    category_id    INTEGER,
    subCategory_id INTEGER,
    title          VARCHAR(250) UNIQUE NOT NULL,
    description    TEXT,
    img_url        VARCHAR(250) UNIQUE NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (subCategory_id) REFERENCES subCategories (id)
);
CREATE TABLE IF NOT EXISTS banners
(
    id          BIGSERIAL PRIMARY KEY,
    post_id     INTEGER,
    title       VARCHAR(250) UNIQUE NOT NULL,
    description TEXT,
    img_url     VARCHAR(250),
    FOREIGN KEY (post_id) REFERENCES posts (id)
);