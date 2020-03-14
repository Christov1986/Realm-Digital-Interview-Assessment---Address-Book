import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Addressbook_Select_Menu implements ActionListener{
		//Declare and instantiate instance variables
		JFrame frame = new JFrame("ADDRESS BOOK - SELECT MENU");
		JLabel selectMenu = new JLabel("SELECT MENU", SwingConstants.CENTER);
		JLabel selectMenuInstruction = new JLabel("Select a field, operator and value to search by", SwingConstants.CENTER);
		String[] fieldList = {"Firstname", "Surname", "Phone_number", "Email"};
		String[] columnHeaders = {"Contact ID", "Firstname", "Surname", "Phone ID", "Phone Number", "E-mail ID", "E-mail address"};
		Object[][] data = {{1,2,3,4,5,6,7}, {1,2,3,4,5,6,7}};
	    JComboBox fields = new JComboBox(fieldList);
		String[] operators = {"="};
		JComboBox operatorsCB = new JComboBox(operators);
		JTextField value = new JTextField();
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		JButton executeSelectAll = new JButton("DISPLAY ALL RECORDS");
		JButton executeSelect = new JButton("DISPLAY RECORDS");
		JButton mainMenu = new JButton("Return to MAIN MENU");
		
		// Create Delete GUI
		public void selectFrameGUI() {
			// Set Frame
			frame.setSize(1200, 600);
			frame.setLayout(null);
			frame.setVisible(true);
			
			// Set bounds of all Swing Objects
	        selectMenu.setBounds(200, 0, 800, 20);
	        selectMenuInstruction.setBounds(50, 20, 1100, 20);
	        fields.setBounds(350, 50, 150, 30);
	        operatorsCB.setBounds(550, 50, 100, 30);
	        value.setBounds(700, 50, 150, 30);
	        scrollPane.setBounds(50, 100, 1100, 290);
	        executeSelectAll.setBounds(50, 400, 1100, 40);
	        executeSelect.setBounds(50, 450, 1100, 40);
	        mainMenu.setBounds(50, 500, 1100, 40);
	        
	        // Add buttons to frame
	        frame.add(selectMenu);
	        frame.add(selectMenuInstruction);
	        frame.add(fields);
	        frame.add(operatorsCB);
	        frame.add(value);
	        frame.add(scrollPane);
	        model.setColumnIdentifiers(columnHeaders);
	        frame.add(executeSelectAll);
	        frame.add(executeSelect);
	        frame.add(mainMenu);
	        
			
			// Add action listeners to Swing objects
			executeSelectAll.addActionListener(this);
	        executeSelect.addActionListener(this);
			mainMenu.addActionListener(this);
			
		}
		
		//@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mainMenu) {
				Addressbook_Main_Menu mainMenuGUI = new Addressbook_Main_Menu();
				mainMenuGUI.frameGUI();
				frame.dispose();
			}
			else if(e.getSource() == executeSelect) {
				String sqlQuery = ("SELECT * FROM contacts LEFT JOIN phone_no ON contacts.contact_id=phone_no.contact_id "
						+ "LEFT JOIN email ON contacts.contact_id=email.contact_id WHERE " 
						+ fields.getSelectedItem() + operatorsCB.getSelectedItem() + "'" + value.getText() + "'");
				SelectConnection(sqlQuery);
				fields.setSelectedItem("Field 1");
				operatorsCB.setSelectedItem("=");
				value.setText("");
			}
			else if(e.getSource() == executeSelectAll) {
				String sqlQuery = ("SELECT * FROM contacts LEFT JOIN phone_no ON contacts.contact_id=phone_no.contact_id "
						+ "LEFT JOIN email ON contacts.contact_id=email.contact_id");
				SelectConnection(sqlQuery);
			}
		}
		
		// Method to run Select query
		public String SelectConnection(String sqlSelectQuery) {
			String result = "";
			try(
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Christov_addressbook_db?useSSL=false", "root", "2hW3%gjHi$#w");
					Statement stmt = conn.createStatement();
					)
			{			
				ResultSet rset = stmt.executeQuery(sqlSelectQuery);
				Object[] rowdata = new Object[]{1,2,3,4,5,6,7};
				model.setRowCount(0);
				
				while(rset.next()) {
					int contact_id = rset.getInt("contact_id");
					String Firstname = rset.getString("Firstname");
					String Surname = rset.getString("Surname");
					int phone_id = rset.getInt("phone_id");
					String Phone_number = rset.getString("Phone_number");
					int email_id = rset.getInt("email_id");
					String Email = rset.getString("Email");
			
					rowdata[0] = contact_id;
					rowdata[1] = Firstname;
					rowdata[2] = Surname;
					rowdata[3] = phone_id;
					rowdata[4] = Phone_number;
					rowdata[5] = email_id;
					rowdata[6] = Email;
					
					model.addRow(rowdata);
					table.setModel(model);
					}
				
				} 
			
			catch(SQLException ex) {
				ex.printStackTrace();
				}
		return result;
		}
}
