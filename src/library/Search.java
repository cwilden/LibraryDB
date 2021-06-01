package library;
import java.sql.*;
public class Search {

	static Connection conn;
	public static int checkedOut;
	public static void isbn() {
		// TODO Auto-generated method stub
		try{
			/* Create a connection to the local MySQL server, with the "library" database selected. */

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");

			int i = 0;
			/* Execute a SQL query using SQL as a String object */
			/* 
			 * Only the columns listed in the query will be available in the ResultSet object
			 * Note: If 'AS' is used to alias column name, these will be the names in the ResultSet object
			 */
			ResultSet rs = stmt.executeQuery("SELECT * From BOOKS, Book_copies WHERE Books.isbn10 = book_copies.isbn AND Books.ISBN10 LIKE"+"'%"+SearchGUI.isbn+"%';");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {


				SearchGUI.row[i][0] = rs.getInt("ISBN10");
				SearchGUI.row[i][1] = rs.getString("Title");
				SearchGUI.row[i][2] = rs.getString("Author");
				SearchGUI.row[i][3] = rs.getInt("copies_avail");


				System.out.println();		
				i++;
			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}

	}
	
	public static void isbnAndTitle(){
		try{
			/* Create a connection to the local MySQL server, with the "library" database selected. */

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");

			int i = 0;
			/* Execute a SQL query using SQL as a String object */

			ResultSet rs = stmt.executeQuery("SELECT * From BOOKS, Book_copies WHERE Books.isbn10 = book_copies.isbn AND Books.ISBN10 LIKE"+"'%"+SearchGUI.isbn+"%'AND Books.Title LIKE"+"'%"+SearchGUI.titlebook+"%';");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {


				SearchGUI.row[i][0] = rs.getInt("ISBN10");
				SearchGUI.row[i][1] = rs.getString("Title");
				SearchGUI.row[i][2] = rs.getString("Author");
				SearchGUI.row[i][3] = rs.getInt("copies_avail");


				System.out.println();		
				i++;
			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}


	}
	public static void fullname() {
		// TODO Auto-generated method stub
		try{
			/* Create a connection to the local MySQL server, with the "company" database selected. */

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");

			int i = 0;
			/* Execute a SQL query using SQL as a String object */
			/* 
			 * Only the columns listed in the query will be available in the ResultSet object
			 * Note: If 'AS' is used to alias column name, these will be the names in the ResultSet object
			 */
			ResultSet rs = stmt.executeQuery("SELECT * From BOOKS, Book_copies WHERE Books.isbn10 = book_copies.isbn AND Books.Author LIKE"+"'%"+SearchGUI.name+"%';");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {

				SearchGUI.row[i][0] = rs.getInt("ISBN10");
				SearchGUI.row[i][1] = rs.getString("Title");
				SearchGUI.row[i][2] = rs.getString("Author");
				SearchGUI.row[i][3] = rs.getInt("copies_avail");

				System.out.println();		
				i++;
			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}

	}
	
	public static void nameAndTitle() {
		// TODO Auto-generated method stub
		try{
			/* Create a connection to the local MySQL server, with the "library" database selected. */

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");

			int i = 0;
			/* Execute a SQL query using SQL as a String object */
			/* 
			 * Only the columns listed in the query will be available in the ResultSet object
			 * Note: If 'AS' is used to alias column name, these will be the names in the ResultSet object
			 */
			ResultSet rs = stmt.executeQuery("SELECT * From BOOKS, Book_copies WHERE Books.isbn10 = book_copies.isbn AND Books.Title LIKE"+"'%"+SearchGUI.titlebook+"%'AND Books.Author LIKE"+"'%"+SearchGUI.name+"%';");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {


				SearchGUI.row[i][0] = rs.getInt("ISBN10");
				SearchGUI.row[i][1] = rs.getString("Title");
				SearchGUI.row[i][2] = rs.getString("Author");
				SearchGUI.row[i][3] = rs.getInt("copies_avail");


				System.out.println();		
				i++;
			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}

	}
	
	public static void nameAndIsbn(){

		try{
			/* Create a connection to the local MySQL server, with the "library" database selected. */
			//
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");

			int i = 0;
			/* Execute a SQL query using SQL as a String object */
			/* 
			 * Only the columns listed in the query will be available in the ResultSet object
			 * Note: If 'AS' is used to alias column name, these will be the names in the ResultSet object
			 */
			ResultSet rs = stmt.executeQuery("SELECT * From BOOKS, Book_copies WHERE Books.isbn10 = book_copies.isbn AND Books.ISBN10 LIKE"+"'%"+SearchGUI.isbn+"%'AND Books.Author LIKE"+"'%"+SearchGUI.name+"%';");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {

				// Populate field variables

				SearchGUI.row[i][0] = rs.getInt("ISBN10");
				SearchGUI.row[i][1] = rs.getString("Title");
				SearchGUI.row[i][2] = rs.getString("Author");
				SearchGUI.row[i][3] = rs.getInt("copies_avail");

				System.out.println();		
				i++;
			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}
	}

	
	public static void bookTitle() {
		// TODO Auto-generated method stub
		try{
			/* Create a connection to the local MySQL server, with the "library" database selected. */

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");

			int i = 0;
			/* Execute a SQL query using SQL as a String object */
			/* 
			 * Only the columns listed in the query will be available in the ResultSet object
			 * Note: If 'AS' is used to alias column name, these will be the names in the ResultSet object
			 */
			ResultSet rs = stmt.executeQuery("SELECT * From BOOKS, Book_copies WHERE Books.isbn10 = book_copies.isbn AND Books.Title LIKE"+"'%"+SearchGUI.titlebook+"%';");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {

				SearchGUI.row[i][0] = rs.getInt("ISBN10");
				SearchGUI.row[i][1] = rs.getString("Title");
				SearchGUI.row[i][2] = rs.getString("Author");
				SearchGUI.row[i][3] = rs.getInt("copies_avail");



				System.out.println();		
				i++;
			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}
	}

	public static void checkedOut(){
		try{
			/* Create a connection to the local MySQL server, with the "company" database selected. */

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			/* Create a SQL statement object and execute the query. */
			Statement stmt = conn.createStatement();

			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
			stmt.execute("USE library;");


			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS CHECKED FROM BOOK_LOANS WHERE Book_loans.isbn LIKE '%"+SearchGUI.BookID+"%') AND Date_in IS NULL;");


			/* Iterate through the result set using ResultSet class's next() method */
			while (rs.next()) {

				checkedOut = rs.getInt("CHECKED");

			}

			rs.close();
			conn.close();
//			System.out.println("Success!!");
		} 
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}
	}
}




