import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPasswordField;


public class Login_admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_admin frame = new Login_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(167, 65, 164, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 68, 83, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(37, 119, 83, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your Login Credentials");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(89, 13, 255, 39);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  
					//step1 load the driver class  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement();  
					  
					//step4 execute query  
					
					 //int id=Integer.parseInt(textField.getText());
					 String use=textField.getText();
					 String pwd=textField_1.getText();
					
					String q1="select apwd from admin where aUsername="+"'"+use+"'";
					String re=" ";
					ResultSet rs1=stmt.executeQuery(q1);
					while(rs1.next())
					{
						re=rs1.getString(1);
					}
					if(pwd.equals(re))
					{
						JOptionPane.showMessageDialog(null,"Login Successful");
						admin a=new admin();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please Enter Valid Username and Password");
					}
					
					  
					//step5 close the connection object  
					con.close();  
					  
					}catch(Exception e){ System.out.println(e);}  
					  
					}  
			}
		);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(71, 166, 97, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back To Home");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h = new Home();
				dispose();
			}
		});
		btnNewButton_1.setBounds(206, 166, 138, 32);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(167, 117, 164, 22);
		contentPane.add(textField_1);
		setVisible(true);
	}

}
