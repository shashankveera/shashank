import java.sql.*;
import java.util.Scanner;
public class UpdateTest {
		public static void main(String[] args) {
			try
			{
				//1st step : load the driver
				System.out.println("Trying to load the driver.......");
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				System.out.println("Driver loaded....");
			
				//2nd step : connect to the database 
				System.out.println("Trying to connect to the database");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:"+ "@localhost:1521:orcl", "system", "oracle");
				System.out.println("Connected to the database");
				
				//by default all DML statements are autocommited...in JDBC
				
				// if you want disable the autocommit of jdbc, then use below line
				conn.setAutoCommit(false); // now auto commit is off
				// DDL statement performs autocommit the data
				System.out.println("Trying to make a PreparedStatement for DML(update)");	//3rd step : create statement of your choice select(DQL)/DML/PL-SQL(proce/funs)
				PreparedStatement pst = conn.prepareStatement("update dept set dname=?, loc=? where deptno=?"); // this is for DML
				Scanner scan1 = new Scanner(System.in);
				Scanner scan2 = new Scanner(System.in);
				Scanner scan3 = new Scanner(System.in);
				Scanner scan4 = new Scanner(System.in);

				System.out.println("Enter NEW dept name     : "); String dnm = scan2.next(); //Coding <-ENTERKEY
				System.out.println("Enter NEW dept location : "); String dloc = scan3.nextLine(); //<-above ENTERKEY is carried here
				System.out.println("For   dept number       : "); int dno = scan1.nextInt(); //90
				pst.setString(1, dnm); pst.setString(2, dloc);
				pst.setInt(3, dno);
				System.out.println("PrepareStatement made....for DML update");
				System.out.println("Trying to fire it... ");	//4th step : fire the statement and acquire result if any
				int rows = pst.executeUpdate(); //fire the pst associated insert query
				System.out.println("Do you want to update this record (yes/no) ? ");
				String ans = scan4.nextLine();
				if(ans.equalsIgnoreCase("yes")) {		conn.commit();
					System.out.println("Rows updated..."+rows);
				}
				else if(ans.equalsIgnoreCase("no")) {	conn.rollback();
					System.out.println("Rows updation failed...."+rows);
				} 
				System.out.println("Trying to close PrepareStatement,Connection....");
				pst.close();  conn.close();  // close DB resources
				System.out.println("PrepareStatement,Connection closed....");
				System.out.println("End of main...");
			}
			catch(SQLException e) {
				System.out.println("Some SQL problem : "+e);
			}
		}
	


}
