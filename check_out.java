import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Date;
public class check_out extends JFrame //implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2;
	JComboBox cb1;
	Connection con;
	Statement stmt;
	check_out()
	{
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Check out  ");
		
		setSize(778,406);
	setLayout(null);
	
	      l = new JLabel("Check out");
		l.setForeground(Color.BLUE);
            l.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l1 = new JLabel("Cust ID");
		l2 = new JLabel("Room No.");
		l3 = new JLabel("");
		l4 = new JLabel("Check-in Time");
		l5 = new JLabel("");
		Date d = new Date();
		l6 = new JLabel("Check-out Time");
		l7 = new JLabel(""+ d);
		
		cb1 = new JComboBox();
		
		b1 = new JButton("Check out");
		b2 = new JButton("Back");
		
		add(l);add(l1);add(cb1);
		add(l2);add(l3);
		add(l4);add(l5);
		add(l6);add(l7);
		add(b1);add(b2);
		
		l.setBounds(350,24,442,35);
		l1.setBounds(30,30,150,27);
		cb1.setBounds(150,35,120,20);
		l2.setBounds(30,60,150,27);
		l3.setBounds(150,65,120,20);
		l4.setBounds(30,90,150,27);
		l5.setBounds(150,95,120,20);
		l6.setBounds(30,120,150,27);
		l7.setBounds(150,108,180,50);
		
		b1.setBounds(30,240,120,50);
		b2.setBounds(200,240,120,50);
		
			b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("check_out.jpg"));
            Image i3 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(350,10,330,410);
            add(image);
			
			// b1.addActionListener(this);
			// b2.addActionListener(this);
			
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				//ResultSet rs = rs.stmt.executeQuery(s1)
				
				String q1 = "select Number from add_cust";
				ResultSet rs = stmt.executeQuery(q1);
				
				// String q2 = "select Allocated_room_no from add_cust where Number='"+cb1.getSelectedItem()+"'";
				// ResultSet rs1 = stmt.executeQuery(q2);
				
				// String q3 = "select Check_in_time from add_cust where Number='"+cb1.getSelectedItem()+"'";
				
				
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
		new check_out();
	}
	
	
	
}
	
	
	
