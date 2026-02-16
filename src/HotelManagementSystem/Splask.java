package HotelManagementSystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Splask extends JFrame implements ActionListener{
	
	JButton next;
	JLabel text;
	Splask(){
		
		setLayout(null);
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/FireStarHotel.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1300, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,500);
		add(image);
		
		text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(50,420,1000,30);
		text.setFont(new Font("serif",Font.PLAIN,25));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		next = new JButton("Next");
		next.setBackground(Color.PINK);
		next.setBounds(600,400,100,25);
		next.setForeground(Color.CYAN);
		next.setFont(new Font("serif",Font.PLAIN,20));
		next.addActionListener(this);
		image.add(next);
		
		setBounds(250,370,900,500);
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			
			try {
				Thread.sleep(500);	
			} catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			
		try {
			Thread.sleep(500);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		
	}
	

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==next) {
			setVisible(false);
			new LoginPage().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Splask();
		
	}
	
	
}