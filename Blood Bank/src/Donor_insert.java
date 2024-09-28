import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Donor_insert extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField dob;
	private JTextField mobile;
	private JTextField age;
	private final JLabel lblNewLabel_3 = new JLabel("Age");
	private JTextField gender;
	private JTextField city;
	private JTextField blood;
	private JTextField username;
	private JTextField pwd;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor_insert frame = new Donor_insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Donor_insert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Enter Donor Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 13, 148, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(81, 54, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(183, 52, 199, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setBounds(183, 89, 199, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(81, 92, 56, 16);
		contentPane.add(lblEmail);
		
		dob = new JTextField();
		dob.setBounds(183, 177, 199, 22);
		contentPane.add(dob);
		dob.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateOfBirth.setBounds(81, 179, 90, 16);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblddmmmyyyy = new JLabel("(DD-MMM-YYYY");
		lblddmmmyyyy.setBounds(81, 195, 90, 16);
		contentPane.add(lblddmmmyyyy);
		
		mobile = new JTextField();
		mobile.setBounds(183, 136, 199, 22);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(81, 136, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		age = new JTextField();
		age.setBounds(183, 229, 199, 22);
		contentPane.add(age);
		age.setColumns(10);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(81, 221, 113, 36);
		contentPane.add(lblNewLabel_3);
		
		gender = new JTextField();
		gender.setBounds(183, 270, 199, 22);
		contentPane.add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(81, 270, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("(M or F)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(81, 296, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		city = new JTextField();
		city.setBounds(183, 321, 199, 22);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(81, 324, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		blood = new JTextField();
		blood.setBounds(183, 356, 199, 22);
		contentPane.add(blood);
		blood.setColumns(10);
		
		username = new JTextField();
		username.setBounds(183, 405, 199, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBloodType.setBounds(81, 359, 75, 16);
		contentPane.add(lblBloodType);
		
		JLabel lblNewLabel_7 = new JLabel("(Format: A+)");
		lblNewLabel_7.setBounds(81, 376, 90, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Set Username");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(81, 407, 102, 16);
		contentPane.add(lblNewLabel_8);
		
		pwd = new JTextField();
		pwd.setBounds(183, 440, 199, 22);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		JLabel lblSetPassword = new JLabel("Set Password");
		lblSetPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSetPassword.setBounds(81, 443, 102, 16);
		contentPane.add(lblSetPassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					Statement stmt=con.createStatement();  
					ResultSet rs1 =stmt.executeQuery("SELECT MAX(dId) FROM Donor");
					int id=0;
					while(rs1.next())
					{					
						id=rs1.getInt(1);
												
						if(id==0)
						{	
							id=id+2000;
						
						
						}
						else
							id=id+1;
				    }
					String i=Integer.toString(id);
					String q="insert into Donor(DID,DNAME , DEMAIL, DMOBILE,DDOB,DAGE,DGENDER ,DADDRESS,DBLOOD_TYPE ,DLOGIN_USERNAME,DPWD) values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement rs = con.prepareStatement(q);
					rs.setInt(1,id);
					rs.setString(2,name.getText());
					rs.setString(3,email.getText());
					rs.setString(4,mobile.getText());
					rs.setString(5,dob.getText());
					if(Integer.parseInt(age.getText())<18)
					{	
						JOptionPane.showMessageDialog(null, "Sorry,You aren't applicable for Donating");
						dispose();
					}
					else
						rs.setInt(6,Integer.parseInt(age.getText()));
					rs.setString(7,gender.getText());
					rs.setString(8,city.getText());
					rs.setString(9,blood.getText());
					rs.setString(10,username.getText());
					rs.setString(11,pwd.getText());
					ResultSet ps = rs.executeQuery();
					Statement stmt1=con.createStatement();
					JDialog d=new JDialog();
					JOptionPane.showMessageDialog(null, "Registration Successful\nYour Donor Id is "+i+"\nUsername :"+username.getText()+"\nPassword: "+pwd.getText()+"\nPlease remember for further login");
					con.close();
					Home h= new Home();
					dispose();
				}
				    catch(Exception e)
					{ 
						System.out.println(e);
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,"Please check your Details!\n1.Please enter in the format specified only\n2.Check your Mobile Number\n3.Give proper Credentials\nDonate only if you're 18 and above\n.You might have already registerd...Please check before Registering");
						
					}  
					  
			}  
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(158, 490, 97, 42);
		contentPane.add(btnNewButton);
	}
}
