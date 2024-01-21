import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class add_emp extends JFrame implements ActionListener
{
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JComboBox cb;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l;
	JButton b1,b2;
	JRadioButton r1,r2;
	Connection con;
	Statement stmt;
		
	
	
	add_emp()
	{
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add Employees ");
		
		setSize(778,486);
	setLayout(null);
		l = new JLabel("Adding Employee Detail");
		l.setForeground(Color.BLUE);
            l.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l1 = new JLabel("Name");
		l2 = new JLabel("ID");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Department");
		l5 = new JLabel("Salary");
		l6 = new JLabel("Phone");
		l7 = new JLabel("Aadhar");
		l8 = new JLabel("Email");
		
		tf1 = new JTextField(30);
		tf2 = new JTextField(30);
		tf3 = new JTextField(30);
		tf4 = new JTextField(30);
		tf5 = new JTextField(30);
		tf6	 = new JTextField(30);
		
		ButtonGroup bg = new ButtonGroup();
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		bg.add(r1);bg.add(r2);
		
		cb = new JComboBox();
		
		cb.addItem("Hospitality");
		cb.addItem("Logistics");
		cb.addItem("Brewery");
		cb.addItem("Security");
		cb.addItem("Sales");
		cb.addItem("HR");
		cb.addItem("Accounts");
		cb.addItem("HouseKepping");
		cb.addItem("Kitchen");
		
		b1 = new JButton("Submit");
		b2 = new JButton("Back");
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		cb.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		
		
		add(l);add(l1);add(tf1);
		add(l2);add(tf2);add(l3);add(r1);add(r2);add(l4);add(cb);
		add(l5);add(tf3);add(l6);add(tf4);add(l7);add(tf5);add(l8);add(tf6);add(b1);add(b2);
		
		l.setBounds(350,24,442,35);
		l1.setBounds(60,30,150,27);
		tf1.setBounds(150,35,120,20);
		l2.setBounds(60,60,150,27);
		tf2.setBounds(150,65,120,20);
		l3.setBounds(60,90,150,27);
		r1.setBounds(150,95,120,20);
		r2.setBounds(280,95,120,20);
		l4.setBounds(60,120,150,27);
		cb.setBounds(150,125,120,20);
		l5.setBounds(60,150,150,27);
		tf3.setBounds(150,155,120,20);
		l6.setBounds(60,190,150,27);
		tf4.setBounds(150,195,120,20);
		l7.setBounds(60,220,150,27);
		tf5.setBounds(150,225,120,20);
		l8.setBounds(60,250,150,27);
		tf6.setBounds(150,255,120,20);
		b1.setBounds(100,300,120,50);
		b2.setBounds(250,300,120,50);
		
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("emp.jpg"));
            Image i3 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(350,20,430,410);
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
			
			// create table add_emp(Name varchar(20),Id int,Gender varchar(20),Department varchar(20),Salary int,Phone varchar(20),Aadhar varchar(20),Email varchar(20));
			
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String str[])
	{
		new add_emp();
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
			//String s2 = null;
			//  String s2 = cb.getSelectedItem();
			String s1 = "insert into add_emp values('"+tf1.getText()+"',"+tf2.getText()+",'"+gender+"','"+cb.getSelectedItem()+"',"+tf3.getText()+",'"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"')";
			
			
			
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