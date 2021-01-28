DROP TABLE `orderline`;
DROP TABLE `orders`;
DROP TABLE  `items`;
DROP TABLE `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `cid` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`cid`)
);



CREATE TABLE IF NOT EXISTS `items` (
	`iid` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`item_name` VARCHAR(30) DEFAULT NULL,
	`price` INT(20) DEFAULT NULL
);




CREATE TABLE IF NOT EXISTS `orders` (
	`oid` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`fk_cid` INT(11) NOT NULL,
	`order_value` DOUBLE,
	FOREIGN KEY (`fk_cid`) REFERENCES `customers` (`cid`) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS `orderline` (
	`fk_oid` INT(11) NOT NULL,
	`fk_iid` INT(11) NOT NULL,
	FOREIGN KEY (`fk_oid`) REFERENCES `orders`(`oid`) ON DELETE CASCADE,
	FOREIGN KEY (`fk_iid`) REFERENCES `items` (`iid`) ON DELETE CASCADE
);
