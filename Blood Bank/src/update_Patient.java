import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class update_Patient extends JFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_Patient frame = new update_Patient();
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
	public update_Patient(int a) {
		final int b=a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		
		
		
		JLabel lblEnterPatientDetails = new JLabel("Update Your Details(Click Edit)");
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
		
		JButton btnNewButton = new JButton("EDIT");
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
			String h="select * from patient where pId="+b;
			ResultSet rs=stmt.executeQuery(h);  
			while(rs.next())  
			{
				int id=rs.getInt(1);
				textField.setText(rs.getString(2));
				textField_1.setText(rs.getString(3));
				textField_2.setText(rs.getString(4));
				textField_3.setText(month(rs.getString(5)));
				textField_4.setText(rs.getString(6));
				textField_5.setText(rs.getString(7));
				textField_6.setText(rs.getString(8));
				textField_7.setText(rs.getString(9));
				textField_8.setText(rs.getString(10));
				textField_9.setText(rs.getString(11));
			}
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			}
			});
		btnNewButton.setBounds(323, 13, 97, 25);
		getContentPane().add(btnNewButton);
			  
			

		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");   
					Statement stmt=con.createStatement();
					
					
			
							
						
					
					
					String q="update  patient set PNAME= "+"'"+textField.getText()+"'"+
					",PEMAIL="+"'"+textField_1.getText()+"'"+
					",PMOBILE="+"'"+textField_2.getText()+"'"+
					",PDOB="+"'"+textField_3.getText()+"'"+
					",PGENDER="+"'"+ textField_4.getText()+"'"+
					",PATADD="+"'"+textField_5.getText()+"'"+
					",PBLOOD_TYPE="+"'"+textField_6.getText()+"' "+
					",PNEED_STATUS="+"'"+textField_7.getText()+"'"+
					",PLOGIN_USERNAME="+"'"+textField_8.getText()+"'"+
					",PPWD="+"'"+textField_9.getText()+"'"+"where pid="+b;;
					
					PreparedStatement rs = con.prepareStatement(q);
					ResultSet ps = rs.executeQuery();
					Statement stmt1=con.createStatement();
				    JDialog d=new JDialog();
					JOptionPane.showMessageDialog(null, "Updation Successful\nYour Patient id is "+b+"\nUsername: "+textField_8.getText()+"\nPlease remember for further login");
					patient p = new patient(b);
					con.close(); 
					dispose();
					  
					}catch(Exception e)
					{ System.out.println(e);}  
					  
					}  
		
			
		});
		btnUpdate.setBounds(161, 475, 97, 25);
		contentPane.add(btnUpdate);
	}

	public update_Patient() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		
		
	}
	String month(String j)
	{

		StringTokenizer st= new StringTokenizer(j,"-");
		String day = "",s="",yy="";
		while(st.hasMoreTokens())
		{
			
				
				day=st.nextToken();
	            s=st.nextToken();
			    yy=st.nextToken();
			 
		}
		StringTokenizer ss=new StringTokenizer(yy," ");
		String q="",q1="";
		while(ss.hasMoreTokens())
		{
			q=ss.nextToken();
			q1=ss.nextToken();
		}
			String a="";
			String ddd="";
			if(s.equals("01"))
				a="Jan";
			else if(s.equals("02"))
				a="Feb";
			else if(s.equals("03"))
				a="Mar";
			else if(s.equals("04"))
				a="Apr";
			else if(s.equals("05"))
				a="May";
			else if(s.equals("06"))
				a="Jun";
			else if(s.equals("07"))
				a="Jul";
			else if(s.equals("08"))
				a="Aug";
			else if(s.equals("09"))
				a="Sep";
			else if(s.equals("10"))
				a="Oct";
			else if(s.equals("11"))
				a="Nov";
			else if(s.equals("12"))
				a="Dec";
			else
				System.out.println("-");
			ddd=q+"-"+a+"-"+day;
			return ddd;
			
			
		}

}
