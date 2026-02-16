package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
	
	JLabel document,number,name,gender,country,room,checkintime,deposit;
	JTable table;
	JButton back;
	public CustomerInfo() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		document = new JLabel("Document");
		document.setBounds(20,10,100,30);
		add(document);
		
		number = new JLabel("Number");
		number.setBounds(150,10,50,30);
		add(number);
		
		name = new JLabel("name");
		name.setBounds(280,10,50,30);
		add(name);
		
		gender = new JLabel("gender");
		gender.setBounds(420,10,50,30);
		add(gender);
		
		country = new JLabel("Country");
		country.setBounds(550,10,50,30);
		add(country);
		
		room = new JLabel("Room");
		room.setBounds(680,10,50,30);
		add(room);
		
		checkintime = new JLabel("Checkintime");
		checkintime.setBounds(820,10,100,30);
		add(checkintime);
		
		deposit = new JLabel("Deposit");
		deposit.setBounds(950,10,50,30);
		add(deposit);
		
		table = new JTable();
		table.setBounds(0,40,1050,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from Customer ");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new  JButton("Back");
		back.setBounds(300,500,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setBounds(250,300,1050,600);
		setVisible(true);
	}
	

	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception().setVisible(true);
	}
	

	public static void main(String[] args) {
		new CustomerInfo();

	}

}