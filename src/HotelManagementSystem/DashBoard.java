package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class DashBoard extends JFrame implements ActionListener {

	 DashBoard()  {
		 setLayout(null);
		 setExtendedState(JFrame.MAXIMIZED_BOTH);
		 getContentPane().setBackground(Color.WHITE);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Luxuryinside.jpg"));
		 JLabel image = new JLabel(i1);
		 image.setBounds(0,0,1550,900);
		 add(image);
		 
		 JLabel text = new JLabel("THE TAJ HOTEL WELCOMES YOU");
		 text.setFont(new Font("Raleway",Font.BOLD,20));
		 text.setForeground(Color.WHITE);
		 text.setBounds(620,50,500,30);
		 image.add(text);
		 
		 JMenuBar ab = new JMenuBar();
		 ab.setBounds(0,0,1550,25);
		 ab.setForeground(Color.RED);
		 ab.setFont(new Font("Raleway",Font.BOLD,16));
		 image.add(ab);
		 
		 
		 JMenu hotel = new JMenu("HOTEL MANAGEMENT SYSTEM");
		 hotel.setForeground(Color.RED);
		 ab.add(hotel);
		 
		 JMenuItem reception = new JMenuItem("RECEPTION");
		 reception.addActionListener(this);
		 reception.setForeground(Color.BLACK);
		 hotel.add(reception);
		 
		 JMenu admin = new JMenu("ADMIN");
		 admin.addActionListener(this);
		 admin.setForeground(Color.BLACK);
		 ab.add(admin);
		 
		 JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		 addemployee.addActionListener(this);
		 admin.add(addemployee);
		 
		 JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		 addrooms.addActionListener(this);
		 admin.add(addrooms);
		 
		 JMenuItem adddriver = new JMenuItem("ADD DRIVER");
		 adddriver.addActionListener(this);
		 admin.add(adddriver);

		 setVisible(true);
		
	}
	 public void actionPerformed(ActionEvent ae) {
		 if (ae.getActionCommand()=="ADD EMPLOYEE") {
			 new AddEmployee().setVisible(true);
		 } else if (ae.getActionCommand() == "ADD ROOMS") {
			 new AddRooms().setVisible(true);
		 } else if (ae.getActionCommand()=="ADD DRIVER") {
			 new AddDriver().setVisible(true);
		 } else if (ae.getActionCommand()=="RECEPTION") {
			 new Reception().setVisible(true);
		 }
		 
	 }

	public static void main(String[] args) {
		new DashBoard();
	}

}
