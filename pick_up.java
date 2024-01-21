import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Date;
public class pick_up extends JFrame implements ActionListener
{
	JLabel l,l1;
	JComboBox cb1;
	JButton b1,b2;
	Connection con;
	Statement stmt;
	JTable t;
	
		pick_up()
		{
			getContentPane().setForeground(Color.BLUE);
			getContentPane().setBackground(Color.WHITE);
			setTitle("Pick up  ");
			
			setSize(700,800);
		setLayout(null);
		
			  l = new JLabel("Check out");
			l.setForeground(Color.BLUE);
				l.setFont(new Font("Tahoma", Font.PLAIN, 31));
				
			l1 = new JLabel("Type of Car");
			b1 = new JButton("Submit");
			b2 = new JButton("Back");
			cb1 = new JComboBox();
			
			add(l);add(l1);add(cb1);
		add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		l.setBounds(350,24,442,35);
		l1.setBounds(30,30,150,27);
		cb1.setBounds(150,35,120,20);
		b1.setBounds(100,500,120,50);
		b2.setBounds(300,500,120,50);
		
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
				
				String q1 = "select Car_model from add_driver";
				ResultSet rs = stmt.executeQuery(q1);
				
				while(rs.next())
				{
					cb1.addItem(rs.getString(1));
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
		new pick_up();
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
				
				String s1="select * from add_driver where Car_model='"+cb1.getSelectedItem()+"'";
				ResultSet rs1 = stmt.executeQuery(s1);
				String str[]={"Name","ID","Gender","Car_company","Car_model","Available","Location"};
			Object obj[][]=new Object[20][7];
			
			int i=0,j=0;
				
				while(rs1.next())
				{
					obj[i][j++]=rs1.getString("Name");
					obj[i][j++]=rs1.getString("ID");
					obj[i][j++]=rs1.getString("Gender");
					obj[i][j++]=rs1.getString("Car_company");
					obj[i][j++]=rs1.getString("Car_model");
					obj[i][j++]=rs1.getString("Available");
					obj[i][j++]=rs1.getString("Location");
					
					
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
				
				js.setBounds(20,90,700,700);
	}
	
	
	
}
	
	
	
