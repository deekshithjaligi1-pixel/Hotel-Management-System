package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
	
	JLabel department,budget;
	JTable table;
	JButton back;
	public Department() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		department = new JLabel("Department");
		department.setBounds(160,10,80,30);
		add(department);
		

		
		budget = new JLabel("Budget");
		budget.setBounds(520,10,80,30);
		add(budget);
		
		table = new JTable();
		table.setBounds(0,40,800,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from Department");
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
		
		setBounds(250,300,800,600);
		setVisible(true);
	}
	

	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception().setVisible(true);
	}
	

	public static void main(String[] args) {
		new Department();

	}

}