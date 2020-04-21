# BankAccount_JSF

# Following are queries to create a mysql database and initialise it with some random data.


create database BankAccounts;

CREATE TABLE `bankaccounts`.`accounts` (
  `idAccounts` INT NOT NULL,
  `AccountType` VARCHAR(45) NULL,
  `AccouHolderName` VARCHAR(45) NULL,
  `AccountHolderContact` VARCHAR(45) NULL,
  `AccountBalance` DECIMAL NULL,
  `AccountSetupDate` DATE NULL,
  PRIMARY KEY (`idAccounts`));    



INSERT INTO `bankaccounts`.`accounts` (`idAccounts`, `AccountType`, `AccouHolderName`, `AccountHolderContact`, `AccountBalance`, `AccountSetupDate`) VALUES ('1', 'Checking', 'Paramjeet Kaur', '6523214567', '5000.50', '2018-02-28');
INSERT INTO `bankaccounts`.`accounts` (`idAccounts`, `AccountType`, `AccouHolderName`, `AccountHolderContact`, `AccountBalance`, `AccountSetupDate`) VALUES ('2', 'Saving', 'Ramanpreet Kaur', '5896321456', '3500.00', '2017-03-12');
INSERT INTO `bankaccounts`.`accounts` (`idAccounts`, `AccountType`, `AccouHolderName`, `AccountHolderContact`, `AccountBalance`, `AccountSetupDate`) VALUES ('3', 'Saving', 'Manpreet Singh', '4895621234', '6000.00', '2013-09-22');
INSERT INTO `bankaccounts`.`accounts` (`idAccounts`, `AccountType`, `AccouHolderName`, `AccountHolderContact`, `AccountBalance`, `AccountSetupDate`) VALUES ('4', 'Checking', 'Jobanpreet Singh', '5897451245', '2000.00', '2015-03-23');
INSERT INTO `bankaccounts`.`accounts` (`idAccounts`, `AccountType`, `AccouHolderName`, `AccountHolderContact`, `AccountBalance`, `AccountSetupDate`) VALUES ('5', 'Saving', 'Gundeep Singh', '5897451245', '3518.25', '2014-04-06');
INSERT INTO `bankaccounts`.`accounts` (`idAccounts`, `AccountType`, `AccouHolderName`, `AccountHolderContact`, `AccountBalance`, `AccountSetupDate`) VALUES ('6', 'Saving', 'Harmandeep Singh', '8945612345', '7215.25', '2013-09-23');
    
