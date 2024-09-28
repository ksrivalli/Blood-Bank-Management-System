import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;


public class Donor extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor frame = new Donor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	public Donor(final int n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JButton btnNewButton = new JButton("View Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					//String id=JOptionPane.showInputDialog("Please Enter your Patiend ID");
					//int i=Integer.parseInt(id);
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					   
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					
					String s="select * from donor where did="+n;
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(s);
					
				    JFrame d =new JFrame("Donor Table");
				    JLabel l = new JLabel();
				    JLabel l1 = new JLabel("Donor's Profile");
				    d.getContentPane().add(l1);
				    while(rs.next())
				    l.setText("<html>Donor Id : "+rs.getInt(1)+"<br/>Name : "+rs.getString(2)+"<br/>Email : "+rs.getString(3)+"<br/>Mobile : "+rs.getString(4)+"<br/>Date of Birth : "+month(rs.getString(5))+"<br/>Age : "+rs.getString(6)+"<br/>Gender : "+rs.getString(7)+"<br/>City : "+rs.getString(8)+"<br/>Blood Type : "+rs.getString(9)+"<br/>Username : "+rs.getString(10)+"</html>");
				    d.getContentPane().add(l);
					
					d.getContentPane().setLayout(new FlowLayout());
					d.setSize(300,300); 
					d.setVisible(true); 
					con.close();  
					  
					}catch(Exception e){ e.printStackTrace();}  
					  
					}  
		
			
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBounds(155, 74, 157, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update_donor d= new update_donor(n);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(155, 124, 157, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Donate");
		btnNewButton_2.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					   
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					
					String s="select dBlood_type from donor where did="+n;
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(s);
					String bld="";
					while(rs.next())
						bld=rs.getString(1);
					int a =JOptionPane.showConfirmDialog(null, "Please make sure you are 18 years and above before donating\nDo upu confirm?");
					//System.out.println(a);
					if(a==0)
					{
					donation f=new donation(n,bld);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(155, 174, 157, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h = new Home();
				JOptionPane.showMessageDialog(null,"Signed Out");
				dispose();
			}
		});
		btnNewButton_3.setBounds(155, 224, 157, 42);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(184, 26, 147, 35);
		contentPane.add(lblNewLabel);
		setVisible(true);
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
