DROP DATABASE chathub;
CREATE DATABASE chathub CHARACTER SET utf8 COLLATE utf8_general_ci;
USE chathub;

CREATE TABLE ChatServer
(
    server_id INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    admin_id  INT
);

CREATE TABLE User
(
    user_id   INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50)  NOT NULL,
    surname   VARCHAR(50)  NOT NULL,
    username  VARCHAR(50)  NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    is_admin  BOOLEAN DEFAULT FALSE
);

CREATE TABLE ChatServerUser
(
    server_id INT,
    user_id   INT
);