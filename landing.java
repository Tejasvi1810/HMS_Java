import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class landing extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1;
	landing()
	{
		 setSize(1366,430);        
		 setLayout(null);
		 setTitle("Landing Page ");
         setLocation(100,100);
		
		l1 = new JLabel(" ");
		 //l1.setFont(new Font("serif",Font.PLAIN,40));
		b1 = new JButton("Next");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		
		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
				
				   JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(30,300,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,70));
                lid.setForeground(Color.magenta);
                l1.add(lid);
		
		
		
		
		b1.setBounds(1170,325,150,50);
		l1.setBounds(0, 0, 1366, 390);
		
		 l1.add(b1);
		add(l1);
                
		b1.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		while(true)
		{
			lid.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception ae)
			{
				ae.printStackTrace();
			}
			
			lid.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception aee)
			{
				aee.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			this.dispose();
			new login();
		}
	}
	public static void main(String str[])
	{
		new landing();
	}
}