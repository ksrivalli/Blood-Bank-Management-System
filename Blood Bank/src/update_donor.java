import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;


public class update_donor extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_donor frame = new update_donor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public update_donor(final int n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Enter Donor Details(Click Edit)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 13, 215, 28);
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
		
		JButton btnNewButton = new JButton("Edit");
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
					String h="select * from donor where dId="+n;
					ResultSet rs=stmt.executeQuery(h);  
					while(rs.next())  
					{
						int id=rs.getInt(1);
						name.setText(rs.getString(2));
						email.setText(rs.getString(3));
						mobile.setText(rs.getString(4));
						dob.setText(month(rs.getString(5)));
						age.setText(Integer.toString(rs.getInt(6)));
						gender.setText(rs.getString(7));
						city.setText(rs.getString(8));
						blood.setText(rs.getString(9));
						username.setText(rs.getString(10));
						pwd.setText(rs.getString(11));
					}
					  
					//step5 close the connection object  
					con.close();  
					  
					}catch(Exception e){ System.out.println(e);}  
			}
		});
		btnNewButton.setBounds(312, 16, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");   
					Statement stmt=con.createStatement();
					
					
			
							
						
					
					
					String q="update  donor set dNAME= "+"'"+name.getText()+"'"+
					",dEMAIL="+"'"+email.getText()+"'"+
					",dMOBILE="+"'"+mobile.getText()+"'"+
					",dDOB="+"'"+dob.getText()+"'"+
					",dAGE="+"'"+ age.getText()+"'"+
					",dGENDER="+"'"+gender.getText()+"'"+
					",dADDRESS="+"'"+city.getText()+"' "+
					",Dblood_type="+"'"+blood.getText()+"'"+
					",dLOGIN_USERNAME="+"'"+username.getText()+"'"+
					",dPWD="+"'"+pwd.getText()+"'"+"where did="+n;;
					
					PreparedStatement rs = con.prepareStatement(q);
					ResultSet ps = rs.executeQuery();
					Statement stmt1=con.createStatement();
				    JDialog d=new JDialog();
					JOptionPane.showMessageDialog(null, "Updation Successful\nYour Patient id is "+n+"\nUsername: "+username.getText()+"\nPlease remember for further login");
					Donor f=new Donor(n);
					con.close(); 
					dispose();
					  
					}catch(Exception e)
					{ System.out.println(e);}  
					  
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(183, 488, 97, 25);
		contentPane.add(btnNewButton_1);
		
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
