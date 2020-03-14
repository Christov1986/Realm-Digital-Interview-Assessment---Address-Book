import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addressbook_Delete_Main_Menu implements ActionListener{
	//Declare and instantiate instance variables
	JFrame frame = new JFrame("ADDRESS BOOK - DELETE MAIN MENU");
	JLabel deleteMainMenu = new JLabel("DELETE MAIN MENU", SwingConstants.CENTER);
	JLabel deleteMainMenuInstruction = new JLabel("Please select an operation to "
			+ "perform", SwingConstants.CENTER);
	JButton deleteContact = new JButton("DELETE CONTACT");  
	JButton deletePhoneNo = new JButton("DELETE PHONE NUMBER");  
	JButton deleteEmail = new JButton("DELETE E-MAIL ADDRESS");
	JButton mainmenu = new JButton("MAIN MENU");
	
	// Create GUI
	public void frameGUI() {
		// Set Frame
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		
		// Set buttons and label
        deleteMainMenu.setBounds(200, 0, 200, 30);
        deleteMainMenuInstruction.setBounds(100, 40, 400, 30);
		deleteContact.setBounds(150, 100, 300, 60);
        deletePhoneNo.setBounds(150, 170, 300, 60);
        deleteEmail.setBounds(150, 240, 300, 60);
        mainmenu.setBounds(150, 480, 300, 60);
        
        // Add buttons to frame
        frame.add(deleteMainMenu);
        frame.add(deleteMainMenuInstruction);
        frame.add(deletePhoneNo);
        frame.add(deleteContact);
        frame.add(deleteEmail);
        frame.add(mainmenu);
		
		// Add action listeners to buttons
		deleteContact.addActionListener(this);
		deletePhoneNo.addActionListener(this);
		deleteEmail.addActionListener(this);
		mainmenu.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deleteContact) {
			Addressbook_Delete_Contact_Menu deleteContactMenu = new Addressbook_Delete_Contact_Menu();
			deleteContactMenu.deleteContactFrameGUI();
			frame.dispose();
		}
		else if(e.getSource() == deletePhoneNo) {
			Addressbook_Delete_PhoneNumber_Menu deletePhoneMenu = new Addressbook_Delete_PhoneNumber_Menu();
			deletePhoneMenu.deletePhoneFrameGUI();
			frame.dispose();
		}
		else if(e.getSource() == deleteEmail) {
			Addressbook_Delete_Email_Menu deleteEmailMenu = new Addressbook_Delete_Email_Menu();
			deleteEmailMenu.deleteEmailFrameGUI();
			frame.dispose();
		}
		else if(e.getSource() == mainmenu) {
			Addressbook_Main_Menu mainMenu = new Addressbook_Main_Menu();
			mainMenu.frameGUI();
			frame.dispose();
		}
	}
}
