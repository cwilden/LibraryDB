package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CheckoutGUI extends JFrame {

	public JFrame frame;
	public JLabel bookIDlabel;
	public JLabel cardNoLabel;
	public JLabel msgLabel;

	public JButton checkOutBtn;
	public JButton mainButton;


	public static int noOfCopies;
	public static Date date = new Date();
	public static int copiesAvailable;
	public static int cardNum;
	public static String bookTitle;
	public static String cardName;
	public static String bookId;
	public static String cardNo;

	public JTextField bookIdtxt;
	public JTextField cardNotxt;


	public CheckoutGUI(String title)
	{
		super(title);
		setSize(700,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		bookIDlabel = new JLabel("Book ID");
		bookIDlabel.setFont(new Font("Garamond", Font.PLAIN, 16));
		bookIDlabel.setBounds(37, 73, 131, 14);
		getContentPane().add(bookIDlabel);


		cardNoLabel = new JLabel("Card No.");
		cardNoLabel.setFont(new Font("Garamond", Font.PLAIN, 16));
		cardNoLabel.setBounds(37, 219, 131, 14);
		getContentPane().add(cardNoLabel);

		bookIdtxt = new JTextField();
		bookIdtxt.setFont(new Font("Garamond", Font.PLAIN, 16));
		bookIdtxt.setBounds(162, 70, 250, 20);
		getContentPane().add(bookIdtxt);
		bookIdtxt.setColumns(10);

		cardNotxt = new JTextField();
		cardNotxt.setFont(new Font("Garamond", Font.PLAIN, 16));
		cardNotxt.setBounds(162, 216, 250, 20);
		getContentPane().add(cardNotxt);
		cardNotxt.setColumns(10);

		checkOutBtn = new JButton("Check out");
		checkOutBtn.setFont(new Font("Garamond", Font.PLAIN,16));
		checkOutBtn.setBounds(500, 111, 131, 23);
		getContentPane().add(checkOutBtn);

		mainButton = new JButton("Main");
		mainButton.setFont(new Font("Garamond", Font.PLAIN, 16));
		mainButton.setBounds(500, 180, 131, 23);
		getContentPane().add(mainButton);

		msgLabel = new JLabel("");
		msgLabel.setBounds(137, 292, 486, 33);
		getContentPane().add(msgLabel);


		if(SearchGUI.indicate==1)
		{
			bookIdtxt.setText(bookId);
		}


		checkOutBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Calendar c= Calendar.getInstance();
				c.setTime(new Date());
				c.add(Calendar.DATE, 14);
				String date=df.format(c.getTime());
				System.out.println(date);


				cardNo=cardNotxt.getText();
				cardNum=Integer.valueOf(cardNo);


				Checkout.check();
				if(Checkout.flag==0)
				{
					if(noOfCopies==3)
					{
						msgLabel.setText("Sorry, You have reached the checkout limit");
						msgLabel.setFont(new Font("Garamond", Font.BOLD,16));

					}
					else
						if(copiesAvailable<=0)
						{
							msgLabel.setText("Sorry, No more copies available");
							msgLabel.setFont(new Font("Garamond", Font.BOLD,16));

						}
				}

				else
				{
					msgLabel.setText("Book is checked out. Due date is " + date);
					msgLabel.setFont(new Font("Garamond", Font.BOLD,16));

				}
				repaint();
			}
		});

		mainButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				SearchGUI.frame.setVisible(true);
			}
		});
	}
}
