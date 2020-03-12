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
    
3. Run the following commands to insert the test data into the mySQL database tables:
  - INSERT INTO contacts (name, surname)
    VALUES 
    ('Christov', 'van Heerden'),
    ('Vincent', 'van Schalkwyk'),
    ('Nina','le Roux'),
    ('Janke', 'Brits'),
    ('Madelein', 'Voster'),
    ('Wilma', 'Hefer');
    
  - INSERT INTO phone_no (contact_id, phone_number)
    VALUES
    ((SELECT contact_id FROM contacts WHERE name='Christov' AND surname='van Heerden'), '0798813700'),
    ((SELECT contact_id FROM contacts WHERE name='Vincent' AND surname='van Schalkwyk'), '0748945461'),
    ((SELECT contact_id FROM contacts WHERE name='Vincent' AND surname='van Schalkwyk'), '0840455282'),
    ((SELECT contact_id FROM contacts WHERE name='Nina' AND surname='le Roux'), '+27782589696'),
    ((SELECT contact_id FROM contacts WHERE name='Nina' AND surname='le Roux'), '0824826515'),
    ((SELECT contact_id FROM contacts WHERE name='Janke' AND surname='Brits'), '+27825187312'),
    ((SELECT contact_id FROM contacts WHERE name='Madelein' AND surname='Voster'), '0832865516'),
    ((SELECT contact_id FROM contacts WHERE name='Wilma' AND surname='Hefer'), '+27726468830'),
    ((SELECT contact_id FROM contacts WHERE name='Wilma' AND surname='Hefer'), '+34696356569');
    
  - INSERT INTO email (contact_id, email)
    VALUES
    ((SELECT contact_id FROM contacts WHERE name='Christov' AND surname='van Heerden'), 'christov.vanheerden@gmail.com'),
    ((SELECT contact_id FROM contacts WHERE name='Christov' AND surname='van Heerden'), 'cvh@cerberusfs.com'),
    ((SELECT contact_id FROM contacts WHERE name='Vincent' AND surname='van Schalkwyk'), 'sucasa367@iafrica.com'),
    ((SELECT contact_id FROM contacts WHERE name='Vincent' AND surname='van Schalkwyk'), 'vincentvvs73@gmail.com'),
    ((SELECT contact_id FROM contacts WHERE name='Nina' AND surname='le Roux'), 'nina@cw-consulting.co.za'),
    ((SELECT contact_id FROM contacts WHERE name='Janke' AND surname='Brits'), 'janke.brits@gmail.com'),
    ((SELECT contact_id FROM contacts WHERE name='Janke' AND surname='Brits'), 'janke@jcwpetfoods.co.za'),
    ((SELECT contact_id FROM contacts WHERE name='Madelein' AND surname='Voster'), 'madeleinvoster@flysaa.com'),
    ((SELECT contact_id FROM contacts WHERE name='Wilma' AND surname='Hefer'), 'wilma47hefer@gmail.com');
    
