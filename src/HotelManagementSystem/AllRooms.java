package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class AllRooms extends JFrame implements ActionListener{
	
	JLabel roomno,available,cleaned,price,bedtype;
	JTable table;
	JButton back;
	public AllRooms() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/AllRooms.jpg"));
		Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(470,0,600,570);
		add(image);
		
		roomno = new JLabel("Room No");
		roomno.setBounds(20,10,80,30);
		add(roomno);
		
		available = new JLabel("Available");
		available.setBounds(100,10,80,30);
		add(available);
		
		cleaned = new JLabel("CleanedStatus");
		cleaned.setBounds(190,10,90,30);
		add(cleaned);
		
		price = new JLabel("Price");
		price.setBounds(290,10,80,30);
		add(price);
		
		bedtype = new JLabel("Bed-Type");
		bedtype.setBounds(380,10,80,30);
		add(bedtype);
		
		table = new JTable();
		table.setBounds(0,40,470,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from AddRooms");
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
		new AllRooms();

	}

}
