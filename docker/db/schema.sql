CREATE DATABASE IF NOT EXISTS timelog;
USE timelog;

CREATE TABLE users (
    id INT NOT NULL,
    username VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    roles VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE timelogs (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    time_stamp_registry TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO users (id, username, email, password, roles) VALUES (786890,'Diego', 'diego@fiap.com.br', '$2a$10$Bz5F/fcZWFVjQJUFC6vY5eubXPv7eTjYRPixjFNtLJpvWqDM7MOFS', 'USER');
INSERT INTO users (id, username, email, password, roles) VALUES (566890, 'Gustavo', 'gustavo@fiap.com.br', '$2a$10$DtTk9NoLM0k2Q4ObiRV3T.EgcLH4pZ0xm211P3wPPLAuzkvbObTy2', 'USER');
INSERT INTO users (id, username, email, password, roles) VALUES (100000, 'Admin', 'admin@fiap.com.br', '$2a$10$QPvBlXTd8KTXW.XYb/MEsOOgWI9YnP0lAzdHjcZvRXNsD0ZuXE1hS', 'ADMINISTRATOR');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-01 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-01 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-01 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-01 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-02 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-02 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-02 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-02 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-05 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-05 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-05 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-05 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-06 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-06 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-06 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-06 18:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-07 07:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-07 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-07 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-07 17:40:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-08 08:50:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-08 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-08 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-08 19:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-09 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-09 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-09 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-09 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-12 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-12 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-12 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-12 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-13 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-13 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-13 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-13 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-14 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-14 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-14 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-14 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-15 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-15 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-15 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-15 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-16 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-16 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-16 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-16 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-19 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-19 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-19 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-19 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-20 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-20 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-20 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-20 17:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-20 19:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-20 21:32:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-21 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-21 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-21 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-21 17:30:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-22 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-22 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-22 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-22 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-23 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-23 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-23 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-23 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-26 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-26 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-26 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-26 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-27 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-27 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-27 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-27 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-28 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-28 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-28 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-28 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-29 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-29 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-29 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-02-29 17:00:00.26192');
-- 1, 4 - 8, 11 - 15, 18 - 22
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-01 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-01 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-01 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-01 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-04 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-04 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-04 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-04 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-05 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-05 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-05 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-05 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-06 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-06 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-06 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-06 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-07 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-07 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-07 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-07 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-08 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-08 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-08 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-08 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-11 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-11 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-11 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-11 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-12 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-12 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-12 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-12 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-13 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-13 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-13 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-13 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-14 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-14 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-14 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-14 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-15 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-15 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-15 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-15 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-18 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-18 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-18 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-18 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-19 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-19 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-19 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-19 17:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-20 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-20 12:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-20 13:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-20 18:00:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-21 08:00:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-21 12:30:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-21 13:40:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-21 17:30:00.26192');

INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-22 08:50:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-22 12:10:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-22 13:10:00.26192');
INSERT INTO timelogs(user_id, time_stamp_registry) VALUES ( 786890, '2024-03-22 18:00:00.26192');
