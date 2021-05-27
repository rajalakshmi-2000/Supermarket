package Package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class choice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choice frame = new choice();
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
	public choice() {
		setTitle("Super Market");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("update");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Stock");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					stock_update su=new stock_update();
					stock_update.main(null);
					su.setVisible(false);
					dispose();
				
						
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Bill");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billing b=new billing();
				billing.main(null);
				b.setVisible(false);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_2.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu_2.add(mntmExit);
		
		JMenu mnNewMenu_3 = new JMenu("report");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmStockList = new JMenuItem("Stock List");
		
		
		
		mntmStockList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_s();
			}
			});
		mnNewMenu_3.add(mntmStockList);
		
		JMenuItem mntmCustomerList = new JMenuItem("Customer List");
		mntmCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_c();
			}
		});
		mnNewMenu_3.add(mntmCustomerList);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 37, 650, 332);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}
		
	
	    void show_c()
	    {
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");  
				Statement stmt=con.createStatement();
				
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("cust_id");
				model.addColumn("c_name");
				model.addColumn("phone");
				model.addColumn("address");
				model.addColumn("points");
				
				String sql="select * from Customer;";
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					model.addRow(new Object[] {
						rs.getInt("cust_id"),
						rs.getString("cname"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getInt("points")
					});
				}
				con.close();
				
				table_1.setModel(model);
				table_1.setAutoResizeMode(0);
				table_1.getColumnModel().getColumn(0).setWidth(100);
				table_1.getColumnModel().getColumn(1).setWidth(100);
				table_1.getColumnModel().getColumn(2).setWidth(300);
				table_1.getColumnModel().getColumn(3).setWidth(100);
				table_1.getColumnModel().getColumn(4).setWidth(100);
				
				
		     }catch(Exception ae){ System.out.println(ae);}
				
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
				model.addColumn("Price");
				model.addColumn("Tax(%)");
				
				String sql="select * from stock;";
				ResultSet rs=stmt.executeQuery(sql);
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
				table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
				
				
		     }catch(Exception ae){ System.out.println(ae);}
				
		}
}
