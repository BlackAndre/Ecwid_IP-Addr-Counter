# Ecwid_IP-Addr-Counter
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
