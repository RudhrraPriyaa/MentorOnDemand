-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mentor
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mentor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mentor` DEFAULT CHARACTER SET utf8 ;
USE `mentor` ;

-- -----------------------------------------------------
-- Table `mentor`.`mentor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`mentor` (
  `mentor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mentor_confirm_password` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_linkedin_url` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_contact` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_first_name` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_last_name` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_name` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_password` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_years_of_exp` BIGINT(20) NULL DEFAULT NULL,
  `mentor_email` VARCHAR(255) NULL DEFAULT NULL,
  `mentor_active` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`mentor_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor`.`skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`skills` (
  `skill_id` INT(11) NOT NULL AUTO_INCREMENT,
  `skill_duration` VARCHAR(255) NULL DEFAULT NULL,
  `skill_prerequites` VARCHAR(255) NULL DEFAULT NULL,
  `skill_name` VARCHAR(255) NULL DEFAULT NULL,
  `skill_toc` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`skill_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor`.`mentor_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`mentor_skills` (
  `ms_mentor_id` INT(11) NULL DEFAULT NULL,
  `ms_skill_id` INT(11) NULL DEFAULT NULL,
  `ms_id` INT(15) NOT NULL AUTO_INCREMENT,
  `mentor_skill_id` INT(11) NOT NULL,
  `facilities_offered` VARCHAR(255) NULL DEFAULT NULL,
  `rating` INT(11) NULL DEFAULT NULL,
  `training_delivered` INT(11) NULL DEFAULT NULL,
  `years_of_exp` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ms_id`),
  INDEX `FKiejqx6eiml0w8lywofpdbd7k3` (`ms_mentor_id` ASC),
  INDEX `FKslaydbxwhp8tlgsayq4sluqne` (`ms_skill_id` ASC),
  CONSTRAINT `FKiejqx6eiml0w8lywofpdbd7k3`
    FOREIGN KEY (`ms_mentor_id`)
    REFERENCES `mentor`.`mentor` (`mentor_id`),
  CONSTRAINT `FKslaydbxwhp8tlgsayq4sluqne`
    FOREIGN KEY (`ms_skill_id`)
    REFERENCES `mentor`.`skills` (`skill_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor`.`trainee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`trainee` (
  `trainee_id` INT(11) NOT NULL AUTO_INCREMENT,
  `trainee_confirm_password` VARCHAR(255) NULL DEFAULT NULL,
  `trainee_email` VARCHAR(255) NULL DEFAULT NULL,
  `trainee_password` VARCHAR(255) NULL DEFAULT NULL,
  `trainee_contact` VARCHAR(255) NULL DEFAULT NULL,
  `trainee_first_name` VARCHAR(255) NULL DEFAULT NULL,
  `trainee_last_name` VARCHAR(255) NULL DEFAULT NULL,
  `trainee_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`trainee_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_password` VARCHAR(255) NULL DEFAULT NULL,
  `user_status` TINYINT(1) NULL DEFAULT NULL,
  `user_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor`.`user_role` (
  `ur_us_id` INT(11) NULL DEFAULT NULL,
  `ur_ro_id` INT(11) NULL DEFAULT NULL,
  `user_role_id` INT(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_role_id`),
  INDEX `FK1t65ha4bv531fmav53vlu66fg` (`ur_us_id` ASC),
  INDEX `FKjia4161ecu6h4p0egc2oc04lt` (`ur_ro_id` ASC),
  CONSTRAINT `FK1t65ha4bv531fmav53vlu66fg`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `mentor`.`user` (`user_id`),
  CONSTRAINT `FKjia4161ecu6h4p0egc2oc04lt`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `mentor`.`role` (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
