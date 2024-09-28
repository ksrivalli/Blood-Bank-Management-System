import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javafx.scene.text.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;


public class patient extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient frame = new patient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	public patient(int n) {
		final int a=n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setVisible(true);
		setContentPane(contentPane);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					   
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					
					String s="select * from patient where pid="+a;
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(s);
					
				    JFrame d =new JFrame("Patient Table");
				    JLabel l = new JLabel();
				    
				    d.getContentPane();
				    while(rs.next())
				    {	
				    l.setText("<html>PROFILE<br/><br/>Patient Id : "+rs.getInt(1)+"<br/>Name : "+rs.getString(2)+"<br/>Email : "+rs.getString(3)+"<br/>Mobile : "+rs.getString(4)+"<br/>Date of Birth : "+month(rs.getString(5))+"<br/>Gender : "+rs.getString(6)+"<br/>City : "+rs.getString(7)+"<br/>Blood Type : "+rs.getString(8)+"<br/>Need Status : "+rs.getString(9)+"<br/>Username : "+rs.getString(10)+"</html>");
				    }
				    d.getContentPane().add(l);
					d.getContentPane().setLayout(new FlowLayout());
					d.setSize(300,300); 
					d.setVisible(true); 
					con.close();  
					  
					}catch(Exception e){ e.printStackTrace();}  
					  
					}  
				
			
		});
		btnViewProfile.setBounds(167, 57, 120, 46);
		contentPane.add(btnViewProfile);
		
		JButton btnNewButton = new JButton("Search Donors");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");   
					Statement stmt=con.createStatement();  
					String s =JOptionPane.showInputDialog("Please Enter Blood Group You Need");
					String q="select DID,DNAME,DEMAIL,DMOBILE,DADDRESS,DBLOOD_TYPE from Donor where DBLOOD_TYPE ="+"'"+s+"'";
					ResultSet rs=stmt.executeQuery(q);  
					JFrame d =new JFrame("Donors Table");
					JPanel tablePanel = new JPanel(new BorderLayout());   
					JTable j=new JTable();
					j.setModel(DbUtils.resultSetToTableModel(rs));
					tablePanel.add(j, BorderLayout.CENTER);
					tablePanel.add(j.getTableHeader(), BorderLayout.NORTH);
					d.getContentPane().add(tablePanel);
					d.getContentPane().setLayout(new FlowLayout());
					d.setSize(800,800); 
					d.setVisible(true);  
					con.close();  
					  
					}catch(Exception e){ 
						System.out.println(e);}  
					  
					}  
		});
		btnNewButton.setBounds(167, 116, 120, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Details");
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				update_Patient p =new update_Patient(a);
			}
			
		});
		btnNewButton_1.setBounds(167, 175, 120, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h = new Home();
				JOptionPane.showMessageDialog(null,"Signed Out");
				dispose();
			}
		});
		btnNewButton_2.setBounds(167, 234, 120, 46);
		contentPane.add(btnNewButton_2);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 19));
		lblWelcome.setBounds(183, 13, 186, 31);
		contentPane.add(lblWelcome);
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
