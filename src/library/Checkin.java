package library;
import java.sql.*;

public class Checkin {

	static Connection conn = null;
	public static String book_id;
	public static String Card_no;
	static public void update()
	{

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			stmt.executeUpdate("UPDATE book_loans SET date_in=CURDATE() WHERE isbn LIKE '%"+CheckinGUI.bookID+"%' AND Card_no LIKE '%"+CheckinGUI.cardNo+"%';");
			stmt.executeUpdate("UPDATE book_copies SET copies_avail = copies_avail + 1 where isbn LIKE '%"+CheckinGUI.bookID+"%'");
			CheckoutGUI.noOfCopies--;		

			conn.close();
//			System.out.println("Success for updating book_loans (CHECKIN)!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}

	static public void borrower()
	{

		int i = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT * FROM BOOK_LOANS WHERE BOOK_LOANS.card_no LIKE '%"+CheckinGUI.cardNo+"%';"; 
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {


				CheckinGUI.row[i][0] = rs.getString("Loan_id");
				CheckinGUI.row[i][1] = rs.getString("Isbn");
				CheckinGUI.row[i][2] = rs.getString("Card_no");
				CheckinGUI.row[i][3] = rs.getDate("Date_out");
				CheckinGUI.row[i][4] = rs.getDate("Due_date");
				CheckinGUI.row[i][5] = rs.getDate("Date_in");

				i++;
			}


			rs.close();
			conn.close();
//			System.out.println("Success for looking checkin.borrower()!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}

	static public void bookID()
	{

		int i = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT * FROM BOOK_LOANS WHERE BOOK_LOANS.ISBN LIKE '%"+CheckinGUI.bookID+"%' ;";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				CheckinGUI.row[i][0] = rs.getString("Loan_id");
				CheckinGUI.row[i][1] = rs.getString("Isbn");
				CheckinGUI.row[i][2] = rs.getString("Card_no");
				CheckinGUI.row[i][3] = rs.getDate("Date_out");
				CheckinGUI.row[i][4] = rs.getDate("Due_date");
				CheckinGUI.row[i][5] = rs.getDate("Date_in");


				i++;
			}


			rs.close();
			conn.close();
//			System.out.println("Success in looking for checkin.bookiD()!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}
	static public void bookBorrower()
	{

		int i = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT * FROM BOOK_LOANS WHERE BOOK_LOANS.ISBN LIKE '%"+CheckinGUI.bookID+"%' AND Book_Loans.card_no LIKE '%"+CheckinGUI.cardNo+"%' ;";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				CheckinGUI.row[i][0] = rs.getString("Loan_id");
				CheckinGUI.row[i][1] = rs.getString("Isbn");
				CheckinGUI.row[i][2] = rs.getString("Card_no");
				CheckinGUI.row[i][3] = rs.getDate("Date_out");
				CheckinGUI.row[i][4] = rs.getDate("Due_date");
				CheckinGUI.row[i][5] = rs.getDate("Date_in");

				i++;
			} 


			rs.close();
			conn.close();
//			System.out.println("Success for looking in checkin.bookborrower()!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}

	static public void bookCard()
	{
		int i = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT * FROM BOOK_LOANS WHERE BOOK_LOANS.ISBN LIKE '%"+CheckinGUI.bookID+"%' AND Book_Loans.card_no LIKE '%"+CheckinGUI.cardNo+"%' ;";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {


				CheckinGUI.row[i][0] = rs.getString("Loan_id");
				CheckinGUI.row[i][1] = rs.getString("Isbn");
				CheckinGUI.row[i][2] = rs.getString("Card_no");
				CheckinGUI.row[i][3] = rs.getDate("Date_out");
				CheckinGUI.row[i][4] = rs.getDate("Due_date");
				CheckinGUI.row[i][5] = rs.getDate("Date_in");

				i++;
			}


			rs.close();
			conn.close();
//			System.out.println("Success for looking in checkin.bookcard()!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}

	static public void bookCardName()
	{
		int i = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT * FROM BOOK_LOANS WHERE BOOK_LOANS.ISBN LIKE '%"+CheckinGUI.bookID+"%' AND Book_Loans.card_no LIKE '%"+CheckinGUI.cardNo+"%' ;";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {


				CheckinGUI.row[i][0] = rs.getString("Loan_id");
				CheckinGUI.row[i][1] = rs.getString("Isbn");
				CheckinGUI.row[i][2] = rs.getString("Card_no");
				CheckinGUI.row[i][3] = rs.getDate("Date_out");
				CheckinGUI.row[i][4] = rs.getDate("Due_date");
				CheckinGUI.row[i][5] = rs.getDate("Date_in");


				i++;
			}


			rs.close();
			conn.close();
//			System.out.println("Success for looking in checkin.bookcardname()!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}



	static public void cardNo()
	{
		int i = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
			Statement stmt = conn.createStatement();
			stmt.execute("use LIBRARY;");
			String query = "SELECT * FROM BOOK_LOANS WHERE BOOK_LOANS.CARD_NO LIKE '%"+CheckinGUI.cardNo+"%' ;";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {


				CheckinGUI.row[i][0] = rs.getString("Loan_id");
				CheckinGUI.row[i][1] = rs.getString("Isbn");
				CheckinGUI.row[i][2] = rs.getString("Card_no");
				CheckinGUI.row[i][3] = rs.getDate("Date_out");
				CheckinGUI.row[i][4] = rs.getDate("Due_date");
				CheckinGUI.row[i][5] = rs.getDate("Date_in");


				i++;
			} 


			rs.close();
			conn.close();
//			System.out.println("Success for looking in checkin.cardNo()!!");

		}

		catch(SQLException ex) 
		{
//			System.out.println("Error in connection: " + ex.getMessage());
		}

	}
}
