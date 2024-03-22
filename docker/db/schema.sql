CREATE DATABASE IF NOT EXISTS timelog;
USE timelog;

CREATE TABLE Users (
    id INT NOT NULL,
    username VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    roles VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE TimeLogs (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    time_stamp_registry TIMESTAMP,
    PRIMARY KEY (id)
);