package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
	
	Choice tfcustomerid;
	JTextField tfroomnumber,tfname,tfcheckintime,tfamountpaid,tfpendingdue;
	JButton check,update,back;
	
	 UpdateCheck() {
		 
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/updatecheck.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,340, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,20,600,400);
		add(image);
		
		
		JLabel heading = new JLabel("Update Status");
		heading.setBounds(120,50,150,30);
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
		
		JLabel name  = new JLabel("Name");
		name.setBounds(30,220,120,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(180,220,150,30);
		add(tfname);
		
		JLabel checkintime = new JLabel("Check in Time");
		checkintime.setBounds(30,270,120,30);
		checkintime.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(checkintime);
		
		tfcheckintime = new JTextField();
		tfcheckintime.setBounds(180,270,150,30);
		add(tfcheckintime);
		
		JLabel amountpaid = new JLabel("Amount Paid");
		amountpaid.setBounds(30,320,120,30);
		amountpaid.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(amountpaid);
		
		tfamountpaid = new JTextField();
		tfamountpaid.setBounds(180,320,150,30);
		add(tfamountpaid);
		
		JLabel pendingdue = new JLabel("Pending Amount");
		pendingdue.setBounds(30,370,150,30);
		pendingdue.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(pendingdue);

		
		
		tfpendingdue = new JTextField();
		tfpendingdue.setBounds(180,370,150,30);
		add(tfpendingdue);
		
		check = new  JButton("Check");
		check.setBounds(30,500,120,30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		add(check);
		
		update = new  JButton("Update");
		update.setBounds(180,500,120,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		back = new  JButton("Back");
		back.setBounds(320,500,120,30);
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
					 tfname.setText(rs.getString("name"));
					 tfcheckintime.setText(rs.getString("checkintime"));
					 tfamountpaid.setText(rs.getString("Deposit"));		 
				 }
				 ResultSet rs2 = c.s.executeQuery("select * from AddRooms");
				 while(rs2.next()) {
					 String price = rs2.getString("price");
					 int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfamountpaid.getText());
					 tfpendingdue.setText(""+amountpaid);
				 }
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 
		 } else if (ae.getSource()==update) {
			 String number = tfcustomerid.getSelectedItem();
			 String room = tfroomnumber.getText();
			 String name = tfname.getText();
			 String checkin = tfcheckintime.getText();
			 String deposit = tfamountpaid.getText();
			 
			 try {
				 Conn c = new Conn();
				 c.s.executeUpdate("update Customer set Room = '"+room+"' , name = '"+name+"' ,checkintime = '"+checkin+"',Deposit = '"+deposit+"' ");
				 
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
		new UpdateCheck();

	}

}
