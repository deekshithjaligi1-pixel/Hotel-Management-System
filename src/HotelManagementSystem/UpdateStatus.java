package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class UpdateStatus extends JFrame implements ActionListener{
	
	Choice tfcustomerid;
	JTextField tfroomnumber,tfname,tfcheckintime,tfava,tfcleaning;
	JButton check,update,back;
	
	UpdateStatus() {
		 
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/updatecheck.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,340, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,20,600,400);
		add(image);
		
		JLabel heading = new JLabel("Update Room Status");
		heading.setBounds(100,50,250,30);
		heading.setFont(new Font("Tahoma",Font.PLAIN,20));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel customerid = new JLabel("Customer Id");
		customerid.setBounds(30,120,120,30);
		customerid.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(customerid);
		
		tfcustomerid = new Choice();
		tfcustomerid.setBounds(180,120,150,30);
		add(tfcustomerid);
		
		
		try {
			Conn c = new Conn();
			String query = "select * from Customer";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				tfcustomerid.add(rs.getString("number"));
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		JLabel roomnumber = new JLabel("Room Number");
		roomnumber.setBounds(30,170,120,30);
		roomnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(roomnumber);
		
		tfroomnumber = new JTextField();
		tfroomnumber.setBounds(180,170,150,30);
		add(tfroomnumber);
		
		JLabel availability  = new JLabel("Availability");
		availability.setBounds(30,220,120,30);
		availability.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(availability);
		
		tfava = new JTextField();
		tfava.setBounds(180,220,150,30);
		add(tfava);
		
		JLabel cleaning  = new JLabel("Cleaning Status");
		cleaning.setBounds(30,270,120,30);
		cleaning.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(cleaning);
		
		tfcleaning = new JTextField();
		tfcleaning.setBounds(180,270,150,30);
		add(tfcleaning);
		
		

		
		check = new  JButton("Check");
		check.setBounds(30,350,120,30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		add(check);
		
		update = new  JButton("Update");
		update.setBounds(180,350,120,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		back = new  JButton("Back");
		back.setBounds(320,350,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		
		setBounds(250,300,1050,600);	
		setVisible(true);
	}
	 public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==check) {
			String document = tfcustomerid.getSelectedItem();
			 String query = "select * from Customer where number = '"+document+"' ";
			 try {
				 
				 Conn c = new Conn();
				 ResultSet rs = c.s.executeQuery(query);
				 while(rs.next()) {
					 tfroomnumber.setText(rs.getString("Room"));
				 }
				 
				 ResultSet rs2 = c.s.executeQuery("select * from AddRooms where Roomnumber = '"+tfroomnumber.getText()+"'");
				 while(rs2.next()) {
					 tfava.setText(rs2.getString("availability"));
					 tfcleaning.setText(rs2.getString("cleaningStatus"));
				 }
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 
		 } else if (ae.getSource()==update) {
			 String room = tfroomnumber.getText();
			 try {
				 Conn c = new Conn();
				 c.s.executeUpdate("update AddRooms set availability = '"+tfava.getText()+"' , cleaningStatus  = '"+tfcleaning.getText()+"' where Roomnumber = '"+room+"'  ");
				 
				 JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				 setVisible(false);
				 new Reception().setVisible(false);
			 }catch(Exception e ) {
				 e.printStackTrace();
			 }
			 
		 } else {
			 setVisible(false);
			 new Reception().setVisible(true);
		 }
	 }

	public static void main(String[] args) {
		new UpdateStatus();

	}

}