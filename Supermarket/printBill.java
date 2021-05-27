package Package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class printBill extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printBill frame = new printBill();
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
	public printBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          BILL");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(271, 11, 204, 31);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(60, 76, 658, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPrint = new JButton("print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");
					
					show_bill();
					String sql="select sum(total),sum(tax) from bill;";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					
					if(rs.next()==true)
					{

						int p=rs.getInt(1);
						int tax=rs.getInt(2);
						int net=p+((p*tax)/100);
						String a=Integer.toString(net);
						JLabel amt = new JLabel("");
						amt.setBounds(468, 448, 80, 19);
						contentPane.add(amt);
						amt.setFont(new Font("Times New Roman", Font.BOLD, 15));
						amt.setText("Rs " + a);
						
						
						
						//JOptionPane.showConfirmDialog(null,"net amount is "+ net);
						//printBill pr=new printBill();
						//printBill.main(null);
						//pr.setVisible(false);
						//dispose();
						
						String sql1="truncate bill;";
						ResultSet rs1=stmt.executeQuery(sql1);
						if(rs1.next()==true)
						{
							JOptionPane.showConfirmDialog(null,"thank you");
						}
							
					}
				}catch(Exception ae){ System.out.println(ae);}
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrint.setBounds(553, 29, 89, 23);
		contentPane.add(btnPrint);
		
		JLabel lblTotalAmount = new JLabel("Total Amount:");
		lblTotalAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalAmount.setBounds(334, 448, 110, 23);
		contentPane.add(lblTotalAmount);
		
		
	}
	
	void show_bill()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");  
			Statement stmt=con.createStatement();
			
			DefaultTableModel model=new DefaultTableModel();
			model.addColumn("ITEM ID");
			model.addColumn("ITEM NAME");
			model.addColumn("QUANTITY");
			model.addColumn("NET");
			model.addColumn("TAX");
			
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
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			
			
	     }catch(Exception ae){ System.out.println(ae);}
	}
}
