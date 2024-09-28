import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.sql.*;  
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import java.awt.Font;


public class admin extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JButton btnViewPatients = new JButton("View Patients");
		btnViewPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select pId,PNAME , PEMAIL, PMOBILE,PDOB,PGENDER , PATADD,PBLOOD_TYPE , PNEED_STATUS ,PLOGIN_USERNAME from patient");
					JFrame d =new JFrame("Patient Table");
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
				  }
				   catch(Exception e){ 
					   System.out.println(e);}  
					  
				   }  
			
		});
		btnViewPatients.setBounds(156, 105, 152, 57);
		contentPane.add(btnViewPatients);
		
		JButton btnViewDonors = new JButton("View Donors");
		btnViewDonors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Class.forName("oracle.jdbc.driver.OracleDriver");   
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
				Statement stmt=con.createStatement();  
				  
				ResultSet rs=stmt.executeQuery("select DID,DNAME,DEMAIL, DMOBILE,DDOB,DAGE,DGENDER ,DADDRESS,DBLOOD_TYPE ,DLOGIN_USERNAME from donor");
				JFrame d =new JFrame("Donor Table");
				JPanel tablePanel = new JPanel(new BorderLayout());   
				JTable j=new JTable();
				j.setModel(DbUtils.resultSetToTableModel(rs));
				tablePanel.add(j, BorderLayout.CENTER);
				tablePanel.add(j.getTableHeader(), BorderLayout.NORTH);
				d.getContentPane().add(tablePanel);
				d.getContentPane().setLayout(new FlowLayout());
				d.setSize(800,800); 
			    d.setVisible(true); 
				con.close();  }
			
			catch(Exception e)
			{
				System.out.println("Error");
			}
			}
		
		});
		btnViewDonors.setBounds(156, 175, 152, 49);
		contentPane.add(btnViewDonors);
		
		JButton btnNewButton = new JButton("Check Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from Blood");
					JFrame d =new JFrame("Stock");
					JPanel tablePanel = new JPanel(new BorderLayout());   
					JTable j=new JTable();
					j.setModel(DbUtils.resultSetToTableModel(rs));
					tablePanel.add(j, BorderLayout.CENTER);
					tablePanel.add(j.getTableHeader(), BorderLayout.NORTH);
					d.getContentPane().add(tablePanel);
				    d.getContentPane().setLayout(new FlowLayout());
					d.setSize(800,800); 
					 d.setVisible(true); 
					con.close();  }
				
				catch(Exception e)
				{
					System.out.println("Error");
				}
			}
		});
		btnNewButton.setBounds(156, 237, 152, 49);
		contentPane.add(btnNewButton);
		
		JButton btnBackToHome = new JButton("Logout");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Home h = new Home();
				dispose();
			}
		});
		btnBackToHome.setBounds(156, 369, 152, 49);
		contentPane.add(btnBackToHome);
		
		JButton btnNewButton_1 = new JButton("View Samples");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");   
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","sarvani","vasavi");  
					Statement stmt=con.createStatement();  
					  
					ResultSet rs=stmt.executeQuery("select * from sample");
					JFrame d =new JFrame("Samples Table");
					JPanel tablePanel = new JPanel(new BorderLayout());   
					JTable j=new JTable();
					j.setModel(DbUtils.resultSetToTableModel(rs));
					tablePanel.add(j, BorderLayout.CENTER);
					tablePanel.add(j.getTableHeader(), BorderLayout.NORTH);
					d.getContentPane().add(tablePanel);
					d.getContentPane().setLayout(new FlowLayout());
					d.setSize(800,800); 
				    d.setVisible(true); 
					con.close();  }
				
				catch(Exception e)
				{
					System.out.println("Error");
				}
				
			}
		});
		btnNewButton_1.setBounds(156, 299, 152, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(152, 43, 268, 46);
		contentPane.add(lblNewLabel);
	}

}
