-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Lis 2020, 14:28
-- Wersja serwera: 10.4.14-MariaDB
-- Wersja PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `ADO`
--

-- --------------------------------------------------------

--
-- Skrypt tworzący dla tabeli `user`
--

CREATE SCHEMA `ado` ;


CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) NOT NULL,
                        `surname` varchar(45) NOT NULL,
                        `email` varchar(45) NOT NULL,
                        `hash` varchar(512) NOT NULL,
                        `date_created` timestamp,
                        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Skrypt tworzący dla tabeli `user_request`
--

CREATE TABLE `user_request` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `id_user` int(11) NOT NULL,
                          `id_last_image` int(11) NOT NULL,
                          `request_date` timestamp ,
                          `requests_number` int NOT NULL,
                          PRIMARY KEY (id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Skrypt tworzący dla tabeli  `image`
--

CREATE TABLE `image` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `id_user` int(11) NOT NULL,
                                  `image_name` varchar(256) NOT NULL,
                                  `image` MEDIUMBLOB,
                                  `description` varchar (1024) NOT NULL,
                                  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `product` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(256) NOT NULL,
                         `image` MEDIUMBLOB,
                         `price` varchar (1024) NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
-- --------------------------------------------------------

--
-- Skrypt tworzący dla tabeli `image_description`
--

-- CREATE TABLE `image_description` (
--                                     `id` int(11) NOT NULL AUTO_INCREMENT,
--                                     `id_image` int(11) NOT NULL,
--                                     `description` varchar(2000) NOT NULL,
--                                     PRIMARY KEY (id)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Skrypt tworzący dla tabeli `user_roles`
--

CREATE TABLE `user_roles` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `id_role` int(11) NOT NULL,
                                     `id_user` int(11) NOT NULL,
                                     PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Skrypt tworzący dla tabeli `role`
--

CREATE TABLE `role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` text NOT NULL,
                        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

--
-- Dodanie foreign keys do tabeli user_request
--
ALTER TABLE `user_request`
    ADD CONSTRAINT FOREIGN KEY (`id_user`) REFERENCES `user`(`id`),
    ADD CONSTRAINT FOREIGN KEY (`id_last_image`) REFERENCES `image`(`id`);

--
-- Dodanie foreign keys do tabeli image
--
ALTER TABLE `image`
    ADD CONSTRAINT FOREIGN KEY (`id_user`) REFERENCES `user`(`id`);

-- --
-- -- Dodanie foreign keys do tabeli user_roles
-- --
-- ALTER TABLE `user_roles`
--     ADD CONSTRAINT FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`);

--
-- Dodanie foreign keys do tabeli image_description
--
-- ALTER TABLE `image_description`
--     ADD CONSTRAINT FOREIGN KEY (`id_image`) REFERENCES `image`(`id_image`);




/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
