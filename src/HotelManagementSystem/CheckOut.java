package HotelManagementSystem;

import java.util.Date;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener{

	JLabel tfroomnum,tfcheckin,tfcheckout;
	JButton buttoncheckout,back;
	Choice number;
	 CheckOut()  {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel checkout = new JLabel("Check Out");
		checkout.setBounds(150,50,150,30);
		checkout.setFont(new Font("Tahoma",Font.PLAIN,17));
		checkout.setForeground(Color.BLUE);
		add(checkout);
		
		number = new Choice();
		number.setBounds(170,100,150,30);
		add(number);
		
		
		JLabel customerid = new JLabel("Custumer Id");
		customerid.setBounds(30,100,150,30);
		customerid.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(customerid);
		
		
		JLabel roomnum = new JLabel("Room Number");
		roomnum.setBounds(30,150,150,30);
		roomnum.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(roomnum);
		
		tfroomnum = new JLabel();
		tfroomnum.setBounds(185,150,150,30);
		tfroomnum.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(tfroomnum);
		
		JLabel checkin = new JLabel("Check Time");
		checkin.setBounds(30,200,150,30);
		checkin.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(checkin);
		
		Date date = new Date();
		tfcheckin = new JLabel(""+date);
		tfcheckin.setBounds(185,200,200,30);
		tfcheckin.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(tfcheckin);
		
		JLabel checkoutt = new JLabel("Check Time");
		checkoutt.setBounds(30,250,150,30);
		checkoutt.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(checkoutt);
		
		tfcheckout = new JLabel(""+date);
		tfcheckout.setBounds(185,250,200,30);
		tfcheckout.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(tfcheckout);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from Customer");
			while(rs.next()) {
				number.add(rs.getString("number"));
				tfroomnum.setText(rs.getString("Room"));
				tfcheckin.setText(rs.getString("checkintime"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		buttoncheckout = new JButton("CheckOut");
		buttoncheckout.setBounds(30,300,120,30);
		buttoncheckout.setBackground(Color.BLACK);
		buttoncheckout.setForeground(Color.WHITE);
		buttoncheckout.addActionListener(this);
		add(buttoncheckout);
		
		back = new  JButton("Back");
		back.setBounds(180,300,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		
		setBounds(200,350,850,450);
		setVisible(true);
		
	}
	 
	 public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource()==buttoncheckout) {
			String query1 = "delete from Customer where number = '"+number.getSelectedItem()+"'";
			String query2 = "update AddRooms set availability= 'Available ' where Roomnumber ='"+tfroomnum.getText()+"' ";	
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"CheckOut Done Successfully!");
				setVisible(false);
				new Reception().setVisible(true);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
			 
		 } else {
			 setVisible(false);
			 new Reception().setVisible(true);
		 }
		 
	 }
	 

	public static void main(String[] args) {
		new CheckOut();

	}

}
