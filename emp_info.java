import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
//import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
public class emp_info extends JFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	JTable t;
	JButton b1;

emp_info()
	{
		setSize(1000,1000);
		setTitle("Emp info  ");
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
				
				String s1="select * from add_emp";
				ResultSet rs = stmt.executeQuery(s1);
				String str[]={"Name","ID","Gender","Department","Salary","Phone","Email"};
			Object obj[][]=new Object[20][7];
			
				int i=0,j=0;
				
				while(rs.next())
				{
					obj[i][j++]=rs.getString("Name");
					obj[i][j++]=rs.getString("ID");
					obj[i][j++]=rs.getString("Gender");
					obj[i][j++]=rs.getString("Department");
					obj[i][j++]=rs.getString("Salary");
					obj[i][j++]=rs.getString("Phone");
					obj[i][j++]=rs.getString("Email");
					
					
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
		new emp_info();
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
		
			
			
		
		