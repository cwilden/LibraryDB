package library;

import java.sql.*;
public class Checkout {

	public static int flag=0;
	static Connection conn = null;


	public static void check(){



		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			Statement stmt = conn.createStatement();

			stmt.execute("use library;");


			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS CHECKER FROM BOOK_LOANS WHERE Card_No LIKE '%" +CheckoutGUI.cardNum+"%';");


			while (rs.next()) {

				CheckoutGUI.noOfCopies=rs.getInt("CHECKER");
				System.out.println("No of Copies"+ CheckoutGUI.noOfCopies);
			} 
			
			ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) AS COPIES FROM BOOK_COPIES WHERE isbn LIKE '%"+CheckoutGUI.bookId+"%';");
			
			
			while(rs1.next())
			{
				CheckoutGUI.copiesAvailable=rs1.getInt("COPIES");
				System.out.println("No of Copies"+ CheckoutGUI.copiesAvailable);
			}

			conn.close();
//			System.out.println("Success!!");
		}
		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
		}
		flag = 0;
		if(CheckoutGUI.noOfCopies <3 && CheckoutGUI.copiesAvailable>0)
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");
				Statement stmt = conn.createStatement();


				stmt.execute("use library;");

				stmt.executeUpdate("INSERT INTO BOOK_LOANS (ISBN,CARD_NO,DATE_OUT, DUE_DATE) VALUES ("+CheckoutGUI.bookId+","+CheckoutGUI.cardNo+",CURDATE(), ADDDATE(CURDATE(),INTERVAL 14 DAY));");
				stmt.executeUpdate("INSERT INTO FINES (FINE_AMT,PAID) VALUES (0.00,FALSE);");
				
				ResultSet rs2=stmt.executeQuery("SELECT Copies_Avail FROM BOOK_Copies WHERE isbn LIKE '%"+CheckoutGUI.bookId+"%';");
				rs2.next();
				int copies=rs2.getInt("Copies_Avail")-1;
				stmt.executeUpdate("UPDATE BOOK_COPIES SET Copies_Avail ="+copies+" WHERE isbn LIKE '%"+CheckoutGUI.bookId+"%';");
				conn.close();
				flag=1;

			}

			catch(SQLException ex)
			{
//				System.out.println("Error:"+ex.getMessage());
			}
		}
	}



}
