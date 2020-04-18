# Ecwid_IP-Addr-Counter
Java программа с использованием MySQL для считывания файла с IP адресами и запись уникальных адресов в базу данных.

Инструкция:
1) создать таблицу:
    CREATE SCHEMA `ip` ;
    CREATE TABLE `ip`.`ip` (
    `idIP` INT NOT NULL AUTO_INCREMENT,
    `IP` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idIP`),
    UNIQUE INDEX `IP_UNIQUE` (`IP` ASC) VISIBLE);
    
2) запустить класс "IPAdressees". 
Через класс DataBaseHandler будет создано подключение к базе и записаны IP адреса при условии их уникальности.
