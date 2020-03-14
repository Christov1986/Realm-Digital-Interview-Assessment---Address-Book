import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addressbook_Insert_Main_Menu implements ActionListener{
	//Declare and instantiate instance variables
		JFrame frame = new JFrame("ADDRESS BOOK - INSERT MAIN MENU");
		JLabel insertMainMenu = new JLabel("INSERT MAIN MENU", SwingConstants.CENTER);
		JLabel insertMainMenuInstruction = new JLabel("Please select an operation to "
				+ "perform", SwingConstants.CENTER);
		JButton createContact = new JButton("CREATE NEW CONTACT");  
		JButton insertPhoneNo = new JButton("ADD PHONE NUMBER");  
		JButton insertEmail = new JButton("ADD E-MAIL ADDRESS");
		JButton mainmenu = new JButton("MAIN MENU");
		
		// Create GUI
		public void frameGUI() {
			// Set Frame
			frame.setSize(600, 600);
			frame.setLayout(null);
			frame.setVisible(true);
			
			// Set buttons and label
	        insertMainMenu.setBounds(200, 0, 200, 30);
	        insertMainMenuInstruction.setBounds(100, 40, 400, 30);
			createContact.setBounds(150, 100, 300, 60);
	        insertPhoneNo.setBounds(150, 170, 300, 60);
	        insertEmail.setBounds(150, 240, 300, 60);
	        mainmenu.setBounds(150, 480, 300, 60);
	        
	        // Add buttons to frame
	        frame.add(insertMainMenu);
	        frame.add(insertMainMenuInstruction);
	        frame.add(insertPhoneNo);
	        frame.add(createContact);
	        frame.add(insertEmail);
	        frame.add(mainmenu);
			
			// Add action listeners to buttons
			createContact.addActionListener(this);
			insertPhoneNo.addActionListener(this);
			insertEmail.addActionListener(this);
			mainmenu.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == createContact) {
				Addressbook_Insert_Menu insertContactMenu = new Addressbook_Insert_Menu();
				insertContactMenu.insertFrameGUI();
				frame.dispose();
			}
			else if(e.getSource() == insertPhoneNo) {
				Addressbook_Insert_PhoneNumber_Menu insertPhoneMenu = new Addressbook_Insert_PhoneNumber_Menu();
				insertPhoneMenu.insertPhoneFrameGUI();
				frame.dispose();
			}
			else if(e.getSource() == insertEmail) {
				Addressbook_Insert_Email_Menu insertEmailMenu = new Addressbook_Insert_Email_Menu();
				insertEmailMenu.insertEmailFrameGUI();
				frame.dispose();
			}
			else if(e.getSource() == mainmenu) {
				Addressbook_Main_Menu mainMenu = new Addressbook_Main_Menu();
				mainMenu.frameGUI();
				frame.dispose();
			}
		}
}
