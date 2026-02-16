package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class DriverInformation extends JFrame implements ActionListener{
	
	JTable table;
	JCheckBox available;
	Choice  cartype;
	JButton submit,back;
	
	public DriverInformation() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		

		
	    JLabel driver = new JLabel("Search for Driver");
	    driver.setBounds(450,50,250,30);
	    driver.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(driver);
		
	    JLabel carmodel = new JLabel("Car-model");
	    carmodel.setBounds(50,100,100,30);
	    carmodel.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(carmodel);
		
		cartype = new Choice();
		cartype.setBounds(170,100,150,30);
		cartype.setBackground(Color.WHITE);
		add(cartype);
		
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from AddDriver");
			while(rs.next()) {
				cartype.add(rs.getString("carmodel"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		
		JLabel name = new JLabel("Name");
		name.setBounds(20,200,80,30);
		add(name);
		
		JLabel  age = new JLabel("Age");
		age.setBounds(190,200,80,30);
		add(age);
		
		JLabel gender = new JLabel("gender");
		gender.setBounds(350,200,80,30);
		add(gender);
		
		JLabel carcompany = new JLabel("carcompany");
		carcompany.setBounds(480,200,80,30);
		add(carcompany);
		
		JLabel carmocel = new JLabel("carmodel");
		carmocel.setBounds(630,200,80,30);
		add(carmocel);
		
		JLabel available = new JLabel("available");
		available.setBounds(750,200,80,30);
		add(available);
		
		JLabel location = new JLabel("location");
		location.setBounds(900,200,80,30);
		add(location);
	
		submit = new  JButton("Submit");
		submit.setBounds(350,500,120,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		back = new  JButton("Back");
		back.setBounds(550,500,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		table = new JTable();
		table.setBounds(0,240,1050,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from AddDriver");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		setBounds(250,300,1050,600);
		setVisible(true);
		
	}
	

	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==submit) {
			String CarType = cartype.getSelectedItem();
			
			try {	
				String query1 = "select * from AddDriver where carmodel = '"+CarType+"' ";
				Conn conn = new Conn();
			   ResultSet  rs2 = conn.s.executeQuery(query1);
			   while(rs2.next()) {
				  table.setModel(DbUtils.resultSetToTableModel(rs2));
			   }
			   
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Reception();
		}
	}



	public static void main(String[] args) {
		new DriverInformation();

	}

}
