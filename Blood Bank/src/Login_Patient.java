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


public class Login_Patient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Patient frame = new Login_Patient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login_Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(176, 77, 195, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(77, 73, 87, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(77, 114, 87, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your Login Credentials");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(95, 33, 235, 31);
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
					
					String q1="select ppwd,pId from patient where pLogin_Username="+"'"+use+"'";
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
						patient a=new patient(id);
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
		btnNewButton.setBounds(77, 177, 115, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back To Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h = new Home();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(228, 177, 143, 38);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(176, 112, 195, 22);
		contentPane.add(textField_1);
	}

}
