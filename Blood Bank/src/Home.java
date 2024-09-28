import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class Home extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Login_admin l = new Login_admin();
				}
				catch(Exception e)
				{
					System.out.println("Error");
				}
			}
		});
		btnNewButton.setBounds(126, 62, 205, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Patient");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Login_Patient l =new Login_Patient();
					dispose();
				
				}
				catch(Exception e)
				{
					System.out.println("Error");
				}
}
		});
		btnNewButton_1.setBounds(126, 127, 205, 61);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Donor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Login_Donor l=new Login_Donor();
					dispose();
					
				}
				catch(Exception e)
				{
					System.out.println("Error");
				}
			}
		});
		btnNewButton_2.setBounds(126, 201, 205, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New User/Signup");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
						Register r =new Register();
						dispose();
				}
				catch(Exception e)
				{
					System.out.println("Error");
				}
			}
		});
		btnNewButton_3.setBounds(126, 266, 205, 54);
		contentPane.add(btnNewButton_3);
		
		JLabel lblWelcomeToBlood = new JLabel("Welcome to Blood Bank");
		lblWelcomeToBlood.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWelcomeToBlood.setBounds(87, 13, 284, 36);
		contentPane.add(lblWelcomeToBlood);
	}

}
