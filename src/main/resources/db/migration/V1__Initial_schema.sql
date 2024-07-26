CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    second_name VARCHAR(255)
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    genre VARCHAR(255),
    description TEXT,
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);