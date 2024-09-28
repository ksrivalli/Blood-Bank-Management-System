import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;


public class donation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donation frame = new donation();
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
	public donation(final int n,final String bld) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 91, 334, 311);
		contentPane.add(textArea);
		

		final JLabel lblNewLabel_1 = new JLabel("Thank you for Donating");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(99, 420, 321, 44);
		
		JLabel lblNewLabel = new JLabel("Click above Button");
		lblNewLabel.setBounds(160, 62, 104, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Get Confirmation Receipt of Donation");
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
					ResultSet rs1 =stmt.executeQuery("SELECT MAX(sid) FROM sample");
					int id=0;
					while(rs1.next())
					{					
						id=rs1.getInt(1);
												
						if(id==0)
						{	
							id=id+3000;
						
						
						}
						else
							id=id+1;
				    }
					long millis=System.currentTimeMillis();  
					java.sql.Date date=new java.sql.Date(millis);
					
				    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					String text = df.format(date);
					
					StringTokenizer st= new StringTokenizer(text,"-");
					String day = "",mon="",yy="";
					while(st.hasMoreTokens())
					{
						day=st.nextToken();
						mon=st.nextToken();
						yy=st.nextToken();
						
					}
					String mm=month(mon);
					String don=day+"-"+mm+"-"+yy;
					System.out.print("Actually"+don);
					
					
				    String q3="SELECT bid FROM blood where bld_type="+"'"+bld+"'";
				    System.out.println(q3);
				    ResultSet rs2 =stmt.executeQuery(q3);
				    int bb=0;
				    while(rs2.next())
				    {
				    	bb=rs2.getInt(1);
				    }
				    
				    String q2="insert into sample(sid,did,dondate,blood_type,bid) values(?,?,?,?,?)";
				    
				    PreparedStatement us = con.prepareStatement(q2); 
				    us.setInt(1,id);
				    us.setInt(2, n);
				    us.setString(3, don);
				    us.setString(4, bld);
				    us.setInt(5, bb);
				    ResultSet ps = us.executeQuery();
					Statement stmt1=con.createStatement();
					String q4="Update blood set qty=qty+1 where bid ="+bb;
					
				    ResultSet rs4=stmt1.executeQuery(q4);
				    
				    String t="select * from sample where did="+n;
				    
		             ResultSet rs5=stmt.executeQuery(t);
				    while(rs5.next())
				    {
				    	textArea.setText("Sample ID: "+rs5.getInt(1)+"\nDONOR ID : "+rs5.getInt(2)+"\nDonation Date: "+rs5.getString(3)+"\nBlood Type : "+rs5.getString(4)+"\nYour samples will be Collected Today!");
				    	
				    }
				    contentPane.add(lblNewLabel_1);
				    
					con.close();  
					  
					}catch(Exception e){ System.out.println(e);}  
					  
					}  
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(23, 13, 360, 44);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Donor g= new Donor(n);
				dispose();
			}
		});
		btnBack.setBounds(323, 415, 97, 25);
		contentPane.add(btnBack);
		
		
		
	}
	String month(String s)
	{
		String a="";
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
			
		return a;
		
		
	}
}
