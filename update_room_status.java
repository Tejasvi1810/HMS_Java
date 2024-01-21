import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class update_room_status extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4;
	JTextField tf1,tf2,tf3;
	JComboBox cb1;
	JButton b1,b2,b3;
	Connection con;
	Statement stmt;
	update_room_status()	
	{
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Update room status  ");
		
		setSize(778,386);
	setLayout(null);
	    l = new JLabel("Update Room status");
		l.setForeground(Color.BLUE);
            l.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l1 = new JLabel("Guest ID");
		l2 = new JLabel("Room No.");
		l3 = new JLabel("Availaibility");
		l4 = new JLabel("Clean Status");
		
		tf1 = new JTextField(30);
		tf2 = new JTextField(30);
		tf3 = new JTextField(30);
		
		cb1 = new JComboBox();
		
		b1 = new JButton("Check");
		b2 = new JButton("Update");
		b3 = new JButton("Back");
		
		
		add(l);add(l1);add(cb1);
		add(l2);add(tf1);add(l3);add(tf2);add(l4);add(tf3);
		add(b1);add(b2);add(b3);
			
		
		l.setBounds(350,24,442,35);
		l1.setBounds(60,30,150,27);
		cb1.setBounds(150,35,120,20);
		l2.setBounds(60,60,150,27);
		tf1.setBounds(150,65,120,20);
		l3.setBounds(60,90,150,27);
		tf2.setBounds(150,95,120,20);
		l4.setBounds(60,120,150,27);
		tf3.setBounds(150,125,120,20);
		
		
		b1.setBounds(30,200,120,50);
		b2.setBounds(200,200,120,50);
		b3.setBounds(130,270,120,50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLACK);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("room_status.jpg"));
            Image i3 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(350,10,330,410);
            add(image);
			
			b3.addActionListener(this);
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				//ResultSet rs = rs.stmt.executeQuery(s1)
				
				String q1 = "select Number from add_cust";
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
		new update_room_status();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
			{
				if(ae.getSource()==b1)
				{
					
					
					
					
					String str1 = "select * from add_rooms where Room_no in (select Allocated_room_no from add_cust where Number='"+cb1.getSelectedItem()+"')";
					
					ResultSet rs1 = stmt.executeQuery(str1);
					if(rs1.next())
					{
						tf1.setText(rs1.getString(1));
						tf2.setText(rs1.getString(2));
						tf3.setText(rs1.getString(3));
					}
				}
				else if(ae.getSource()==b3)
				{
					this.dispose();
					new reception();
				}
				else if(ae.getSource()==b2)
				{
					String str2="update add_rooms set Cleaning_status ='"+tf3.getText()+"' where Room_no ='"+tf1.getText()+"'"; 
					
					stmt.executeUpdate(str2);
					JOptionPane.showMessageDialog(this,"Record updated succesfully !");
				}
					
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
}
		
		
		
		
