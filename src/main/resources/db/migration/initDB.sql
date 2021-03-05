CREATE TABLE IF NOT EXISTS roles
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    role_id    INTEGER      NOT NULL,
    name       VARCHAR(200) NOT NULL,
    email      VARCHAR(200) NOT NULL UNIQUE,
    password   VARCHAR(50)  NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES roles (id)

);
CREATE TABLE IF NOT EXISTS categories
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS subCategories
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) UNIQUE,
    category_id INTEGER,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);
CREATE TABLE IF NOT EXISTS images
(
    id          BIGSERIAL PRIMARY KEY,
    path        VARCHAR(200) UNIQUE ,
    uploaded_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS posts
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        INTEGER,
    category_id    INTEGER,
    subCategory_id INTEGER,
    image_id       INTEGER,
    title          VARCHAR(250) UNIQUE NOT NULL,
    description    TEXT,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (subCategory_id) REFERENCES subCategories (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (image_id) REFERENCES images (id)
);
CREATE TABLE IF NOT EXISTS banners
(
    id          BIGSERIAL PRIMARY KEY,
    post_id     INTEGER,
    img_id      INTEGER,
    title       VARCHAR(250) UNIQUE NOT NULL,
    description TEXT,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts (id),
    FOREIGN KEY (img_id) REFERENCES images (id)
);
