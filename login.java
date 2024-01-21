import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class login extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField tf1;
	JPasswordField p1;
	JButton b1,b2;
	
	
	
	login()
	{
		setTitle("Login Page ");
		setLayout(null);
		l1 = new JLabel("Username");
		l1.setBounds(40,20,100,30);
		l2 = new JLabel("Password");
		l2.setBounds(40,70,100,30);
		tf1 = new JTextField();
		tf1.setBounds(150,20,150,30);
		p1 = new JPasswordField();
		p1.setBounds(150,70,150,30);
		add(l1);add(tf1);add(l2);add(p1);
		
		  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);
		
		b1 = new JButton("Login");
		b1.setBounds(40,140,120,30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180,140,120,30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		 getContentPane().setBackground(Color.WHITE);
		 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setSize(600,300);
        setLocation(400,150);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String a = tf1.getText();
		String b = p1.getText();
		if(ae.getSource()==b1)
		{
			if(a.equals("tejas") && b.equals("tejas"))
			{
				this.dispose();
				new dashboard();
				JOptionPane.showMessageDialog(this,"Got Access ");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Wrong Credentials ");
			}
		}
		if(ae.getSource()==b2)
		{
			System.exit(0);
		}
	}
		
		
		
	
	public static void main(String str[])
	{
		new login();
	}
}
		
		
	