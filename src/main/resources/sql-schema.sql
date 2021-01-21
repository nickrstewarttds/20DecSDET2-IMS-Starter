drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`Iid` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`item_name` VARCHAR(30) DEFAULT NULL,
	`price` INT(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`Oid` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`fk.id` INT(11) NOT NULL,
	FOREIGN KEY (`fk.id`) REFERENCES `customers` (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orderline` (
	`fk.Oid` INT(11) NOT NULL,
	`fk.Iid` INT(11) NOT NULL,
	FOREIGN KEY (`fk.Oid`) REFERENCES `orders`(`Oid`),
	FOREIGN KEY (`fk.Iid`) REFERENCES `items` (`Iid`)
);
