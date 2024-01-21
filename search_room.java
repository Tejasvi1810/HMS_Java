import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Date;
public class search_room extends JFrame implements ActionListener
{
	JLabel l,l1,l2;
	JComboBox cb1,cb2;
	JButton b1,b2;
	Connection con;
	Statement stmt;
	JTable t;
	
			search_room()
		{
			getContentPane().setForeground(Color.BLUE);
			getContentPane().setBackground(Color.WHITE);
			setTitle("Search Room");
			
			setSize(600,600);
		setLayout(null);
		
			  l = new JLabel("Search Room");
			l.setForeground(Color.BLUE);
				l.setFont(new Font("Tahoma", Font.PLAIN, 31));
				
			l1 = new JLabel("Bed type");
			l2 = new JLabel("Status");
			
			b1 = new JButton("Submit");
			b2 = new JButton("Back");
			cb1 = new JComboBox();
			cb2 = new JComboBox();
			
			
			
			
			add(l);add(l1);add(cb1);add(l2);add(cb2);
		add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		l.setBounds(350,24,442,35);
		l1.setBounds(30,30,150,27);
		cb1.setBounds(150,35,120,20);
		l2.setBounds(30,80,150,27);
		cb2.setBounds(150,85,120,20);
		b1.setBounds(80,500,120,50);
		b2.setBounds(230,500,120,50);
		
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				//ResultSet rs = rs.stmt.executeQuery(s1)
				
				String q1 = "select DISTINCT Bed_type from add_rooms";
				//string q2 = "select Available from add_rooms";
				
				ResultSet rs = stmt.executeQuery(q1);
				//ResultSet rs = stmt.executeQuery(q2);
				
				
				while(rs.next())
				{
					cb1.addItem(rs.getString(1));
					//cb2.addItem(rs.getString(1));
				}
			System.out.println("Connected");
				
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				//ResultSet rs = rs.stmt.executeQuery(s1)
				
				//String q1 = "select Bed_type from add_rooms";
				String q2 = "select DISTINCT Available from add_rooms";
				
				//ResultSet rs = stmt.executeQuery(q1);
				ResultSet rs1 = stmt.executeQuery(q2);
				
				
				while(rs1.next())
				{
					//cb1.addItem(rs.getString(1));
					cb2.addItem(rs1.getString(1));
				}
			System.out.println("Connected");
				
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String str[])
	{
		new search_room();
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
			{
				if(ae.getSource()==b1)
				{
					
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				
				String s1="select * from add_rooms where Bed_type='"+cb1.getSelectedItem()+"' AND Available='"+cb2.getSelectedItem()+"'";
				ResultSet rs1 = stmt.executeQuery(s1);
				String str[]={"Room_no","Available","Cleaning_status","Price","Bed_type"};
			Object obj[][]=new Object[20][5];
			
			int i=0,j=0;
				
				while(rs1.next())
				{
					obj[i][j++]=rs1.getString("Room_no");
					obj[i][j++]=rs1.getString("Available");
					obj[i][j++]=rs1.getString("Cleaning_status");
					obj[i][j++]=rs1.getString("Price");
					obj[i][j++]=rs1.getString("Bed_type");
					
					i++;
					j=0;
				}
				t = new JTable(obj,str);
				System.out.println("Connected");
				
				}
				else if(ae.getSource()==b2)
				{
					this.dispose();
					new reception();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
				
				
				
				
				
			
			JScrollPane js = new JScrollPane(t);
				add(js);
				
				js.setBounds(10,150,300,300);
	}
	
	
	
}
	
	
	
