package Package1;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
//import javax.swing.UIManager;
//import java.awt.Choice;
//import java.awt.TextField;

public class billing extends JFrame {

	private JPanel contentPane;
	private JTextField date;
	private JTextField quantity;
	private JTextField code;
	private JTextField phone;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billing frame = new billing();
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
	public billing() {
		setTitle("Billing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 706);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		date = new JTextField();
		date.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		date.setBounds(91, 29, 86, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Phone No:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(358, 32, 165, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCode.setBounds(117, 99, 46, 20);
		contentPane.add(lblCode);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(231, 99, 71, 20);
		contentPane.add(lblNewLabel_2);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		quantity.setBounds(231, 130, 51, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		code = new JTextField();
		code.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		code.setColumns(10);
		code.setBounds(112, 130, 51, 20);
		contentPane.add(code);
		
		phone = new JTextField();
		phone.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		phone.setColumns(10);
		phone.setBounds(533, 28, 124, 20);
		contentPane.add(phone);
		
		JLabel label = new JLabel("");
		label.setBounds(47, 571, 46, 14);
		contentPane.add(label);
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");  
				Statement stmt=con.createStatement();
				String p=phone.getText();
				
				String sql="select * from Customer where phone='" + p + "';" ;
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next()==true)
				{
					JOptionPane.showMessageDialog(null,"existing customer!");
					show_stock();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"new customer!");
					Customer c=new Customer();
					Customer.main(null);
					c.setVisible(false);
					dispose();
					
				}
			}
				catch(Exception ae){ System.out.println(ae);}
			}
	});
		
		btnCheck.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCheck.setBounds(667, 29, 89, 20);
		contentPane.add(btnCheck);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(58, 178, 621, 179);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");
					String co=code.getText();
					String qty=quantity.getText();
					int c=Integer.parseInt(co);
					int q=Integer.parseInt(qty);
					String sql="select * from stock where item_id=" + c +";";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()==true)
					{
						String name=rs.getString(2);
						String price=rs.getString(4);
						
						int p=Integer.parseInt(price);
						int tax=rs.getInt(5);
						int sum=p*q;
						PreparedStatement ps=con.prepareStatement("insert into bill values(?,?,?,?,?);");
						ps.setString(1,co);
						ps.setString(2, name);
						ps.setInt(3, q);
						ps.setInt(4, sum);
						ps.setInt(5, tax);
					
						int b=ps.executeUpdate();
					
						if(b==1)
						{
							show_s();
							String sql1="update stock set qty=qty-1 where item_id="+co;
							PreparedStatement ps1=con.prepareStatement("update stock set qty=qty-? where item_id=?;");
							ps1.setInt(1, q);
							ps1.setInt(2, c);
							ps1.executeUpdate(sql1);
						}
						else
						{
							JOptionPane.showConfirmDialog(null,"cannot add item");
						}
					}
				}catch(Exception ae){ System.out.println(ae);}
						
	
				}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(74, 391, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnFinish = new JButton("finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");
					String sql="select sum(total),sum(tax) from bill;";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					
					if(rs.next()==true)
					{

						int p=rs.getInt(1);
						int tax=rs.getInt(2);
						float net=p+((p*tax)/100);
						JOptionPane.showConfirmDialog(null,"net amount is "+ net);
						printBill pr=new printBill();
						printBill.main(null);
						pr.setVisible(false);
						dispose();
						
						/*String sql1="truncate bill;";
						ResultSet rs1=stmt.executeQuery(sql1);
						if(rs1.next()==true)
						{
							JOptionPane.showConfirmDialog(null,"thank you");
						}*/
							
					}
				}catch(Exception ae){ System.out.println(ae);}
			}
			});
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFinish.setBounds(193, 391, 89, 23);
		contentPane.add(btnFinish);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 448, 621, 137);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		
		
		
	}
		void show_s()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");  
				Statement stmt=con.createStatement();
				
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("item_id");
				model.addColumn("item_name");
				model.addColumn("Quantity");
				model.addColumn("Price*quantity");
				model.addColumn("Tax(%)");
				
				String sql="select * from bill;";
				ResultSet rs=stmt.executeQuery(sql);
				//model.addRow(new Object[] { "item_id","item_name","quantity"," net price","tax"});
				while(rs.next())
				{
					model.addRow(new Object[] {
						rs.getInt("i_id"),
						rs.getString("i_name"),
						rs.getInt("qty"),
						rs.getString("total"),
						rs.getInt("tax")
					});
				}
				con.close();
				
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.getColumnModel().getColumn(2).setPreferredWidth(50);
				table.getColumnModel().getColumn(3).setPreferredWidth(50);
				table.getColumnModel().getColumn(4).setPreferredWidth(50);
				
				
		     }catch(Exception ae){ System.out.println(ae);}
		}
		
		void show_stock()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");  
				Statement stmt=con.createStatement();
				
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("item_id");
				model.addColumn("item_name");
				model.addColumn("Quantity");
				model.addColumn("Price");
				model.addColumn("Tax(%)");
				
				String sql="select * from stock;";
				ResultSet rs=stmt.executeQuery(sql);
				//model.addRow(new Object[] {" item id","item name"," Quantity","Price","Tax"});
				while(rs.next())
				{
					model.addRow(new Object[] {
						rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getInt("qty"),
						rs.getString("price"),
						rs.getInt("tax")
					});
				}
				con.close();
				
				table_1.setModel(model);
				table_1.setAutoResizeMode(0);
				table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(50);
				table_1.getColumnModel().getColumn(3).setPreferredWidth(50);
				table_1.getColumnModel().getColumn(4).setPreferredWidth(50);
				
				
		     }catch(Exception ae){ System.out.println(ae);}
				
		}
}