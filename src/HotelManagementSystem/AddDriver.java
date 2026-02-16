package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener{
	
	JTextField tfname,tfage,tfcarcompany,tfcarmodel,tflocation;
	JComboBox tfgender,tfavailable;
	JButton adddriver,cancel;
	
	AddDriver()  {
		setLayout(null);
		setBounds(300,250,940,530);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Driver.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,340, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,20,600,400);
		add(image);
		
		JLabel addrooms = new JLabel("Add Drivers");
		addrooms.setBounds(180,30,100,30);
		addrooms.setFont(new Font("Raleway",Font.BOLD,17));
		add(addrooms);
		
		
		JLabel roomnumber = new JLabel("Name");
		roomnumber.setBounds(70,100,150,25);
		roomnumber.setFont(new Font("Raleway",Font.PLAIN,17));
		add(roomnumber);
		
		tfname = new JTextField();
		tfname.setBounds(230,100,150,30);
		add(tfname);
		
		JLabel age = new JLabel("Age");
		age.setBounds(70,150,150,25);
		age.setFont(new Font("Raleway",Font.PLAIN,17));
		add(age);
		
		tfage = new JTextField();
		tfage.setBounds(230,150,150,30);
		add(tfage);
		
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(70,200,150,25);
		gender.setFont(new Font("Raleway",Font.PLAIN,17));
		add(gender);
		
		
		String cgender [] = {"Male","Female"};
		tfgender = new JComboBox(cgender);
		tfgender.setBackground(Color.WHITE);
		tfgender.setBounds(230,200,150,25);
		add(tfgender);
		
		JLabel carcompany = new JLabel("Car Company");
		carcompany.setBounds(70,250,150,25);
		carcompany.setFont(new Font("Raleway",Font.PLAIN,17));
		add(carcompany);
		
		tfcarcompany = new JTextField();
		tfcarcompany.setBounds(230,250,150,30);
		add(tfcarcompany);
		
		JLabel carmodel = new JLabel("Car Model");
		carmodel.setBounds(70,300,150,25);
		carmodel.setFont(new Font("Raleway",Font.PLAIN,17));
		add(carmodel);
		
		tfcarmodel = new JTextField();
		tfcarmodel.setBounds(230,300,150,30);
		add(tfcarmodel);
		
		JLabel ab = new JLabel("Available");
		ab.setBounds(70,350,150,30);
		ab.setFont(new Font("Raleway",Font.PLAIN,17));
		add(ab);
		
		String cavailable [] = {"Available","Not-Available"};
		tfavailable = new JComboBox(cavailable);
		tfavailable.setBackground(Color.WHITE);
		tfavailable.setBounds(230,350,150,25);
		add(tfavailable);
		
		JLabel location = new JLabel("Location");
		location.setBounds(70,400,150,25);
		location.setFont(new Font("Raleway",Font.PLAIN,17));
		add(location);
		
		
		tflocation = new JTextField();
		tflocation.setBounds(230,400,150,30);
		add(tflocation);
		
		
		
		adddriver = new JButton("Add Driver");
		adddriver.setBounds(80,440,100,30);
		adddriver.setForeground(Color.WHITE);
		adddriver.setBackground(Color.BLACK);
		adddriver.addActionListener(this);
		add(adddriver);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(250,440,100,30);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	 public void actionPerformed(ActionEvent ae) {
		  if (ae.getSource()==adddriver) { 
			 String name = tfname.getText();
			 String age = tfage.getText();
			 String gender = (String)tfgender.getSelectedItem();
			 String carcompany = tfcarcompany.getText();
			 String carmodel = tfcarmodel.getText();
			 String available = (String)tfavailable.getSelectedItem();
			 String location = tflocation.getText();
			 
			 try {
				 Conn c = new Conn();
				 String query = "insert into AddDriver values ( '"+name+"' , '"+age+"' , '"+gender+"' , '"+carcompany+"' , '"+carmodel+"','"+available+"','"+location+"')";
				 c.s.execute(query);
				 JOptionPane.showMessageDialog(null,"Driver Booked Successfully");
				 setVisible(false);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		  } else {
			  setVisible(false);
		  }
		
		
		 
		 
	 }

	public static void main(String[] args) {
		new AddDriver();

	}

}
