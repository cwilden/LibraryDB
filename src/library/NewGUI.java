package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class NewGUI extends JFrame {
	
	public JFrame frame;
	public JButton signUpbtn;
	public JButton searchbtn;
	
	public JTextField fnameTxt;
	public JTextField lnameTxt;
	public JTextField addressTxt;
	public JTextField phoneTxt;
	public JTextField ssnTxt;
	
	public JLabel fnameLbl;
	public JLabel lnameLbl;
	public JLabel addressLbl;
	public JLabel phoneLbl;
	public JLabel ssnLbl;
	public JLabel msgLbl;
	
	public static int rem;
	public static String ssn;
	public static String fname;
	public static String lname;
	public static String address;
	public static String phone;
	public static String state;
	public static String city;

	
	public NewGUI(String title) {
		
		super(title);
		setSize(800,360);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ssnLbl = new JLabel("SSN");
		ssnLbl.setFont(new Font("Garamond", Font.PLAIN,16));
		ssnLbl.setBounds(22, 31, 80, 14);
		getContentPane().add(ssnLbl);
		
		fnameLbl = new JLabel("First Name");
		fnameLbl.setFont(new Font("Garamond", Font.PLAIN, 16));
		fnameLbl.setBounds(22, 64, 80, 14);
		getContentPane().add(fnameLbl);
		
		lnameLbl = new JLabel("Last Name");
		lnameLbl.setFont(new Font("Garamond", Font.PLAIN, 16));
		lnameLbl.setBounds(22, 103, 80, 14);
		getContentPane().add(lnameLbl);
		
		addressLbl = new JLabel("Address");
		addressLbl.setFont(new Font("Garamond", Font.PLAIN, 16));
		addressLbl.setBounds(22, 141, 80, 14);
		getContentPane().add(addressLbl);
		
		phoneLbl = new JLabel("Phone");
		phoneLbl.setFont(new Font("Garamond", Font.PLAIN, 16));
		phoneLbl.setBounds(22, 213, 80, 14);
		getContentPane().add(phoneLbl);
		
		msgLbl = new JLabel("");
		msgLbl.setBounds(205, 260, 397, 65);
		getContentPane().add(msgLbl);
		
		fnameTxt = new JTextField();
		fnameTxt.setFont(new Font("Garamond", Font.PLAIN, 16));
		fnameTxt.setBounds(149, 61, 309, 20);
		getContentPane().add(fnameTxt);
		fnameTxt.setColumns(10);
		
		lnameTxt = new JTextField();
		lnameTxt.setFont(new Font("Garamond", Font.PLAIN,16));
		lnameTxt.setBounds(149, 100, 309, 20);
		getContentPane().add(lnameTxt);
		lnameTxt.setColumns(10);
		
		addressTxt = new JTextField();
		addressTxt.setFont(new Font("Garamond", Font.PLAIN,16));
		addressTxt.setBounds(149, 138, 309, 47);
		getContentPane().add(addressTxt);
		addressTxt.setColumns(10);
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("Garamond", Font.PLAIN,16));
		phoneTxt.setBounds(149, 210, 309, 20);
		getContentPane().add(phoneTxt);
		phoneTxt.setColumns(10);
		
		ssnTxt = new JTextField();
		ssnTxt.setFont(new Font("Garamond", Font.PLAIN,16));
		ssnTxt.setBounds(149, 28, 309, 20);
		getContentPane().add(ssnTxt);
		ssnTxt.setColumns(10);
		
		signUpbtn = new JButton("Sign Up");
		signUpbtn.setFont(new Font("Garamond", Font.PLAIN,16));
		signUpbtn.setBounds(506, 77, 209, 23);
		getContentPane().add(signUpbtn);
		
		searchbtn = new JButton("Main");
		searchbtn.setFont(new Font("Garamond", Font.PLAIN,16));
		searchbtn.setBounds(506, 152, 209, 23);
		getContentPane().add(searchbtn);
		
		signUpbtn.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				ssn=ssnTxt.getText();
				fname=fnameTxt.getText();
				lname=lnameTxt.getText();
				address=addressTxt.getText();
				phone=phoneTxt.getText();
				
				
				New.select();
				if(!phone.matches("[0-9]+"))
				{
					msgLbl.setText("Invalid Phone Number: Only Digits Allowed");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,16));
				}
				else if(rem==1)
				{
					System.out.println("Reject");
					msgLbl.setText("User already exists");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,16));
				}
				else
				{
					msgLbl.setText("Creating....");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,16));
					New.create();
					msgLbl.setText("Your Card Number is: " + New.cardResult);
				}
				repaint();
				
			}
		});
		
		searchbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				SearchGUI.frame.setVisible(true);
			}
		});
	}
}
