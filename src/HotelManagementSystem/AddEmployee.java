package HotelManagementSystem;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfname, tfage , tfsalary,tfphone,tfemail,tfaadhar;
	JRadioButton male,female;
	JComboBox jobbox;
	JButton submit,back;
	
	AddEmployee() {
		
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/AddCustomer.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(350,350, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(350,10,500,450);
		 add(image);
		
		setLayout(null);
		setBounds(350,200,850,560);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel Employee = new JLabel("Employee");
		Employee.setBounds(200,10,150,30);
		Employee.setFont(new Font("Raleway",Font.BOLD,20));
		add(Employee);
		
		JLabel name = new JLabel("NAME");
		name.setBounds(80,50,90,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(200,50,200,30);
		add(tfname);
		
		
		JLabel age = new JLabel("AGE");
		age.setBounds(80,100,100,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(age);
		
		tfage = new JTextField();
		tfage.setBounds(200,100,200,30);
		add(tfage);
		
		JLabel gender = new JLabel("GENDER");
		gender.setBounds(80,150,100,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(200,150,100,25);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(300,150,100,25);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup groupbutton = new ButtonGroup();
		groupbutton.add(male);
		groupbutton.add(female);
		
		
		JLabel job = new JLabel("JOB");
		job.setBounds(80,200,100,30);
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(job);
		
		String jobfields [] =  {"Front Desk Clerks","Porters","Housekeepings ","Kitchen Staff","Room Services","Chefs","Waiter/Waiteress","Manager","Accountant"};
		jobbox = new JComboBox(jobfields);
		jobbox.setBounds(200,200,200,30);
		jobbox.setBackground(Color.WHITE);
		add(jobbox);
				
		
		JLabel salary = new JLabel("SALARY");
		salary.setBounds(80,250,100,30);
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(salary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(200,250,200,30);
		add(tfsalary);
		
		JLabel phone = new JLabel("PHONE");
		phone.setBounds(80,300,100,30);
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(phone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200,300,200,30);
		add(tfphone);
		
		
		JLabel email = new JLabel("EMAIL");
		email.setBounds(80,350,100,30);
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(email);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,350,200,30);
		add(tfemail);
		
		JLabel aadhar = new JLabel("AADHAR");
		aadhar.setBounds(80,400,100,30);
		aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(aadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200,400,200,30);
		add(tfaadhar);
		
		submit = new JButton("SUBMIT");
		submit.setBounds(50,450,150,30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		back = new JButton("BACK");
		back.setBounds(250,450,150,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		
		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==submit) {
			
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();
		
		String gender = null;
		 if (male.isSelected()) {
			 gender = "Male";
		 } else if (female.isSelected()) {
			 gender = "Female";
		 }
		 
		 String job = (String)jobbox.getSelectedItem();
		  
		 try {
			 Conn conn = new Conn(); 
			 String query = "insert into employee values ('"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			 conn.s.executeUpdate(query);
			 JOptionPane.showMessageDialog(null, "Employee Details added Successfully");
			 setVisible(false);
			 	 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 	
	}else {
		setVisible(false);
		new DashBoard().setVisible(true);
	}
	}
		public static void main(String [] args) {
			new AddEmployee();
		}

}
