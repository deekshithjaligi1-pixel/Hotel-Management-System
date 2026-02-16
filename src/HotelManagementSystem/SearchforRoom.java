package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class SearchforRoom extends JFrame implements ActionListener{
	
	JTable table;
	JCheckBox available;
	JComboBox bedtype;
	JButton submit,back;
	
	public SearchforRoom() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		

		
	    JLabel heading = new JLabel("Search for Room");
		heading.setBounds(450,50,250,30);
		heading.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(heading);
		
	    JLabel labelbed = new JLabel("Bed-Type");
	    labelbed.setBounds(50,100,100,30);
	    labelbed.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(labelbed);

		
		
		bedtype = new JComboBox(new String[] {"Single Bed","Double Bed"});
		bedtype.setBounds(170,100,150,30);
		bedtype.setBackground(Color.WHITE);
		add(bedtype);
		
		available = new JCheckBox("Only Display Available");
		available.setBounds(800,100,200,30);
		available.setBackground(Color.WHITE);
		available.setFont(new Font("Tahoma",Font.PLAIN,17));
		available.addActionListener(this);
		add(available);
		
		
		JLabel roomno = new JLabel("Room No");
		roomno.setBounds(20,200,80,30);
		add(roomno);
		
		JLabel  available = new JLabel("Availability");
		available.setBounds(300,200,80,30);
		add(available);
		
		JLabel cleaned = new JLabel("Cleaned Status");
		cleaned.setBounds(450,200,90,30);
		add(cleaned);
		
		JLabel price = new JLabel("Price");
		price.setBounds(650,200,80,30);
		add(price);
		
		JLabel bedtype = new JLabel("Bed-Type");
		bedtype.setBounds(850,200,80,30);
		add(bedtype);
	
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
			ResultSet rs = c.s.executeQuery("select * from AddRooms");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		setBounds(250,300,1050,600);
		setVisible(true);
		
	}
	

	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==submit) {
			try {	
				String query1 = "select * from AddRooms where Bed_Type ='"+bedtype.getSelectedItem()+"'";
				String query2 = "select * from AddRooms where availability = 'Available ' AND Bed_Type='"+bedtype.getSelectedItem()+"' ";
				
			Conn conn = new Conn();
			ResultSet rs;
			if (available.isSelected()) {
				rs = conn.s.executeQuery(query1);
			} else {
				rs = conn.s.executeQuery(query2);
			}
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Reception().setVisible(true);
		}
	}



	public static void main(String[] args) {
		new SearchforRoom();

	}

}

