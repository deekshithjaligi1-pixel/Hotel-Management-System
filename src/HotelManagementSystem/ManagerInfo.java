package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{
	
	JLabel name,age,gender,job,salary,phone,email,aadhar;
	JTable table;
	JButton back;
	public ManagerInfo() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		name = new JLabel("Name");
		name.setBounds(20,10,40,30);
		add(name);
		
		age = new JLabel("Age");
		age.setBounds(150,10,40,30);
		add(age);
		
		gender = new JLabel("Gender");
		gender.setBounds(280,10,50,30);
		add(gender);
		
		job = new JLabel("Job");
		job.setBounds(420,10,50,30);
		add(job);
		
		salary = new JLabel("Salary");
		salary.setBounds(550,10,50,30);
		add(salary);
		
		phone = new JLabel("Phone");
		phone.setBounds(680,10,50,30);
		add(phone);
		
		email = new JLabel("Email");
		email.setBounds(820,10,100,30);
		add(email);
		
		aadhar = new JLabel("Aadhar");
		aadhar.setBounds(950,10,50,30);
		add(aadhar);
		
		table = new JTable();
		table.setBounds(0,40,1050,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee where Job ='Manager'");
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
		new ManagerInfo();

	}

}