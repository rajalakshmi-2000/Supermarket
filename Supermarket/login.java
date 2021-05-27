package Package1;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JButton btnLogin;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 472);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Username");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label1.setBounds(202, 134, 102, 27);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Password");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label2.setBounds(202, 219, 102, 27);
		contentPane.add(label2);
		
		user = new JTextField();
		user.setBounds(314, 131, 146, 30);
		contentPane.add(user);
		user.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(314, 219, 146, 30);
		contentPane.add(password);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Sakthi_23");  
					Statement stmt=con.createStatement();
					String u=user.getText();
					String p=password.getText();
					String sql="select * from Employee where username='"+ u +"' and password='"+ p + "';";
					ResultSet rs=stmt.executeQuery(sql);  
					if(rs.next())
					{
					JOptionPane.showMessageDialog(null,"successfully logged in!");
					choice c= new choice();
					choice.main(null);
					c.setVisible(false);
					dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"incorrect username and password");
					}
					con.close();  
					}catch(Exception ae){ System.out.println(ae);}
					}
			}
		
	);
		btnLogin.setForeground(Color.YELLOW);
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(268, 314, 89, 23);
		contentPane.add(btnLogin);
		
		
	}
}





