package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class AddCustomerForm extends JFrame implements ActionListener{
	
	JLabel lcit;
	JButton addcustomer,back;
	JComboBox cid;
	JTextField tfnum,tfname,tfdeposit,tfcountry;
	JRadioButton male,female;
	Choice croom;
	 AddCustomerForm() {
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/addEmployee.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(350,350, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(400,10,500,450);
		 add(image);
		 
		 
		 setLayout(null);
		 getContentPane().setBackground(Color.WHITE);
		 setBounds(250,300,850,550);
		 
		 JLabel customerform = new JLabel("NEW CUSTOMER FORM");
		 customerform.setBounds(120,30,300,40);
		 customerform.setFont(new Font("Tahoma",Font.PLAIN,17));
		 customerform.setForeground(Color.BLUE);
		 add(customerform);
		 
		 
		 JLabel id = new JLabel("ID");
		 id.setFont(new Font("Raleway",Font.BOLD,15));
		 id.setBounds(40,80,100,30);
		 add(id);
		 
		 String customerid [] = {"Passport","Aadhar-Card","Voter-ID","Driving-Licence","Ration-Card"};
		 cid = new JComboBox(customerid);
		 cid.setBounds(250,80,150,30);
		 cid.setBackground(Color.WHITE);
		 add(cid);
		 
		 JLabel number = new JLabel("Number");
		 number.setFont(new Font("Raleway",Font.BOLD,15));
		 number.setBounds(40,120,100,30);
		 add(number);
		 
		 tfnum = new JTextField();
		 tfnum.setBounds(250,120,150,30);
		 tfnum.setBackground(Color.WHITE);
		 add(tfnum);
		 		 
		 JLabel name = new JLabel("Name");
		 name.setFont(new Font("Raleway",Font.BOLD,15));
		 name.setBounds(40,160,100,30);
		 add(name);
		 
		 tfname = new JTextField();
		 tfname.setBounds(250,160,150,30);
		 tfname.setBackground(Color.WHITE);
		 add(tfname);
		 
		 JLabel gender = new JLabel("Gender");
		 gender.setFont(new Font("Raleway",Font.BOLD,15));
		 gender.setBounds(40,200,100,30);
		 add(gender);
		 
		 male = new JRadioButton("Male");
		 male.setBounds(250,200,70,30);
		 male.setBackground(Color.WHITE);
		 add(male);
		 
		 female = new JRadioButton("Female");
		 female.setBounds(330,200,100,30);
		 female.setBackground(Color.WHITE);
		 add(female);
		 
		 ButtonGroup groupp = new ButtonGroup();
		 groupp.add(male);
		 groupp.add(female);
		  
		 JLabel country = new JLabel("Country");
		 country.setFont(new Font("Raleway",Font.BOLD,15));
		 country.setBounds(40,240,100,30);
		 add(country);
		 
		 tfcountry = new JTextField();
		 tfcountry.setBounds(250,240,150,30);
		 tfcountry.setBackground(Color.WHITE);
		 add(tfcountry);
		 
		 
		 JLabel arn = new JLabel("Allocated Room Number");
		 arn.setFont(new Font("Raleway",Font.BOLD,15));
		 arn.setBounds(40,280,200,30);
		 add(arn);
		 
		 croom = new Choice();
		 try {
			 Conn c = new Conn();
			 String query = "select * from AddRooms where availability = 'Available '";
			 ResultSet rs = c.s.executeQuery(query);
			 while(rs.next()) {
				 croom.add(rs.getString("Roomnumber"));
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 croom.setBounds(250,280,150,30);
		 add(croom);

		 
		 
		 JLabel cit = new JLabel("Check in Time");
		 cit.setFont(new Font("Raleway",Font.BOLD,15));
		 cit.setBounds(40,320,200,30);
		 add(cit);
		 
		 Date date = new Date();		 
		 
		 lcit = new JLabel(""+date);
		 lcit.setFont(new Font("Raleway",Font.BOLD,15));
		 lcit.setBounds(250,320,250,30);
		 add(lcit);
		  
		 JLabel deposit = new JLabel("Deposit");
		 deposit.setFont(new Font("Raleway",Font.BOLD,15));
		 deposit.setBounds(40,360,100,30);
		 add(deposit);
		 
		 tfdeposit = new JTextField();
		 tfdeposit.setBounds(250,360,150,30);
		 tfdeposit.setBackground(Color.WHITE);
		 add(tfdeposit);
		 
		addcustomer = new JButton("Add Customer");
		addcustomer.setBounds(60,420,120,25);
		addcustomer.setForeground(Color.WHITE);
		addcustomer.setBackground(Color.BLACK);
		addcustomer.addActionListener(this);
		add(addcustomer);
			
		back = new JButton("Back");
	    back.setBounds(210,420,120,25);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		 
		 setVisible(true);
		 
		 
		
	}
	 public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource()==addcustomer) {
			 String document = (String)cid.getSelectedItem();
			 String number = tfnum.getText();
			 String name = tfname.getText();
			 String gender = null;
			 if (male.isSelected()) {
				 gender = "Male";
			 } else if (female.isSelected()) {
				 gender = "Female";
			 }
			 String country =tfcountry.getText();
			 String allotedroom = croom.getSelectedItem();
			 String time = lcit.getText();
			 String deposit = tfdeposit.getText();
			
			 try {
				String query = "insert into Customer values ('"+document+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+allotedroom+"','"+time+"','"+deposit+"') ";
				String query2 = "update AddRooms set availability = 'Occupied' where Roomnumber='"+allotedroom+"'";
				
			      if (name.isEmpty() || number.isEmpty() || gender.isEmpty() || deposit.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please fill all required fields!");
		                return;
		            }
				
				Conn c = new Conn();
				c.s.executeUpdate(query);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
				setVisible(false);
				new Reception().setVisible(true);
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 } else if (ae.getSource()==back){
			 setVisible(false);
			 new Reception().setVisible(true);
		 }
		 
	 }

	public static void main(String[] args) {
		new AddCustomerForm();

	}

}
