import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class dashboard extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu mn1,mn2;
	JMenuItem mt1,mt2,mt3,mt4;
	
	dashboard()
	{
		setSize(1800,1000);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1800, 1000); 
        add(NewLabel);
		
		    JLabel l1 = new JLabel("WELCOME TO THE TEJAS HOTEL (OYO)");
	l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 46));
	l1.setBounds(400, 350, 1000, 85);
	NewLabel.add(l1);
		
		mb = new JMenuBar();
		mn1 = new JMenu("Hotel Management");
		mn2 = new JMenu("Admin");
		mt1 = new JMenuItem("Reception");
		mt2 = new JMenuItem("Add Employee");
		mt3 = new JMenuItem("Add Rooms");
		mt4 = new JMenuItem("Add Drivers");
		
		mn1.add(mt1);
		mn2.add(mt2);mn2.add(mt3);mn2.add(mt4);
		mb.add(mn1);mb.add(mn2);
		setJMenuBar(mb);
		
		
		mt2.addActionListener(this);
		mt3.addActionListener(this);
		mt4.addActionListener(this);
		mt1.addActionListener(this);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mt1)
		{
			this.dispose();
			new reception();
		}
		else if(ae.getSource()==mt2)
		{
			this.dispose();
			new add_emp();
		}
		else if(ae.getSource()==mt3)
		{
			this.dispose();
			new add_rooms();
		}
		else if(ae.getSource()==mt4)
		{
			this.dispose();
			new add_driver();
		}
	}
	public static void main(String str[])
	{
		new dashboard();
	}
}
		