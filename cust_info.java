import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
//import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
public class cust_info extends JFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	JTable t;
	JButton b1;
	
	cust_info()
	{
		setSize(1000,1000);
		setTitle("Customer info  ");
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
				
				String s1="select * from add_cust";
				ResultSet rs = stmt.executeQuery(s1);
				String str[]={"Id_type","Number","Name","Gender","Country","Allocated_room_no","Check_in_time","Deposit"};
			Object obj[][]=new Object[20][8];
			
				int i=0,j=0;
				
				while(rs.next())
				{
					obj[i][j++]=rs.getString("Id_type");
					obj[i][j++]=rs.getString("Number");
					obj[i][j++]=rs.getString("Name");
					obj[i][j++]=rs.getString("Gender");
					obj[i][j++]=rs.getString("Country");
					obj[i][j++]=rs.getString("Allocated_room_no");
					obj[i][j++]=rs.getString("Check_in_time");
					obj[i][j++]=rs.getString("Deposit");
					
					
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
				
				js.setBounds(20,50,900,900);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	public static void main(String str[])
	{
		new cust_info();
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
		
			
