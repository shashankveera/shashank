
import java.sql.*;
import java.util.Scanner;
public class FunctionCallTest {
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
			System.out.println("Trying to make a Statement for DQL");
			CallableStatement cst = conn.prepareCall("{? = call myemp.calc_sal(?)}");
			System.out.println("CallableStatement made.....for PL-SQL");
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter emp number :");
			int eno = scan1.nextInt();
			
			cst.setInt(2, eno);
			cst.registerOutParameter(1, Types.DOUBLE);
			cst.execute();
			
			double salary = cst.getDouble(1);
			
			
			System.out.println("PLSQL Block executed...and retrieving the result....");
			System.out.println("SAL : "+salary);
			
			
			System.out.println("Trying to close CallableStatement,Connection....");
			cst.close();
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Some SQL problem : "+e);
		}
	}



}


