INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Arsalan', 'Asad');
INSERT INTO `items` (`item_name`, `price`) VALUES ('Super SmashBros', 44.00);
INSERT INTO `items` (`item_name`, `price`) VALUES ('FFVII remake', 30.00);
INSERT INTO `items` (`item_name`, `price`) VALUES ('GTA v', 25.00);
INSERT INTO `orders` (`fk_cid`, `order_value`) VALUES (1, 99);
INSERT INTO `orderline` (`fk_oid`, `fk_iid`) VALUES (1, 1);

