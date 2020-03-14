# Realm-Digital-Interview-Assessment---Address-Book
Realm Digital Interview Assessment - Address Book

Before running the program please perform the following actions

1. Create a mySQL database with the following command
  - CREATE DATABASE Christov_addressbook_db;
  
2. Switch to the database and create the following 3 tables with these commands
  - USE Christov_addressbook_db;
  - CREATE TABLE contacts (
    contact_id INT AUTO_INCREMENT PRIMARY KEY, 
    Firstname VARCHAR(50) NOT NULL, 
    Surname VARCHAR(50) NOT NULL,
    UNIQUE KEY `unique_contact` (`Firstname`,`Surname`)
    );
  - CREATE TABLE phone_no (
    phone_id INT AUTO_INCREMENT PRIMARY KEY, 
    contact_id INT NOT NULL, 
    Phone_number VARCHAR(20) NOT NULL,
    FOREIGN KEY (contact_id)
    REFERENCES contacts (contact_id)
    ON UPDATE RESTRICT ON DELETE CASCADE
    );
  - CREATE TABLE email (
    email_id INT AUTO_INCREMENT PRIMARY KEY, 
    contact_id INT NOT NULL, 
    Email VARCHAR(80) NOT NULL,
    FOREIGN KEY (contact_id)
    REFERENCES contacts (contact_id)
    ON UPDATE RESTRICT ON DELETE CASCADE
    );
    
3. Run the following commands to insert the test data into the mySQL database tables:
  - INSERT INTO contacts (Firstname, Surname)
    VALUES 
    ('Christov', 'van Heerden'),
    ('Vincent', 'van Schalkwyk'),
    ('Nina','le Roux'),
    ('Janke', 'Brits'),
    ('Madelein', 'Voster'),
    ('Wilma', 'Hefer');
    
  - INSERT INTO phone_no (contact_id, Phone_number)
    VALUES
    ((SELECT contact_id FROM contacts WHERE Firstname='Christov' AND Surname='van Heerden'), '0798813700'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Vincent' AND Surname='van Schalkwyk'), '0748945461'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Vincent' AND Surname='van Schalkwyk'), '0840455282'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Nina' AND Surname='le Roux'), '+27782589696'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Nina' AND Surname='le Roux'), '0824826515'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Janke' AND Surname='Brits'), '+27825187312'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Madelein' AND Surname='Voster'), '0832865516'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Wilma' AND Surname='Hefer'), '+27726468830'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Wilma' AND Surname='Hefer'), '+34696356569');
    
  - INSERT INTO email (contact_id, Email)
    VALUES
    ((SELECT contact_id FROM contacts WHERE Firstname='Christov' AND Surname='van Heerden'), 'christov.vanheerden@gmail.com'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Christov' AND Surname='van Heerden'), 'cvh@cerberusfs.com'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Vincent' AND Surname='van Schalkwyk'), 'sucasa367@iafrica.com'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Vincent' AND Surname='van Schalkwyk'), 'vincentvvs73@gmail.com'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Nina' AND Surname='le Roux'), 'nina@cw-consulting.co.za'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Janke' AND Surname='Brits'), 'janke.brits@gmail.com'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Janke' AND Surname='Brits'), 'janke@jcwpetfoods.co.za'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Madelein' AND Surname='Voster'), 'madeleinvoster@flysaa.com'),
    ((SELECT contact_id FROM contacts WHERE Firstname='Wilma' AND Surname='Hefer'), 'wilma47hefer@gmail.com');
    
4. Update the mySQL username and password in each of the connectors to your details
    The current settings look as follows:
      - "jdbc:mysql://localhost:3306/Christov_addressbook_db?useSSL=false", "root", "2hW3%gjHi$#w");
    - Update "root" to your user name
    - Update "2hW3%gjHi$#w" to your password
    
    This can be done with a replace function to speed up the process

5. Add the connector that I have included in the repository to your Classpath



    
