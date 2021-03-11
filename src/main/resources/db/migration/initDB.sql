CREATE TABLE IF NOT EXISTS roles
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    role       INTEGER      NOT NULL,
    name       VARCHAR(200) NOT NULL,
    email      VARCHAR(200) NOT NULL UNIQUE,
    password   VARCHAR(50)  NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (role) REFERENCES roles (id)

);
CREATE TABLE IF NOT EXISTS categories
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS subCategories
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) UNIQUE,
    category   INTEGER,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category) REFERENCES categories (id)
);
CREATE TABLE IF NOT EXISTS images
(
    id          BIGSERIAL PRIMARY KEY,
    path        VARCHAR(200) UNIQUE,
    uploaded_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS posts
(
    id          BIGSERIAL PRIMARY KEY,
    user        INTEGER,
    category    INTEGER,
    subCategory INTEGER,
    title       VARCHAR(250) UNIQUE NOT NULL,
    description TEXT,
    likes       INTEGER,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category) REFERENCES categories (id),
    FOREIGN KEY (subCategory) REFERENCES subCategories (id),
    FOREIGN KEY (user) REFERENCES users (id)
);
CREATE TABLE IF NOT EXISTS banners
(
    id          BIGSERIAL PRIMARY KEY,
    post        INTEGER,
    image_id    INTEGER,
    title       VARCHAR(250) UNIQUE NOT NULL,
    description TEXT,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post) REFERENCES posts (id),
    FOREIGN KEY (image_id) REFERENCES images (id)
);
ALTER TABLE images
    ADD post INTEGER NULL
        REFERENCES posts (id);
ALTER TABLE images
    ADD banner INTEGER NULL
        REFERENCES banners (id);
