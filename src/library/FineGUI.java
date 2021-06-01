package library;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class FineGUI extends JFrame {

	public JFrame frame;
	public static JTextField cardNoTxt;
	
	public static JButton checkBtn;
	public static JButton payBtn;
	public static JButton refreshBtn;
	public static JButton searchBtn;
	private JLabel msgLbl;
	private JLabel msgLbl2;
	public static JLabel cardNolbl;

	public static String cardNoName;
	public static double fine;
	public static double estimatedFine;
	
	public FineGUI(String title)
	{
		super(title);
		setSize(390,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		cardNolbl = new JLabel("Card No.");
		cardNolbl.setFont(new Font("Garamond", Font.PLAIN,16));
		cardNolbl.setBounds(26, 59, 100, 14);
		getContentPane().add(cardNolbl);
		
		msgLbl = new JLabel("");
		msgLbl.setBounds(55, 286, 203, 32);
		getContentPane().add(msgLbl);
		
		msgLbl2 = new JLabel("");
		msgLbl2.setBounds(47, 329, 187, 34);
		getContentPane().add(msgLbl2);
		
		JLabel lblNewLabel = new JLabel("Click 'Refresh' before Checking or Paying Fine.");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 11, 395, 14);
		getContentPane().add(lblNewLabel);
		
		checkBtn = new JButton("Check Fine");
		checkBtn.setFont(new Font("Garamond", Font.PLAIN,16));
		checkBtn.setBounds(47, 119, 124, 23);
		getContentPane().add(checkBtn);
		
		payBtn = new JButton("Pay Fine");
		payBtn.setFont(new Font("Garamond", Font.PLAIN,16));
		payBtn.setBounds(47, 153, 124, 23);
		getContentPane().add(payBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setFont(new Font("Garamond", Font.PLAIN,16));
		refreshBtn.setBounds(47, 187, 124, 23);
		getContentPane().add(refreshBtn);
		
		searchBtn = new JButton("Main");
		searchBtn.setFont(new Font("Garamond", Font.PLAIN,16));
		searchBtn.setBounds(214, 153, 124, 23);
		getContentPane().add(searchBtn);
		
		cardNoTxt = new JTextField();
		cardNoTxt.setFont(new Font("Garamond", Font.PLAIN,16));
		cardNoTxt.setBounds(214, 56, 165, 20);
		getContentPane().add(cardNoTxt);
		cardNoTxt.setColumns(10);
		
		checkBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				msgLbl.setText(" ");
				cardNoName=cardNoTxt.getText();
				Fine.check();
				
				msgLbl2.setText("Please Pay fine: "+fine);
				msgLbl2.setFont(new Font("Garamond", Font.PLAIN,16));
				Fine.calculate();
				msgLbl2.setText("Estimated fine: " + estimatedFine);
				
				//System.out.println("Check Fine");
				
			}
		});
		
		payBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
					Fine.payFine();
					msgLbl.setText("Paid");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,16));
					msgLbl2.setText(" ");
					//System.out.println("Pay fine");
			}
		});
		
		refreshBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fine=0.0;
				estimatedFine=0.0;
				Fine.refresh();
				//System.out.println("Refresh");
				msgLbl.setText(" ");
				msgLbl2.setText(" ");
			}
		});
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				SearchGUI.frame.setVisible(true);
			}
		});
	}
}
