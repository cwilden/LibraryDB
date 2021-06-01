package library;

import java.sql.*;

public class New {

	static Connection conn = null;
	public static Object data[][]=new Object[1000][1000];
	public static int cardNo;
	public static String cardResult;

	public static void select(){
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			Statement stmt = conn.createStatement();

			stmt.execute("use library;");

			int i=0;
			ResultSet rs = stmt.executeQuery("SELECT ssn, first_name, last_name, address FROM BORROWERS WHERE ssn='"+ NewGUI.ssn+"' AND first_name LIKE '%"+NewGUI.fname+"%' AND last_name LIKE '%"+NewGUI.lname+"%' AND Address LIKE '%"+ NewGUI.address+"%';");

			while (rs.next()) {

				data[i][0]=rs.getString("ssn");
				data[i][1]=rs.getString("first_name");
				data[i][2]=rs.getString("last_name");
				data[i][3]=rs.getString("Address");

				i++;
			} 

			rs.close();
			conn.close();

			if(i>0)
			{
				NewGUI.rem=1;
			}
			else NewGUI.rem=0;

//			System.out.println("Success");
		}
		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
		}
	}

	public static void create()
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "java", "password");

			Statement stmt = conn.createStatement();

			stmt.execute("use library;");

			ResultSet rs = stmt.executeQuery("SELECT MAX(borrower_id) as Card_no FROM BORROWERS;");
			rs.next();

			String cardString=rs.getString("Card_no");
			String cardID = cardString.substring(0, 2);
			cardNo=Integer.parseInt(cardString.substring(2));
			//next borrwer id available
			cardNo++;
			cardResult=cardID.concat(Integer.toString(cardNo));

			stmt.executeUpdate("INSERT INTO BORROWERS(borrower_id,ssn,first_name,last_name,address,phone) VALUES" + "('" +cardResult+"','"+ NewGUI.ssn+"','"+NewGUI.fname + "','"+NewGUI.lname+"','"+NewGUI.address+"','"+NewGUI.phone+"');");

			conn.close();
			//System.out.println("Success");

		}
		catch(SQLException ex)
		{
			//		System.out.println("Error in connection: " + ex.getMessage());
		}
	}
}