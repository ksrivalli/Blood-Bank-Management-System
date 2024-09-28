import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class patientinsert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientinsert frame = new patientinsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public patientinsert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JLabel lblEnterPatientDetails = new JLabel("Enter Patient Details");
		lblEnterPatientDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterPatientDetails.setBounds(78, 13, 326, 43);
		contentPane.add(lblEnterPatientDetails);
		
		textField = new JTextField();
		textField.setBounds(194, 69, 210, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(78, 71, 56, 16);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 104, 210, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(78, 107, 56, 16);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 139, 210, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMobile.setBounds(78, 145, 56, 16);
		contentPane.add(lblMobile);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 174, 210, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date Of Birth");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(78, 174, 103, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblddmmmyyyy = new JLabel("(DD-MMM-YYYY)");
		lblddmmmyyyy.setBounds(78, 195, 104, 16);
		contentPane.add(lblddmmmyyyy);
		
		textField_4 = new JTextField();
		textField_4.setBounds(194, 225, 210, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender(M or F)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(78, 228, 103, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(194, 260, 210, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(78, 263, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(194, 295, 210, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBloodType.setBounds(78, 298, 103, 16);
		contentPane.add(lblBloodType);
		
		textField_7 = new JTextField();
		textField_7.setBounds(194, 336, 210, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNeedStatus = new JLabel("Need Status");
		lblNeedStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNeedStatus.setBounds(78, 339, 103, 16);
		contentPane.add(lblNeedStatus);
		
		JLabel lblNewLabel_3 = new JLabel("(high or low)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(78, 354, 103, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setBounds(194, 377, 210, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Set Username");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(78, 379, 103, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_9 = new JTextField();
		textField_9.setBounds(194, 422, 210, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblSetPassword = new JLabel("Set Password");
		lblSetPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSetPassword.setBounds(78, 425, 103, 16);
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
					ResultSet rs1 =stmt.executeQuery("SELECT MAX(pId) FROM patient");
					int id=0;
					while(rs1.next())
					{					
						id=rs1.getInt(1) +1;
					}
					String i=Integer.toString(id);
					String q="insert into patient(pId,PNAME , PEMAIL, PMOBILE,PDOB,PGENDER , PATADD,PBLOOD_TYPE , PNEED_STATUS ,PLOGIN_USERNAME,PPWD) values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement rs = con.prepareStatement(q);
					rs.setInt(1,id);
					rs.setString(2,textField.getText());
					rs.setString(3,textField_1.getText());
					rs.setString(4,(textField_2.getText()));
					rs.setString(5,textField_3.getText());
					rs.setString(6,textField_4.getText());
					rs.setString(7,textField_5.getText());
					rs.setString(8,textField_6.getText());
					rs.setString(9,textField_7.getText());
					rs.setString(10,textField_8.getText());
					rs.setString(11,textField_9.getText());
					ResultSet ps = rs.executeQuery();
					Statement stmt1=con.createStatement();
				    JDialog d=new JDialog();
					JOptionPane.showMessageDialog(null, "Registration Successful\nYour Patient id is "+i+"\nUsername: "+textField_8.getText()+"\nPlease remember for further login");
					Home h= new Home();
					con.close(); 
					dispose();
					  
					}catch(Exception e)
					{ 
						System.out.println(e);
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,"Please check your Details!\n1.Please enter in the format specified only\n2.Check your Mobile Number\n3.Give proper Credentials\nYou might have already registerd...Please check before Registering");
						
					}
					  
					}  
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(194, 480, 210, 25);
		contentPane.add(btnNewButton);
	}
}
