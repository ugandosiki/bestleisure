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
    password   VARCHAR(200) NOT NULL,
    city       VARCHAR(200),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES roles (id)

);
CREATE TABLE IF NOT EXISTS types
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
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
    path        VARCHAR(200) UNIQUE,
    uploaded_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS posts
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        INTEGER,
    category_id    INTEGER,
    subCategory_id INTEGER,
    title          VARCHAR(250) UNIQUE NOT NULL,
    description    TEXT,
    address        VARCHAR(200) UNIQUE NOT NULL,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (subCategory_id) REFERENCES subCategories (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS post_like
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    INTEGER NOT NULL,
    post_id    INTEGER NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (post_id) REFERENCES posts (id)
);

CREATE TABLE IF NOT EXISTS banners
(
    id          BIGSERIAL PRIMARY KEY,
    post_id     INTEGER,
    image_id    INTEGER,
    title       VARCHAR(250) NOT NULL,
    description TEXT,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts (id)
);

ALTER TABLE images
    ADD post_id INTEGER NULL
        REFERENCES posts (id);
ALTER TABLE images
    ADD banner_id INTEGER NULL
        REFERENCES banners (id);
ALTER TABLE posts
    ADD type_id INTEGER NULL
        REFERENCES types (id);
