package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JTextField tfaddrooms,tfprice;
	JComboBox tfavailable,tfcleaningstatus,tfbedtype;
	JButton addroom,cancel;
	
	 AddRooms()  {
		setLayout(null);
		setBounds(300,250,940,450);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/LuxuryBed.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,340, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,20,600,400);
		add(image);
		
		JLabel addrooms = new JLabel("Add Rooms");
		addrooms.setBounds(180,30,100,30);
		addrooms.setFont(new Font("Raleway",Font.BOLD,17));
		add(addrooms);
		
		
		JLabel roomnumber = new JLabel("Room Number");
		roomnumber.setBounds(70,100,150,25);
		roomnumber.setFont(new Font("Raleway",Font.PLAIN,17));
		add(roomnumber);
		
		tfaddrooms = new JTextField();
		tfaddrooms.setBounds(230,100,150,30);
		add(tfaddrooms);
		
		JLabel available = new JLabel("Available");
		available.setBounds(70,150,150,25);
		available.setFont(new Font("Raleway",Font.PLAIN,17));
		add(available);
		
		String cavailable [] = {"Available ","Not- Available"};
		tfavailable = new JComboBox(cavailable);
		tfavailable.setBackground(Color.WHITE);
		tfavailable.setBounds(230,150,150,25);
		add(tfavailable);
		
		JLabel cleaningstatus = new JLabel("Cleaning Status");
		cleaningstatus.setBounds(70,200,150,25);
		cleaningstatus.setFont(new Font("Raleway",Font.PLAIN,17));
		add(cleaningstatus);
		
		
		String ccleaned [] = {"Cleaned","Not-Cleaned"};
		tfcleaningstatus = new JComboBox(ccleaned);
		tfcleaningstatus.setBackground(Color.WHITE);
		tfcleaningstatus.setBounds(230,200,150,25);
		add(tfcleaningstatus);
		
		JLabel price = new JLabel("Price");
		price.setBounds(70,250,150,25);
		price.setFont(new Font("Raleway",Font.PLAIN,17));
		add(price);
		
		tfprice = new JTextField();
		tfprice.setBounds(230,250,150,30);
		add(tfprice);
		
		JLabel bedtype = new JLabel("Bed Type");
		bedtype.setBounds(70,300,150,25);
		bedtype.setFont(new Font("Raleway",Font.PLAIN,17));
		add(bedtype);
		
		String bdtype [] = {"Single-bed","Double- bed"};
		tfbedtype = new JComboBox(bdtype);
		tfbedtype.setBackground(Color.WHITE);
		tfbedtype.setBounds(230,300,150,25);
		add(tfbedtype);
		
		addroom = new JButton("Add Room");
		addroom.setBounds(80,350,100,30);
		addroom.setForeground(Color.WHITE);
		addroom.setBackground(Color.BLACK);
		addroom.addActionListener(this);
		add(addroom);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(250,350,100,30);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	 public void actionPerformed(ActionEvent ae) {
		  if (ae.getSource()==addroom) { 
			 String addrooms = tfaddrooms.getText();
			 String available = (String)tfavailable.getSelectedItem();
			 String cleaningstatus = (String)tfcleaningstatus.getSelectedItem();
			 String price = tfprice.getText();
			 String bedtype = (String)tfbedtype.getSelectedItem();   
			 
			 try {
				 Conn c = new Conn();
				 String query = "insert into AddRooms values ( '"+addrooms+"' , '"+available+"' , '"+cleaningstatus+"' , '"+price+"' , '"+bedtype+"')";
				 c.s.execute(query);
				 JOptionPane.showMessageDialog(null,"Room Booked Successfully");
				 setVisible(false);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		  } else {
			  setVisible(false);
		  }
		
		
		 
		 
	 }

	public static void main(String[] args) {
		new AddRooms();

	}

}
