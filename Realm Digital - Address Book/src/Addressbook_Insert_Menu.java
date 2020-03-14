import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class Addressbook_Insert_Menu implements ActionListener{
		//Declare and instantiate instance variables
		JFrame frame = new JFrame("ADDRESS BOOK - INSERT MENU");
		JLabel insertMenu = new JLabel("INSERT MENU", SwingConstants.CENTER);
		JLabel insertMenuInstruction = new JLabel("Complete all fields to create a complete record", SwingConstants.CENTER);
		JLabel field1Label = new JLabel("Firstname (Required) : ", SwingConstants.CENTER);
		JTextField field1 = new JTextField();
		JLabel field2Label = new JLabel("LastName (Required) : ", SwingConstants.CENTER);
		JTextField field2 = new JTextField();
		JLabel field3Label = new JLabel("Phone number : ", SwingConstants.CENTER);
		JTextField field3 = new JTextField();
		JLabel field4Label = new JLabel("E-mail address : ", SwingConstants.CENTER);
		JTextField field4 = new JTextField();
		JTextArea message = new JTextArea();
		JButton executeInsert = new JButton("INSERT RECORD");
		JButton mainMenu = new JButton("Return to MAIN MENU");
		
		// Create Delete GUI
		public void insertFrameGUI() {
			// Set Frame
			frame.setSize(600, 600);
			frame.setLayout(null);
			frame.setVisible(true);
			
			// Set bounds of all Swing Objects
	        insertMenu.setBounds(200, 0, 200, 20);
	        insertMenuInstruction.setBounds(50, 20, 500, 20);
			field1Label.setBounds(100, 60, 200, 20);
	        field1.setBounds(300, 60, 200, 20);
	        field2Label.setBounds(100, 90, 200, 20);
	        field2.setBounds(300, 90, 200, 20);
	        field3Label.setBounds(100, 120, 200, 20);
	        field3.setBounds(300, 120, 200, 20);
	        field4Label.setBounds(100, 150, 200, 20);
	        field4.setBounds(300, 150, 200, 20);
	        message.setBounds(50, 360, 500, 70);
	        message.setEditable(false);
	        executeInsert.setBounds(50, 450, 500, 40);
	        mainMenu.setBounds(50, 500, 500, 40);
	        
	        // Add buttons to frame
	        frame.add(insertMenu);
	        frame.add(insertMenuInstruction);
	        frame.add(field1Label);
	        frame.add(field1);
	        frame.add(field2Label);
	        frame.add(field2);
	        frame.add(field3Label);
	        frame.add(field3);
	        frame.add(field4Label);
	        frame.add(field4);
	        frame.add(message);
	        frame.add(executeInsert);
	        frame.add(mainMenu);
	        
			
			// Add action listeners to Swing objects
			executeInsert.addActionListener(this);
			mainMenu.addActionListener(this);

			}
		
		//@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mainMenu) {
				Addressbook_Main_Menu mainMenuGUI = new Addressbook_Main_Menu();
				mainMenuGUI.frameGUI();
				frame.dispose();
			}
			else if(e.getSource() == executeInsert) {
				String sqlQuery1 = ("INSERT INTO contacts (Firstname, Surname) "
						+ "VALUES ('" + field1.getText() + "', '" + field2.getText() + "');");
				String sqlQuery2 = ("INSERT INTO phone_no (contact_id, Phone_number) "
						+ "VALUES ((SELECT contact_id FROM contacts WHERE Firstname='" + field1.getText() 
						+ "' AND Surname='" + field2.getText() + "'), '" 
						+ field3.getText() + "');");
				String sqlQuery3 = ("INSERT INTO email (contact_id, Email) "
						+ "VALUES ((SELECT contact_id FROM contacts WHERE Firstname='" + field1.getText() 
						+ "' AND Surname='" + field2.getText() + "'), '" + field4.getText() + "');");
				System.out.println(sqlQuery1);
				System.out.println(sqlQuery2);
				System.out.println(sqlQuery3);
				message.setText(InsertConnection(sqlQuery1));
				message.setText(InsertConnection(sqlQuery2));
				message.setText(InsertConnection(sqlQuery3));
				field1.setText("");
				field2.setText("");
				field3.setText("");
				field4.setText("");
			}
		}
		
		// Method to run Insert query
			public String InsertConnection(String sqlInsertQuery) {
				String result = "";
				try(
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Christov_addressbook_db?useSSL=false" ,"root" ,"2hW3%gjHi$#w");
						Statement stmt = conn.createStatement();
						
						)
				{	
					
					int countInserted = stmt.executeUpdate(sqlInsertQuery);
					result += (countInserted + " records affected.\n");
						
					}
					
				catch(SQLException ex){
					ex.printStackTrace();
				}
				return result;
			}
	}
