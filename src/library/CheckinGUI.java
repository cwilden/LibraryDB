package library;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class CheckinGUI extends JFrame {

	public Checkbox bookIdchx;
	public Checkbox borrowerchx;
	public Checkbox cardNochx;

	public static JButton checkInBtn;
	public static JButton SearchBtn;
	public static JButton MainBtn;
	
	public JTextField bookIdtxt;
	public JTextField nametxt;
	public JTextField cardNotxt;
	
	public static String bookID;
	public static String borrowerName;
	public static String cardNo;
	public static String book_search;

	public JLabel bookIdlbl;
	public JLabel nameLbl;
	public JLabel cardNolbl;
	public JLabel msgLbl;

	static public Object row[][] = new Object[5000][5000];
	Object column[] = { "LOAN_ID","ISBN","CARD_NO","DATE_OUT","DUE_DATE","DATE_IN" };
	Object data[];


	public CheckinGUI(String title)
	{
		super(title);
		setSize(700,540);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		bookIdlbl = new JLabel("Book ID");
		bookIdlbl.setFont(new Font("Garamond", Font.PLAIN,16));
		bookIdlbl.setBounds(34, 59, 103, 14);
		getContentPane().add(bookIdlbl);

		nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Garamond", Font.PLAIN,16));
		nameLbl.setBounds(34, 89, 103, 14);
		getContentPane().add(nameLbl);

		cardNolbl = new JLabel("Card No.");
		cardNolbl.setFont(new Font("Garamond", Font.PLAIN,16));
		cardNolbl.setBounds(34, 115, 103, 14);
		getContentPane().add(cardNolbl);

		msgLbl = new JLabel("");
		msgLbl.setBounds(300, 480, 300, 14);
		getContentPane().add(msgLbl);

		bookIdtxt = new JTextField();
		bookIdtxt.setFont(new Font("Garamond", Font.PLAIN,16));
		bookIdtxt.setBounds(200, 59, 250, 20);
		getContentPane().add(bookIdtxt);
		bookIdtxt.setColumns(10);

		nametxt = new JTextField();
		nametxt.setFont(new Font("Garamond", Font.PLAIN, 16));
		nametxt.setBounds(200, 88, 250, 20);
		getContentPane().add(nametxt);
		nametxt.setColumns(10);

		cardNotxt = new JTextField();
		cardNotxt.setFont(new Font("Garamond", Font.PLAIN, 16));
		cardNotxt.setBounds(200, 114, 250, 20);
		getContentPane().add(cardNotxt);
		cardNotxt.setColumns(10);
		
		bookIdchx = new Checkbox("");
		bookIdchx.setBounds(6, 59, 22, 23);
		getContentPane().add(bookIdchx);

		borrowerchx = new Checkbox("");
		borrowerchx.setBounds(6, 85, 22, 23);
		getContentPane().add(borrowerchx);

		cardNochx = new Checkbox("");
		cardNochx.setBounds(6, 111, 22, 23);
		getContentPane().add(cardNochx);

		checkInBtn = new JButton("Check In");
		checkInBtn.setFont(new Font("Garamond", Font.PLAIN,16));
		checkInBtn.setBounds(500, 59, 100, 23);
		getContentPane().add(checkInBtn);

		SearchBtn = new JButton("Search");
		SearchBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		SearchBtn.setBounds(500, 85, 100, 23);
		getContentPane().add(SearchBtn);
		
		MainBtn = new JButton("Main");
		MainBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		MainBtn.setBounds(500, 115, 100, 23);
		getContentPane().add(MainBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 164, 650, 295);
		scrollPane.setFont(new Font("Garamond", Font.PLAIN,16));
		getContentPane().add(scrollPane);

		final JTable table_1 = new JTable(row,column);
		scrollPane.setViewportView(table_1);

		if(SearchGUI.indicate==1)
		{
			bookIdtxt.setText(book_search);
		}

		checkInBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				AbstractButton button = (AbstractButton)e.getSource();
				int row=0;
				if(e.getActionCommand().equals(button.getActionCommand()))
				{
					row=table_1.getSelectedRow();
				}

				Checkin.book_id=(String)table_1.getValueAt(row,1);
				Checkin.Card_no=(String) table_1.getValueAt(row,2);

				Checkin.update();

				msgLbl.setText("Book is checked in.");
				msgLbl.setFont(new Font("Garamond", Font.BOLD,16));

				repaint();

			}
		});

		SearchBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				borrowerName=nametxt.getText();
				bookID=bookIdtxt.getText();
				cardNo=cardNotxt.getText();
				
				if(borrowerchx.getState())
				{
					for(int i=0;i<9;i++)
					{
						CheckinGUI.row[i][0] = "";
						CheckinGUI.row[i][1] = "";
						CheckinGUI.row[i][2] = "";
						CheckinGUI.row[i][3] = "";
						CheckinGUI.row[i][4] = "";
						CheckinGUI.row[i][5] = "";

					}

					msgLbl.setText(" ");

					Checkin.borrower();
				}
				else if(bookIdchx.getState())
				{
					for(int i=0;i<9;i++)
					{
						CheckinGUI.row[i][0] = "";
						CheckinGUI.row[i][1] = "";
						CheckinGUI.row[i][2] = "";
						CheckinGUI.row[i][3] = "";
						CheckinGUI.row[i][4] = "";
						CheckinGUI.row[i][5] = "";

					}
					msgLbl.setText(" ");

					Checkin.bookID();
				}

				else if(cardNochx.getState())
				{
					for(int i=0;i<9;i++)
					{
						CheckinGUI.row[i][0] = "";
						CheckinGUI.row[i][1] = "";
						CheckinGUI.row[i][2] = "";
						CheckinGUI.row[i][3] = "";
						CheckinGUI.row[i][4] = "";
						CheckinGUI.row[i][5] = "";

					}

					msgLbl.setText(" ");

					Checkin.cardNo();
				}
				else if(bookIdchx.getState() && borrowerchx.getState())
				{
					for(int i=0;i<9;i++)
					{
						CheckinGUI.row[i][0] = "";
						CheckinGUI.row[i][1] = "";
						CheckinGUI.row[i][2] = "";
						CheckinGUI.row[i][3] = "";
						CheckinGUI.row[i][4] = "";
						CheckinGUI.row[i][5] = "";

					}
					msgLbl.setText(" ");
					Checkin.bookBorrower();

				}
				else if(bookIdchx.getState() && cardNochx.getState())
				{
					for(int i=0;i<9;i++)
					{
						CheckinGUI.row[i][0] = "";
						CheckinGUI.row[i][1] = "";
						CheckinGUI.row[i][2] = "";
						CheckinGUI.row[i][3] = "";
						CheckinGUI.row[i][4] = "";
						CheckinGUI.row[i][5] = "";

					}
					msgLbl.setText(" ");
					Checkin.bookCard();
				}

				else if(bookIdchx.getState() && cardNochx.getState() && borrowerchx.getState())
				{
					for(int i=0;i<9;i++)
					{
						CheckinGUI.row[i][0] = "";
						CheckinGUI.row[i][1] = "";
						CheckinGUI.row[i][2] = "";
						CheckinGUI.row[i][3] = "";
						CheckinGUI.row[i][4] = "";
						CheckinGUI.row[i][5] = "";
					}
					msgLbl.setText(" ");
					Checkin.bookCardName();

				}
				else
				{
					msgLbl.setText("Please enter Book ID, Title and/or Author Name.");
					msgLbl.setFont(new Font("Garamond", Font.BOLD,16));
				}

				repaint();
			}

		});

		MainBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				SearchGUI.frame.setVisible(true);
			}
		});

	}
}

