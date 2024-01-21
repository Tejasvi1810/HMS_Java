import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
//import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
public class Room extends JFrame implements ActionListener
{
	
	Connection con;
	Statement stmt;
	JTable t;
	JButton b1;

Room()
	{
		setSize(700,700);
		setTitle("Room  ");
		setLayout(null);	
		
		b1 = new JButton("Back");
		
		add(b1);
		b1.addActionListener(this);
		b1.setBounds(300,500,120,50);
		
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				System.out.println("Connected");
				
				String s1="select * from add_rooms";
				ResultSet rs = stmt.executeQuery(s1);
				String str[]={"Room_no","Available","Cleaning_status","Price","Bed_type"};
			Object obj[][]=new Object[20][5];
			
			int i=0,j=0;
				
				while(rs.next())
				{
					obj[i][j++]=rs.getString("Room_no");
					obj[i][j++]=rs.getString("Available");
					obj[i][j++]=rs.getString("Cleaning_status");
					obj[i][j++]=rs.getString("Price");
					obj[i][j++]=rs.getString	("Bed_type");
					
					i++;
					j=0;
				}
				
				t = new JTable(obj,str);
				
					
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			JScrollPane js = new JScrollPane(t);
				add(js);
				
				js.setBounds(20,50,700,500);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	public static void main(String str[])
	{
		new Room();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			this.dispose();
			new reception();
		}
	}
}
		