-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hospital` DEFAULT CHARACTER SET latin1 ;
USE `Hospital` ;

-- -----------------------------------------------------
-- Table `Hospital`.`enfermeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`enfermeiro` (
  `nome` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `sus` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`medico` (
  `nome` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `sus` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`paciente` (
  `nome` VARCHAR(50) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `sus` VARCHAR(18) NOT NULL,
  `atendido` CHAR(1) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`residencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`residencia` (
  `responsavel` VARCHAR(50) NOT NULL,
  `residencia` VARCHAR(40) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`responsavel`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
