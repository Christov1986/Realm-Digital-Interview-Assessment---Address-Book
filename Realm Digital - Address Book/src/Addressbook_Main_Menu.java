import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Addressbook_Main_Menu implements ActionListener{
		//Declare and instantiate instance variables
		JFrame frame = new JFrame("ADDRESS BOOK - MAIN MENU");
		JLabel mainMenu = new JLabel("MAIN MENU", SwingConstants.CENTER);
		JLabel mainMenuInstruction = new JLabel("Please select an operation to "
				+ "perform", SwingConstants.CENTER);
		JButton select = new JButton("VIEW AND SEARCH CONTACTS");  
		JButton insert = new JButton("ADD NEW CONTACT");  
		JButton update = new JButton("UPDATE CONTACT");
		JButton delete = new JButton("DELETE CONTACT");
		JButton custom = new JButton("CUSTOM SQL QUERY");
		JButton exit = new JButton("EXIT");
		
		// Create GUI
		public void frameGUI() {
			// Set Frame
			frame.setSize(600, 600);
			frame.setLayout(null);
			frame.setVisible(true);
			
			// Set buttons and label
	        mainMenu.setBounds(200, 0, 200, 30);
	        mainMenuInstruction.setBounds(100, 40, 400, 30);
			select.setBounds(150, 100, 300, 60);
	        insert.setBounds(150, 170, 300, 60);
	        update.setBounds(150, 240, 300, 60);
	        delete.setBounds(150, 310, 300, 60);
	        custom.setBounds(150, 380, 300, 60);
	        exit.setBounds(150, 480, 300, 60);
	        
	        // Add buttons to frame
	        frame.add(mainMenu);
	        frame.add(mainMenuInstruction);
	        frame.add(delete);
	        frame.add(insert);
	        frame.add(select);
	        frame.add(update);
	        frame.add(custom);
	        frame.add(exit);
			
			// Add action listeners to buttons
			select.addActionListener(this);
			insert.addActionListener(this);
			update.addActionListener(this);
			delete.addActionListener(this);
			custom.addActionListener(this);
			exit.addActionListener(this);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == delete) {
				Addressbook_Delete_Main_Menu deleteMenu = new Addressbook_Delete_Main_Menu();
				deleteMenu.frameGUI();
				frame.dispose();
			}
			else if(e.getSource() == insert) {
				Addressbook_Insert_Main_Menu insertMainMenu = new Addressbook_Insert_Main_Menu();
				insertMainMenu.frameGUI();
				frame.dispose();
			}
			else if(e.getSource() == select) {
				Addressbook_Select_Menu selectMenu = new Addressbook_Select_Menu();
				selectMenu.selectFrameGUI();
				frame.dispose();
			}
			else if(e.getSource() == update) {
				Addressbook_Update_Main_Menu updateMainMenu = new Addressbook_Update_Main_Menu();
				updateMainMenu.frameGUI();
				frame.dispose();
			}
			else if(e.getSource() == custom) {
				Addressbook_Custom_Menu customMenu = new Addressbook_Custom_Menu();
				customMenu.customFrameGUI();
				frame.dispose();
			}
			else if(e.getSource() == exit) {
				System.exit(0);
			}
		}
}
