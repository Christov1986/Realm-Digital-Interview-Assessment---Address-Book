# Realm-Digital-Interview-Assessment---Address-Book
Realm Digital Interview Assessment - Address Book

Before running the program please perform the following actions

1. Create a mySQL database with the following command
  - CREATE DATABASE Christov_addressbook_db;
  
2. Switch to the database and create the following 3 tables with these commands
  - USE Christov_addressbook_db;
  - CREATE TABLE contacts (
    contact_id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(50) NOT NULL, 
    surname VARCHAR(50) NOT NULL
    );
  - CREATE TABLE phone_no (
    phone_id INT AUTO_INCREMENT PRIMARY KEY, 
    contact_id INT NOT NULL, 
    phone_number VARCHAR(20) NOT NULL,
    FOREIGN KEY (contact_id)
    REFERENCES contacts (contact_id)
    ON UPDATE RESTRICT ON DELETE CASCADE
    );
  - CREATE TABLE email (
    email_id INT AUTO_INCREMENT PRIMARY KEY, 
    contact_id INT NOT NULL, 
    email VARCHAR(80) NOT NULL,
    FOREIGN KEY (contact_id)
    REFERENCES contacts (contact_id)
    ON UPDATE RESTRICT ON DELETE CASCADE
    );
