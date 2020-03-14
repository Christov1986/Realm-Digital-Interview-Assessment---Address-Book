import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class Addressbook_Custom_Menu implements ActionListener{
	//Declare and instantiate instance variables
		JFrame frame = new JFrame("Database Management System - CUSTOM MENU");
		JLabel customMenu = new JLabel("CUSTOM MENU", SwingConstants.CENTER);
		JLabel customMenuInstruction = new JLabel("Enter a custom SQL query to be executed", SwingConstants.CENTER);
		JLabel customQuery = new JLabel("Custom SQL Query", SwingConstants.CENTER);
		JTextField sqlQuery = new JTextField();
		JTextArea message = new JTextArea();
		JButton executeCustom = new JButton("EXECUTE CUSTOM SQL QUERY");
		JButton mainMenu = new JButton("Return to MAIN MENU");
		
		// Create Custom GUI
		public void customFrameGUI() {
			// Set Frame
			frame.setSize(600, 600);
			frame.setLayout(null);
			frame.setVisible(true);
			
			// Set bounds of all Swing Objects
	        customMenu.setBounds(200, 0, 200, 20);
	        customMenuInstruction.setBounds(50, 20, 500, 20);
			customQuery.setBounds(200, 100, 200, 20);
	        sqlQuery.setBounds(50, 140, 500, 30);
	        message.setBounds(50, 360, 500, 70);
	        message.setEditable(false);
	        executeCustom.setBounds(50, 450, 500, 40);
	        mainMenu.setBounds(50, 500, 500, 40);
	        
	        // Add buttons to frame
	        frame.add(customMenu);
	        frame.add(customMenuInstruction);
	        frame.add(customQuery);
	        frame.add(sqlQuery);
	        frame.add(message);
	        frame.add(executeCustom);
	        frame.add(mainMenu);
	        
			
			// Add action listeners to Swing objects
			executeCustom.addActionListener(this);
			mainMenu.addActionListener(this);
			
		}
		
		//@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mainMenu) {
				Addressbook_Main_Menu mainMenuGUI = new Addressbook_Main_Menu();
				mainMenuGUI.frameGUI();
				frame.dispose();
			}
			else if(e.getSource() == executeCustom) {
				String customQuery = (sqlQuery.getText());
				message.setText(CustomConnection(customQuery));
				sqlQuery.setText("");
			}
		}
		
		// Method to run Custom query
				public String CustomConnection(String sqlCustomQuery) {
					String result = "";
					try(
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Christov_addressbook_db?useSSL=false" ,"root" ,"2hW3%gjHi$#w");
							Statement stmt = conn.createStatement();
							
							)
					{	
						
						int countCustom = stmt.executeUpdate(sqlCustomQuery);
						result += (countCustom + " records affected.\n");
							
						}
						
					catch(SQLException ex){
						ex.printStackTrace();
					}
					return result;
				}
}
