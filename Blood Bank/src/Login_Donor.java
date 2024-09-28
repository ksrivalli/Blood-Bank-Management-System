import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login_Donor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Donor frame = new Login_Donor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login_Donor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(174, 78, 186, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(46, 81, 93, 16);
		contentPane.add(lblUsername);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(174, 121, 186, 22);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 124, 93, 16);
		contentPane.add(lblNewLabel);
		
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
					
					String q1="select dpwd,dId from donor where dLogin_Username="+"'"+use+"'";
					String re=" ";
					int id=0;
					ResultSet rs1=stmt.executeQuery(q1);
					while(rs1.next())
					{
						
						re=rs1.getString(1);
						id=rs1.getInt(2);
					}
					if(pwd.equals(re))
					{
						JOptionPane.showMessageDialog(null,"Welcome,Login Successful");
						Donor a=new Donor(id);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please Enter Valid Username and Password");
					}
					con.close();  
					  
					}catch(Exception e){ System.out.println(e);}  
					  
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(66, 185, 114, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back To Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h = new Home();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(204, 185, 156, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEnterYourLogin = new JLabel("Enter Your Login Credentials ");
		lblEnterYourLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterYourLogin.setBounds(83, 23, 215, 42);
		contentPane.add(lblEnterYourLogin);
	}
}
