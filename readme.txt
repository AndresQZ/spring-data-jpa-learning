Please follow the tutorial https://roytuts.com/spring-boot-data-jpa-left-right-inner-and-cross-join-examples/


docker run -d --rm --name mysql-learn -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=roytuts mysql:8.0.17



 CREATE TABLE IF NOT EXISTS `payment_request` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `merchant_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `message` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `payment_request` (`id`, `merchant_id`, `message`) VALUES
	(123456, '0001', 'This ones on me'),
	(223456, '0002', 'every cloud has a silver lining'),
	(323456, '0003', 'add insult to injury'),
	(423456, '0004', 'to kick the butcket');


CREATE TABLE IF NOT EXISTS `payment_request_payments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `message` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `payment_id` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `payment_request_id` int(100) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_id` (`payment_request_id`),
  CONSTRAINT `payment_request_payments_ibfk_1` FOREIGN KEY (`payment_request_id`) REFERENCES `payment_request` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `payment_request_payments` (`id`, `message`, `payment_id`, `payment_request_id`) VALUES
	(100, 'first payment', '001', 123456),
	(101, 'second payment', '002', 123456),
	(200, 'first payment', '001', 223456),
	(201, 'second payment', '002', 223456),
	(202, 'third payment', '003', 223456),
	(300, 'first payment', '001', 323456),
	(400, 'first payment', '001', 423456),
	(401, 'second payment', '002', 423456),
	(402, 'third payment', '003', 423456),
	(403, 'fourt payment', '004', 423456),
	(404, 'fiveth payment', '005', 423456);