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
2) Изменить строку с названием файла для прочтения в конкструкторе класс IPAddresses
3) запустить класс "IPAdressees". 
Через класс DataBaseHandler будет создано подключение к базе и записаны IP адреса в БД при условии их уникальности.


Threre is the Java APP using MySQL to read a file with IP addresses and write unique addresses to a database.

Instruction:
1) create a table:
CREATE THE `ip` SCHEME;
CREATE TABLE `ip`, ip` (
`idIP` INT NOT NULL AUTO_INCREMENT,
`IP` VARCHAR (45) NOT NULL,
PRIMARY KEY (`idIP`),
UNIQUE INDEX `IP_UNIQUE` (` IP` ASC) VISIBLE);
2) Change the string in APPAddress constructor to specify the file which have to be read.
3) run the class "IPAdressees".
DataBaseHandler class create connect to the database and the IP addresses will be recorded in the database, if they are unique.
