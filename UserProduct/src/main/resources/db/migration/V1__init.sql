CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR (255) UNIQUE NOT NULL
);

INSERT INTO users (id, username)
VALUES (DEFAULT, 'Petya'),
       (DEFAULT, 'Vasya'),
       (DEFAULT, 'Misha'),
       (DEFAULT, 'Sasha');