import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class add_driver extends JFrame implements ActionListener
{
	
	JTextField tf1,tf2,tf3,tf4,tf5;
	JComboBox cb1,cb2;
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2;
	Connection con;
		Statement stmt;
	
	add_driver()
	{
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add Drivers ");
		
		setSize(778,486);
		setLayout(null);
	
	l = new JLabel("Adding Driver Detail");
		l.setForeground(Color.BLUE);
            l.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l1 = new JLabel("Name");
		l2 = new JLabel("ID");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Car company");
		l5 = new JLabel("Car model");
		l6 = new JLabel("Avaliable");
		l7 = new JLabel("Location");
		
		tf1 = new JTextField(30);
		tf2 = new JTextField(30);
		tf3 = new JTextField(30);
		tf4 = new JTextField(30);
		tf5 = new JTextField(30);
		
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		
		cb1.addItem("Male");
		cb1.addItem("Female");
		
		
		cb2.addItem("Available");
		cb2.addItem("Occupied");
		
		b1 = new JButton("Add");
		b2 = new JButton("Cancel");
		
		add(l);add(l1);add(tf1);
		add(l2);add(tf2);add(l3);add(cb1);add(l4);add(tf3);
		add(l5);add(tf4);add(l6);add(cb2);add(l7);add(tf5);
		add(b1);add(b2);
		
		l.setBounds(350,24,442,35);
		l1.setBounds(60,30,150,27);
		tf1.setBounds(150,35,120,20);
		l2.setBounds(60,60,150,27);
		tf2.setBounds(150,65,120,20);
		l3.setBounds(60,90,150,27);
		cb1.setBounds(150,95,120,20);
		
		l4.setBounds(60,120,150,27);
		tf3.setBounds(150,125,120,20);
		l5.setBounds(60,150,150,27);
		tf4.setBounds(150,155,120,20);
		l6.setBounds(60,190,150,27);
		cb2.setBounds(150,195,120,20);
		l7.setBounds(60,220,150,27);
		tf5.setBounds(150,225,120,20);
		
		b1.setBounds(30,300,120,50);
		b2.setBounds(200,300,120,50);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("anup.jpg"));
            Image i3 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(350,10,330,410);
            add(image);
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				//ResultSet rs = rs.stmt.executeQuery(s1)
				System.out.println("Connected");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			// create table add_driver(Name varchar(20),ID int,Gender varchar(20),Car_company varchar(20),Car_model varchar(20),Available varchar(20),Location varchar(20)
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String str[])
	{
		new add_driver();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		 
		
		if(ae.getSource()==b1)
		{
			//String s2 = null;
			//  String s2 = cb.getSelectedItem();
			String s1 = "insert into add_driver values('"+tf1.getText()+"',"+tf2.getText()+",'"+cb1.getSelectedItem()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+cb2.getSelectedItem()+"','"+tf5.getText()+"')";
			
			
			
			stmt.executeUpdate(s1);
			
			//b1.setEnabled(false);
			JOptionPane.showMessageDialog(this,"Record saved succesfully !");
		}
		else if(ae.getSource()==b2)
		{
			this.dispose();
			new dashboard();
		}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	
}
		
		
		
		