CREATE DATABASE IF NOT EXISTS `flight_search_system`;

CREATE TABLE IF NOT EXISTS `flight_search_system`.`users` (
  `userName` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `emailId` VARCHAR(80) NOT NULL UNIQUE,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`userName`));
  
CREATE TABLE IF NOT EXISTS `flight_search_system`.`user_roles` (
  `id` INT(11) NOT NULL UNIQUE auto_increment,
  `userName` VARCHAR(45) NOT NULL UNIQUE,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `userName` FOREIGN KEY (`userName`)
        REFERENCES `flight_search_system`.`users` (`userName`)
  );
  
CREATE TABLE IF NOT EXISTS `flight_search_system`.`flight_owners` (
    `id` INT NOT NULL UNIQUE auto_increment,
    `ownerName` VARCHAR(45) NOT NULL UNIQUE,
    PRIMARY KEY (`ID`)
);
  
CREATE TABLE IF NOT EXISTS `flight_search_system`.`flight_details` (
    `flightNumber` VARCHAR(10) NOT NULL UNIQUE,
    `flightOwnerID` INT NOT NULL,
    `departureLocationCode` VARCHAR(3) NOT NULL,
    `arrivalLocationCode` VARCHAR(3) NOT NULL,
    `lastValidDate` DATE NOT NULL,
    `departureTime` INT NOT NULL,
    `durationInMinutes` INT NOT NULL,
    `fare` FLOAT NOT NULL,
    `isSeatAvailable` BIT(1) NOT NULL,
    `flightClass` CHAR(2) NOT NULL,
    PRIMARY KEY (`flightNumber`),
    CONSTRAINT `flightOwnerID` FOREIGN KEY (`flightOwnerID`)
        REFERENCES `flight_search_system`.`flight_owners` (`id`)
);
