docker build -t payara-ear .
docker run -p 8080:8080 -p 4848:4848 payara-ear

docker build -t payara-ear-443 .

docker run -p 80:80 -p 8080:8080 -p 4848:4848 payara-ear-443

ec2-34-227-242-171.compute-1.amazonaws.com
Administrator
d&tHufZN&f1RIX!Yem=kJOC3IwuPellc

CREATE TABLE `userprofile` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `work_incident` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `dateReported` datetime NOT NULL,
  `department` varchar(255) NOT NULL,
  `reportedBy` varchar(255) NOT NULL,
  `status` varchar(50) NOT NULL,
  `dateResolved` datetime DEFAULT NULL,
  `resolution` text,
  `createdBy` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_createdBy` (`createdBy`),
  CONSTRAINT `fk_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `userprofile` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci