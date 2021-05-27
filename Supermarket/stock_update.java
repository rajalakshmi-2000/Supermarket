package Package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class stock_update extends JFrame {

	private JPanel contentPane;
	private JTextField item_name;
	private JTextField quantity;
	private JTextField unitprice;
	private JTextField Tax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock_update frame = new stock_update();
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
	public stock_update() {
		setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		setTitle("Stock Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 403);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblItemName.setBounds(26, 45, 75, 23);
		contentPane.add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(26, 97, 75, 23);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Unit Price");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrice.setBounds(26, 149, 75, 23);
		contentPane.add(lblPrice);
		
		JButton btnSave = new JButton("Save");
		JLabel code = new JLabel("");
		code.setBounds(152, 11, 109, 14);
		contentPane.add(code);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");
					PreparedStatement ps=con.prepareStatement("insert into stock (item_name,qty,price,tax) values(?,?,?,?);");
					Statement stmt=con.createStatement();
					String name=item_name.getText();
					String qty=quantity.getText();
					int q=Integer.parseInt(qty);
					String price=unitprice.getText();
					String tax=Tax.getText();
					int t=Integer.parseInt(tax);
					
					
					ps.setString(1,name);
					ps.setInt(2, q);
					ps.setString(3, price);
					ps.setInt(4, t);
					
					int b=ps.executeUpdate();
					
					if(b==1)
					{
						JOptionPane.showMessageDialog(null,"successfully added item!");
						choice c1=new choice();
						choice.main(null);
						c1.setVisible(false);
						dispose();
			    	}
					else
					{
						JOptionPane.showMessageDialog(null,"cannot add information");
					}
					con.close();  
				}
				catch(Exception ae){ System.out.println(ae);}
				}
			}
		);
		btnSave.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.setForeground(new Color(255, 255, 0));
		btnSave.setBounds(209, 281, 89, 23);
		contentPane.add(btnSave);
		
		item_name = new JTextField();
		item_name.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		item_name.setBounds(152, 47, 243, 20);
		contentPane.add(item_name);
		item_name.setColumns(10);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		quantity.setBounds(152, 99, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		unitprice = new JTextField();
		unitprice.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		unitprice.setBounds(152, 151, 86, 20);
		contentPane.add(unitprice);
		unitprice.setColumns(10);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTax.setBounds(26, 208, 75, 23);
		contentPane.add(lblTax);
		
		Tax = new JTextField();
		Tax.setBounds(152, 210, 86, 20);
		contentPane.add(Tax);
		Tax.setColumns(10);
		
		
		
		
	}
}
