package Package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField cname;
	private JTextField number;
	private JTextField pts;
	private JTextField add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customer() {
		setTitle("Customer Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 483);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(56, 55, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile Number");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(56, 126, 104, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(56, 189, 104, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Points");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(56, 243, 96, 31);
		contentPane.add(lblNewLabel_4);
		
		cname = new JTextField();
		cname.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		cname.setBounds(243, 46, 260, 31);
		contentPane.add(cname);
		cname.setColumns(10);
		
		number = new JTextField();
		number.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		number.setBounds(243, 117, 165, 31);
		contentPane.add(number);
		number.setColumns(10);
		
		pts = new JTextField();
		pts.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		pts.setBounds(243, 253, 86, 31);
		contentPane.add(pts);
		pts.setColumns(10);
		
		add = new JTextField();
		add.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		add.setColumns(10);
		add.setBounds(243, 189, 260, 31);
		contentPane.add(add);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");
					PreparedStatement ps=con.prepareStatement("insert into Customer (cname,phone,address,points) values(?,?,?,?);");
					Statement stmt=con.createStatement();
				    
					String name=cname.getText();
					String num=number.getText();
					String addr=add.getText();
					String poi=pts.getText();
					int p=Integer.parseInt(poi);
					
					ps.setString(1,name);
					ps.setString(2, num);
					ps.setString(3, addr);
					ps.setInt(4, p);
					
					int b=ps.executeUpdate();
					
					if(b==1)
					{
						JOptionPane.showMessageDialog(null,"successfully added customer!");
						billing bi=new billing();
						billing.main(null);
						bi.setVisible(false);
						dispose();
			    	}
					else
					{
						JOptionPane.showMessageDialog(null,"cannot add information !! retry !!");
					}
					con.close();  
				}
				catch(Exception ae){ System.out.println(ae);}
				
			}
		});
		button.setForeground(Color.YELLOW);
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(328, 357, 89, 23);
		contentPane.add(button);
	}
}
