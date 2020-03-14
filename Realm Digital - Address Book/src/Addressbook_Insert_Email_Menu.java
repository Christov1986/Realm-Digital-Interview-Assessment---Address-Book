import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Addressbook_Insert_Email_Menu implements ActionListener{
	//Declare and instantiate instance variables
			JFrame frame = new JFrame("ADDRESS BOOK - INSERT E-MAIL MENU");
			JLabel insertEmailMenu = new JLabel("INSERT E-MAIL MENU", SwingConstants.CENTER);
			JLabel insertEmailMenuInstruction = new JLabel("Select the Contact ID to which the E-mail Address should be added", SwingConstants.CENTER);
			String[] columnHeaders = {"Contact ID", "Firstname", "Surname", "Phone ID", "Phone Number", "E-mail ID", "E-mail address"};
			JLabel textContactID = new JLabel("Contact ID", SwingConstants.CENTER);
			JLabel textEmailAddress = new JLabel("E-mail address", SwingConstants.CENTER);
			JTextField valueContactID = new JTextField();
			JTextField valueEmailAddress = new JTextField();
			JButton insertEmailAddress = new JButton("ADD E-MAIL ADDRESS");
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			JButton executeSelectAll = new JButton("DISPLAY ALL RECORDS");
			JButton mainMenu = new JButton("Return to MAIN MENU");
			
			// Create Delete GUI
			public void insertEmailFrameGUI() {
				// Set Frame
				frame.setSize(1200, 600);
				frame.setLayout(null);
				frame.setVisible(true);
				
				// Set bounds of all Swing Objects
		        insertEmailMenu.setBounds(200, 0, 800, 20);
		        insertEmailMenuInstruction.setBounds(50, 20, 1100, 20);
		        textContactID.setBounds(435, 50, 150, 30);
		        textEmailAddress.setBounds(615, 50, 150, 30);
		        valueContactID.setBounds(435, 80, 150, 30);
		        valueEmailAddress.setBounds(615, 80, 150, 30);
		        insertEmailAddress.setBounds(875, 80, 275, 30);
		        scrollPane.setBounds(50, 120, 1100, 320);
		        executeSelectAll.setBounds(50, 450, 1100, 40);
		        mainMenu.setBounds(50, 500, 1100, 40);
		        
		        // Add buttons to frame
		        frame.add(insertEmailMenu);
		        frame.add(insertEmailMenuInstruction);
		        frame.add(textContactID);
		        frame.add(textEmailAddress);
		        frame.add(valueContactID);
		        frame.add(valueEmailAddress);
		        frame.add(insertEmailAddress);
		        frame.add(scrollPane);
		        model.setColumnIdentifiers(columnHeaders);
		        frame.add(executeSelectAll);
		        frame.add(mainMenu);
		        
				
				// Add action listeners to Swing objects
		        insertEmailAddress.addActionListener(this);
		        executeSelectAll.addActionListener(this);
				mainMenu.addActionListener(this);
				executeSelectAll.doClick();
				
			}
			
			//@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mainMenu) {
					Addressbook_Main_Menu mainMenuGUI = new Addressbook_Main_Menu();
					mainMenuGUI.frameGUI();
					frame.dispose();
				}
				else if(e.getSource() == executeSelectAll) {
					String sqlQuery = ("SELECT * FROM contacts LEFT JOIN phone_no ON contacts.contact_id=phone_no.contact_id "
							+ "LEFT JOIN email ON contacts.contact_id=email.contact_id");
					SelectConnection(sqlQuery);
				}
				else if(e.getSource() == insertEmailAddress) {
					String sqlQuery = ("INSERT INTO email (contact_id, Email) "
							+ "VALUES (" + valueContactID.getText() + ", '" + valueEmailAddress.getText() + "')");
					UpdateConnection(sqlQuery);
					valueContactID.setText("");
					valueEmailAddress.setText("");
					executeSelectAll.doClick();
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
			
			// Method to run Update query
			public void UpdateConnection(String sqlUpdateQuery) {
				try(
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Christov_addressbook_db?useSSL=false" ,"root" ,"2hW3%gjHi$#w");
						Statement stmt = conn.createStatement();
						
						)
				{	
					
					stmt.executeUpdate(sqlUpdateQuery);
						
					}
					
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
}
