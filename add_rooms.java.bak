import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class add_rooms extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5;
	JButton b1,b2;
	JComboBox cb1,cb2,cb3;
	JTextField tf1,tf2;
	Connection con;
		Statement stmt;
		
	
	add_rooms()
	{
		
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		 setTitle("Add Rooms ");
		setSize(778,486);
	setLayout(null);
		
		l = new JLabel("Add rooms");
		l.setForeground(Color.BLUE);
            l.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l1 = new JLabel("Room No");
		l2 = new JLabel("Available");
		l3 = new JLabel("Cleaning Status");
		l4 = new JLabel("Price");
		l5 = new JLabel("Bed Type");
		
		b1 = new JButton("Submit");
		b2 = new JButton("Back");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		
		
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		cb3 = new JComboBox();
		
		
		cb1.addItem("Available");
		cb1.addItem("Occupied");
		
		cb2.addItem("Cleaned");
		cb2.addItem("Dirty");
		
		cb3.addItem("Single");
		cb3.addItem("Double");
		
		add(l);add(l1);add(tf1);
		add(l2);add(cb1);
		add(l3);add(cb2);
		add(l4);add(tf2);
		add(l5);add(cb3);	
		add(b1);add(b2);
		
		l.setBounds(100,30,150,27);
		l1.setBounds(60,60,150,27);
		tf1.setBounds(170,65,120,20);
		l2.setBounds(60,90,150,27);
		cb1.setBounds(170,95,120,20);
		l3.setBounds(60,120,150,27);
		cb2.setBounds(170,125,120,20);
		l4.setBounds(60,150,150,27);
		tf2.setBounds(170,155,120,20);
		l5.setBounds(60,190,150,27);
		cb3.setBounds(170,195,120,20);
		b1.setBounds(30,300,120,50);
		b2.setBounds(200,300,120,50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
			b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("room.jpg"));
            Image i3 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
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
			
			// create table add_rooms(Room_no int,Available varchar(20),Cleaning_status varchar(20),Price int,Bed_type varchar(20));
			
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String str[])
	{
		new add_rooms();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		 
		
		if(ae.getSource()==b1)
		{
			//String s2 = null;
			//  String s2 = cb.getSelectedItem();
			String s1 = "insert into add_rooms values('"+tf1.getText()+"','"+cb1.getSelectedItem()+"','"+cb2.getSelectedItem()+"',"+tf2.getText()+",'"+cb3.getSelectedItem()+"')";
			
			
			
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
		
		
		
