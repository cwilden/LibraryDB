package library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class SearchGUI extends JFrame {
	
	public static SearchGUI frame;
	public JTextField isbnTxt;
	public JTextField bookTitleTxt;
	public JTextField authorTxt;
	
	public JButton searchBtn;
	public JButton newuserBtn;
	public JButton checkoutBtn;
	public JButton checkinBtn;
	public JButton fineBtn;
	
	public JLabel isbnLbl;
	public JLabel booktitleLbl;
	public JLabel authorLbl;
	public JLabel msgLbl;
	
	static public Object row[][] = new Object[5000][5000];
	public static int indicate;
	Object column[] = { "ISBN", "Title", "Author(s)", "Copies available"};
	Object selected[];
	
	Checkbox isbnchx = new Checkbox();
	Checkbox booktitlechx = new Checkbox();
	Checkbox authorchx = new Checkbox();
	
	public static String name;
	public static String isbn;
	public static String titlebook;
	public static int BookID;
	public static int NoOfCopies;
	
	public static CheckoutGUI checkout;
	public static CheckinGUI checkin;
	public static FineGUI fine;
	public static NewGUI newuser;
	
	public SearchGUI(String title)

	{	
		super(title);
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter to search for book:");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 11, 350, 14);
		getContentPane().add(lblNewLabel);
		
		isbnLbl = new JLabel("ISBN");
		isbnLbl.setFont(new Font("Garamond", Font.PLAIN, 18));
		isbnLbl.setBounds(50, 48, 100, 14);
		getContentPane().add(isbnLbl);
		
		booktitleLbl = new JLabel("Book Title");
		booktitleLbl.setFont(new Font("Garamond", Font.PLAIN, 18));
		booktitleLbl.setBounds(50, 82, 77, 14);
		getContentPane().add(booktitleLbl);
		
		authorLbl = new JLabel("Author");
		authorLbl.setFont(new Font("Garamond", Font.PLAIN, 18));
		authorLbl.setBounds(50, 123, 77, 14);
		getContentPane().add(authorLbl);
		
		msgLbl = new JLabel("");
		msgLbl.setBounds(250, 450, 300, 14);
		getContentPane().add(msgLbl);
		
		isbnchx.setBounds(10, 42, 20, 23);
		getContentPane().add(isbnchx);
		
		booktitlechx.setBounds(10, 76, 20, 23);
		getContentPane().add(booktitlechx);
		
		authorchx.setBounds(10, 117, 20, 23);
		getContentPane().add(authorchx);
		
		isbnTxt = new JTextField();
		bookTitleTxt = new JTextField();
		authorTxt = new JTextField();
		
		isbnTxt.setBounds(180, 45, 320, 20);
		isbnTxt.setFont(new Font("Garamond", Font.PLAIN,14));
		getContentPane().add(isbnTxt);
		isbnTxt.setColumns(10);
		
		bookTitleTxt.setBounds(180, 79, 320, 20);
		bookTitleTxt.setFont(new Font("Garamond", Font.PLAIN, 14));
		getContentPane().add(bookTitleTxt);
		bookTitleTxt.setColumns(10);
		
		authorTxt.setBounds(180, 120, 320, 20);
		authorTxt.setFont(new Font("Garamond", Font.PLAIN, 14));
		getContentPane().add(authorTxt);
		authorTxt.setColumns(10);
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		searchBtn.setBounds(180, 166, 127, 23);
		getContentPane().add(searchBtn);
		
		newuserBtn = new JButton("New User");
		newuserBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		newuserBtn.setBounds(575, 44, 127, 23);
		getContentPane().add(newuserBtn);
		
		checkoutBtn = new JButton("Check Out");
		checkoutBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		checkoutBtn.setBounds(375, 166, 127, 23);
		getContentPane().add(checkoutBtn);
		
		checkinBtn = new JButton("Check In");
		checkinBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		checkinBtn.setBounds(575, 166, 127, 23);
		getContentPane().add(checkinBtn);
		
		fineBtn = new JButton("Fines");
		fineBtn.setFont(new Font("Garamond", Font.PLAIN, 16));
		fineBtn.setBounds(575, 98, 127, 23);
		getContentPane().add(fineBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Garamond", Font.PLAIN,16));
		scrollPane.setBounds(20, 220, 725, 220);
		getContentPane().add(scrollPane);
		
		final JTable table = new JTable(row,column);
		table.setFont(new Font("Garamond", Font.PLAIN, 14));
		scrollPane.setFont(new Font("Garamond", Font.PLAIN,14));
		scrollPane.setViewportView(table);
		
		newuserBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				newuser.setVisible(true);
			}
		});
		searchBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				
				if(authorchx.getState() && isbnchx.getState())
				{
					msgLbl.setText("Checking by Author and ISBN..");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));
					name=authorTxt.getText();
					isbn = isbnTxt.getText();
					Search.nameAndIsbn();

				}
				else if(authorchx.getState() && booktitlechx.getState())
				{
					msgLbl.setText("Checking by Author and Title..");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));
					name=authorTxt.getText();
					titlebook = bookTitleTxt.getText();
					Search.nameAndTitle();		


				}
				else if(isbnchx.getState() && booktitlechx.getState())
				{
					msgLbl.setText("Checking by ISBN and Title..");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));
					isbn = isbnTxt.getText();
					titlebook = bookTitleTxt.getText();
					Search.isbnAndTitle();


				}
				else if(authorchx.getState())
				{
					msgLbl.setText("Checking by Author..");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));
					name=authorTxt.getText();
					Search.fullname();
				}
				else if(isbnchx.getState())
				{
					msgLbl.setText("Checking by ISBN..");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));
					isbn = isbnTxt.getText();
					Search.isbn();
				
				}
				else if(booktitlechx.getState())
				{
					msgLbl.setText("Checking by Title..");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));
					titlebook = bookTitleTxt.getText();
					Search.bookTitle();
		
					}
				else 
				{
					msgLbl.setText("Please enter either BOOK ID,TITLE OR AUTHOR NAME OR BOTH !");
					msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));

				}
				
				repaint();
			}

	});
		
	checkoutBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			
			System.out.println("Test");
			AbstractButton button=(AbstractButton)e.getSource();
			int row=0;
			
			if(e.getActionCommand().equals(button.getActionCommand()))
			{
				row=table.getSelectedRow();
				
			}
			
			int temp = (int) table.getValueAt(row, 0);
			CheckoutGUI.bookId=Integer.toString(temp);
			NoOfCopies=(Integer)table.getValueAt(row, 3);
			
			Search.checkedOut();
			int copies = (Integer)table.getValueAt(row, 3);
			if(copies <= 0)
			{
				msgLbl.setText("All available books have been Checked Out.");
				msgLbl.setFont(new Font("Garamond", Font.PLAIN,14));

			}
			
			else
			{
				indicate=1;
				msgLbl.setText(" ");
				dispose();
				checkout =new CheckoutGUI("Checkout");
				checkout.setVisible(true);
			}
		}
	});
	
	checkinBtn.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Test");
			AbstractButton button=(AbstractButton)e.getSource();
			int row=0;
			//int col=0;
			if(e.getActionCommand().equals(button.getActionCommand()))
			{
				row=table.getSelectedRow();
				//col=table.getSelectedColumn();
			}
			
			int temp = (int) table.getValueAt(row, 0);
			CheckinGUI.book_search=(String)Integer.toString(temp);

			indicate=1;
			msgLbl.setText(" ");
			dispose();
			checkin=new CheckinGUI("Checkin");
			checkin.setVisible(true);

		}
	});
	
	fineBtn.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			fine=new FineGUI("Fine");
			fine.setVisible(true);
		}
		});
	}
	
	public static void main(String[] args)
	{	try {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		frame=new SearchGUI("Search");
		frame.setVisible(true);
		newuser=new NewGUI("New User");
	}
}
