import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Register extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Patient");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(145, 41, 127, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Donor");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(145, 78, 127, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);    
		
		JLabel lblNewLabel = new JLabel("Choose Category");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 13, 155, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(rdbtnNewRadioButton.isSelected()==true)
					{
						rdbtnNewRadioButton_1.setSelected(false);
						patientinsert p=new patientinsert();
						dispose();
						
					}
					else if(rdbtnNewRadioButton_1.isSelected()==true)
					{
						
						Donor_insert d =new Donor_insert();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please select a category");
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception");
					
				}
			}
		});
		btnSubmit.setBounds(126, 125, 108, 36);
		contentPane.add(btnSubmit);}}
	

