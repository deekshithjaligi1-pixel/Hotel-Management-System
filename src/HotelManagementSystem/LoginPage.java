package HotelManagementSystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
	
	JTextField tfusername;
	JPasswordField tfpassword;
	JButton clear,Signin;

	 LoginPage() {
		 setLayout(null);
		 getContentPane().setBackground(Color.WHITE);
		 setBounds(300,300,650,400);
		 
		 JLabel username = new JLabel("Username");
		 username.setBounds(50,40,150,30);
		 username.setFont(new Font("Raleway",Font.BOLD,15));
		 add(username);
		 
		 tfusername = new JTextField();
		 tfusername.setBounds(170,40,200,30);
		 add(tfusername);
		 
		 JLabel password = new JLabel("Password");
		 password.setBounds(50,90,150,30);
		 password.setFont(new Font("Raleway",Font.BOLD,15));
		 add(password);
		 
		 tfpassword = new JPasswordField();
		 tfpassword.setBounds(170,90,200,30);
		 add(tfpassword);
		 
		 clear = new JButton("Clear");
		 clear.setBounds(100,150,100,25);
		 clear.setFont(new Font("Raleway",Font.BOLD,15));
		 clear.setForeground(Color.WHITE);
		 clear.setBackground(Color.BLACK);
		 clear.addActionListener(this);
		 add(clear);
		 
		 Signin = new JButton("Sign In");
		 Signin.setBounds(250,150,100,25);
		 Signin.setFont(new Font("Raleway",Font.BOLD,15));
		 Signin.setForeground(Color.WHITE);
		 Signin.setBackground(Color.BLACK);
		 Signin.addActionListener(this);
		 add(Signin);
		 
		
		 
		 setVisible(true);
		 
	}
	 public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource()==clear) {
			 tfusername.setText("");
			 tfpassword.setText("");
		 } else if (ae.getSource()== Signin) {
			 String username = tfusername.getText();
			 String password = tfpassword.getText();
			 
			 try {
				 Conn c = new Conn();
				 String query = "select * from Login where username ='"+username+"' and password = '"+password+"' ";
				 ResultSet rs = c.s.executeQuery(query);
				 if (rs.next()) {
					 setVisible(false);
					 new DashBoard().setVisible(true);
				 } else {
					 JOptionPane.showMessageDialog(null,"InCorrect Username or Password ");
					 setVisible(false);
				 }	 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 
			 
		 } 

	 }

	public static void main(String[] args) {
		new LoginPage();

	}

}
