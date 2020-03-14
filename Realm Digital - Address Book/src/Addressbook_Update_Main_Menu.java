import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Addressbook_Update_Main_Menu implements ActionListener{
			//Declare and instantiate instance variables
			JFrame frame = new JFrame("ADDRESS BOOK - UPDATE MAIN MENU");
			JLabel updateMainMenu = new JLabel("UPDATE MAIN MENU", SwingConstants.CENTER);
			JLabel updateMainMenuInstruction = new JLabel("Please select an operation to "
					+ "perform", SwingConstants.CENTER);
			JButton updateContact = new JButton("UPDATE CONTACT");  
			JButton updatePhoneNo = new JButton("UPDATE PHONE NUMBER");  
			JButton updateEmail = new JButton("UPDATE E-MAIL ADDRESS");
			JButton mainmenu = new JButton("MAIN MENU");
			
			// Create GUI
			public void frameGUI() {
				// Set Frame
				frame.setSize(600, 600);
				frame.setLayout(null);
				frame.setVisible(true);
				
				// Set buttons and label
		        updateMainMenu.setBounds(200, 0, 200, 30);
		        updateMainMenuInstruction.setBounds(100, 40, 400, 30);
				updateContact.setBounds(150, 100, 300, 60);
		        updatePhoneNo.setBounds(150, 170, 300, 60);
		        updateEmail.setBounds(150, 240, 300, 60);
		        mainmenu.setBounds(150, 480, 300, 60);
		        
		        // Add buttons to frame
		        frame.add(updateMainMenu);
		        frame.add(updateMainMenuInstruction);
		        frame.add(updatePhoneNo);
		        frame.add(updateContact);
		        frame.add(updateEmail);
		        frame.add(mainmenu);
				
				// Add action listeners to buttons
				updateContact.addActionListener(this);
				updatePhoneNo.addActionListener(this);
				updateEmail.addActionListener(this);
				mainmenu.addActionListener(this);
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == updateContact) {
					Addressbook_Update_Contact_Menu updateContactMenu = new Addressbook_Update_Contact_Menu();
					updateContactMenu.updateContactFrameGUI();
					frame.dispose();
				}
				else if(e.getSource() == updatePhoneNo) {
					Addressbook_Update_PhoneNumber_Menu updatePhoneNoMenu = new Addressbook_Update_PhoneNumber_Menu();
					updatePhoneNoMenu.updatePhoneFrameGUI();
					frame.dispose();
				}
				else if(e.getSource() == updateEmail) {
					Addressbook_Update_Email_Menu updateEmailMenu = new Addressbook_Update_Email_Menu();
					updateEmailMenu.updateEmailFrameGUI();
					frame.dispose();
				}
				else if(e.getSource() == mainmenu) {
					Addressbook_Main_Menu mainMenu = new Addressbook_Main_Menu();
					mainMenu.frameGUI();
					frame.dispose();
				}
			}
}
