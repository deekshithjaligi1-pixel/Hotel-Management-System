package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener{
	
	JButton addemployee,rooms,department,allemployees,customerinfo;
	JButton managerinfo,checkout,updatepost,updateroomstats;
	JButton driverservice,serviceroom,logout;
	 Reception() {
		 
		 setLayout(null);

		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Reception.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		 ImageIcon i3  = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(400,20,500,450);
		 add(image);
		 
		 
		 addemployee =  new JButton("New Customer");
		 addemployee.setBounds(10,30,200,30);
		 addemployee.setBackground(Color.BLACK);
		 addemployee.setForeground(Color.WHITE);
		 addemployee.addActionListener(this);
		 add(addemployee);
		 
		 rooms =  new JButton("Rooms");
		 rooms.setBounds(10,70,200,30);
		 rooms.setBackground(Color.BLACK);
		 rooms.setForeground(Color.WHITE);
		 rooms.addActionListener(this);
		 add(rooms);
		 
		 department =  new JButton("Department");
		 department.setBounds(10,110,200,30);
		 department.setBackground(Color.BLACK);
		 department.setForeground(Color.WHITE);
		 department.addActionListener(this);
		 add(department);
		 
		 allemployees =  new JButton("All Employees");
		 allemployees.setBounds(10,150,200,30);
		 allemployees.setBackground(Color.BLACK);
		 allemployees.setForeground(Color.WHITE);
		 allemployees.addActionListener(this);
		 add(allemployees);
		 
		 customerinfo =  new JButton("Customer Info");
		 customerinfo.setBounds(10,190,200,30);
		 customerinfo.setBackground(Color.BLACK);
		 customerinfo.setForeground(Color.WHITE);
		 customerinfo.addActionListener(this);
		 add(customerinfo);
		 
		 managerinfo =  new JButton("Manager Info");
		 managerinfo.setBounds(10,230,200,30);
		 managerinfo.setBackground(Color.BLACK);
		 managerinfo.setForeground(Color.WHITE);
		 managerinfo.addActionListener(this);
		 add(managerinfo);
		 
		 checkout =  new JButton("CheckOut");
		 checkout.setBounds(10,270,200,30);
		 checkout.setBackground(Color.BLACK);
		 checkout.setForeground(Color.WHITE);
		 checkout.addActionListener(this);
		 add(checkout);
		 
		 updatepost =  new JButton(" Update Status");
		 updatepost.setBounds(10,310,200,30);
		 updatepost.setBackground(Color.BLACK);
		 updatepost.setForeground(Color.WHITE);
		 updatepost.addActionListener(this);
		 add(updatepost);
		 
		 updateroomstats =  new JButton("Update Room Status");
		 updateroomstats.setBounds(10,350,200,30);
		 updateroomstats.setBackground(Color.BLACK);
		 updateroomstats.setForeground(Color.WHITE);
		 updateroomstats.addActionListener(this);
		 add(updateroomstats);
		 
		 driverservice =  new JButton("Driver Services");
		 driverservice.setBounds(10,390,200,30);
		 driverservice.setBackground(Color.BLACK);
		 driverservice.setForeground(Color.WHITE);
		 driverservice.addActionListener(this);
		 add(driverservice);
		 
		 serviceroom =  new JButton("Service Room");
		 serviceroom.setBounds(10,430,200,30);
		 serviceroom.setBackground(Color.BLACK);
		 serviceroom.setForeground(Color.WHITE);
		 serviceroom.addActionListener(this);
		 add(serviceroom);
		 
		 logout =  new JButton("Logout");
		 logout.setBounds(10,470,200,30);
		 logout.setBackground(Color.BLACK);
		 logout.setForeground(Color.WHITE);
		 logout.addActionListener(this);
		 add(logout);
		 
		 setBounds(300,250,940,560);
		 getContentPane().setBackground(Color.WHITE);
		 setVisible(true);

	}
	 public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource()==addemployee) {
			 setVisible(false);
			 new AddCustomerForm().setVisible(true);
		 } else if (ae.getSource()==rooms) {
			 setVisible(false);
			 new AllRooms().setVisible(true);
		 } else if (ae.getSource()==department) {
			 setVisible(false);
			 new Department().setVisible(true);
		 } else if (ae.getSource()==allemployees) {
			 setVisible(false);
			 new EmployeeInfo().setVisible(true);
		 }  else if (ae.getSource()==customerinfo) {
			 setVisible(false);
			 new CustomerInfo().setVisible(true);
		 } else if (ae.getSource()==managerinfo) {
			 setVisible(false);
			 new ManagerInfo().setVisible(true);
		 } else if (ae.getSource()==checkout) {
			 setVisible(false);
			 new CheckOut().setVisible(true);
		 }  else if (ae.getSource()==updatepost) {
			 setVisible(false);
			 new UpdateCheck().setVisible(true);
		 }  else if (ae.getSource()==updateroomstats) {
			 setVisible(false);
			 new UpdateStatus().setVisible(true);
		 } else if (ae.getSource()==driverservice) {
			 setVisible(false);
			 new DriverInformation().setVisible(true);
		 } else if (ae.getSource()==serviceroom) {
			setVisible(false);
			new ServiceRoom();
		 }else if (ae.getSource()==logout) {
			 setVisible(false);
			 System.exit(0);
		 }
		 
	 }


	public static void main(String[] args) {
		new Reception();

	}

}
