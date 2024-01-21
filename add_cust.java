import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Date;	
public class add_cust extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tf1,tf2,tf3,tf4;
	JComboBox cb1,cb2;
	JRadioButton r1,r2;
	JButton b1,b2;
	Connection con;
		Statement stmt;
	
	
		add_cust()
		{
			getContentPane().setForeground(Color.BLUE);
			getContentPane().setBackground(Color.WHITE);
			setTitle("Add Customers ");
			
			setSize(778,486);
		setLayout(null);
	
		l = new JLabel("Adding Customer Detail");
		l.setForeground(Color.BLUE);
            l.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l1 = new JLabel("ID");
		l2 = new JLabel("Number");
		l3 = new JLabel("Name");
		l4 = new JLabel("Gender");
		l5 = new JLabel("Country");
		l6 = new JLabel("Allocated Room No.");
		Date d = new Date();
		l7 = new JLabel("Check-in Time");
		l9 = new JLabel(""+ d);
		l8 = new JLabel("Deposit");
		
		tf1 = new JTextField(30);
		tf2 = new JTextField(30);
		tf3 = new JTextField(30);
		tf4 = new JTextField(30);
		
		ButtonGroup bg = new ButtonGroup();
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		bg.add(r1);bg.add(r2);
		
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		
		cb1.addItem("Aadhar");
		cb1.addItem("PAN");
		cb1.addItem("Passport");
		cb1.addItem("Voter ID");
		cb1.addItem("Liscence");
		cb1.addItem("Family ID");
		
		// cb2.addItem("101");
		// cb2.addItem("102");
		// cb2.addItem("103");
		// cb2.addItem("104");
		// cb2.addItem("105");
		// cb2.addItem("106");
		// cb2.addItem("107");
		
		
		b1 = new JButton("Add");
		b2 = new JButton("Cancel");
		
		add(l);add(l1);add(cb1);
		add(l2);add(tf1);add(l3);add(tf2);
		add(l4);add(r1);add(r2);
		add(l5);add(tf3);
		add(l6);add(cb2);
		add(l7);add(l9);
		add(l8);add(tf4);
		add(b1);add(b2);
		
		l.setBounds(350,24,442,35);
		l1.setBounds(30,30,150,27);
		cb1.setBounds(150,35,120,20);
		l2.setBounds(30,60,150,27);
		tf1.setBounds(150,65,120,20);
		l3.setBounds(30,90,150,27);
		tf2.setBounds(150,95,120,20);
		l4.setBounds(30,120,150,27);
		r1.setBounds(150,125,80,20);
		r2.setBounds(280,125,80,20);
		l5.setBounds(30,150,150,27);
		tf3.setBounds(150,155,120,20);
		l6.setBounds(30,190,150,27);
		cb2.setBounds(150,195,120,20);
		l7.setBounds(30,220,150,27);
		l9.setBounds(150,210,180,50);
		
		l8.setBounds(30,250,150,27);
		tf4.setBounds(150,255,120,20);
		
		b1.setBounds(30,300,120,50);
		b2.setBounds(200,300,120,50);
		b1.addActionListener(this);
		
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cust.jpg"));
            Image i3 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(350,10,330,410);
            add(image);
			
			b2.addActionListener(this);
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","");
				stmt=con.createStatement();
				//ResultSet rs = rs.stmt.executeQuery(s1)
				String q1 = "select Room_no from add_rooms where Available='Available'";
				ResultSet rs = stmt.executeQuery(q1);
				
				while(rs.next())
				{
					cb2.addItem(rs.getString(1));
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
		new add_cust();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			
			String gender = null;
                    
                    if(r1.isSelected()){
                        gender = "male";
                    
                    }else if(r2.isSelected()){
                        gender = "female";
                    }
		
		
		if(ae.getSource()==b1)
		{
			
			// create table add_cust(ID_type varchar(20),Number varchar(20),Name varchar(20),Gender varchar(20),Country varchar(20),Allocated_room_no int,Check_in_time varchar(20),Deposit int);
			
			String s1 = "insert into add_cust values('"+cb1.getSelectedItem()+"','"+tf1.getText()+"','"+tf2.getText()+"','"+gender+"','"+tf3.getText()+"','"+cb2.getSelectedItem()+"','"+l9.getText()+"',"+tf4.getText()+")";
			
			 String q3 = "update add_rooms set Available = 'Occupied' where Room_no = '"+cb2.getSelectedItem()+"'";
			
			
			stmt.executeUpdate(s1);
			stmt.executeUpdate(q3);
			
			
			//b1.setEnabled(false);
			JOptionPane.showMessageDialog(this,"Record saved succesfully !");
		}
		if(ae.getSource()==b2)
		{
			this.dispose();
			new reception();
		}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	
}
		
		
		
		
		
		
		