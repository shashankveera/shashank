import java.sql.*;
import java.util.Scanner;


public class ProcedureCallTest {

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
			System.out.println("Trying to make a CallableStatement");
			CallableStatement cst = conn.prepareCall("{ call EMP_INFO(?,?,?)}");
			System.out.println("CallableStatement made.....for PL-SQL");
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter emp number :");
			int eno = scan1.nextInt();
			
			cst.setInt(1,  eno);
			cst.registerOutParameter(2,  Types.VARCHAR);
			cst.registerOutParameter(3,  Types.VARCHAR);
			cst.execute();
			
			String ename = cst.getString(2);
			String ejob = cst.getString(3);
			
			System.out.println("PLSQL Block executed...and retrieving the result....");
			System.out.println("ENAME : "+ename);
			System.out.println("EJOB : "+ejob);
			
			System.out.println("Trying to close CallableStatement,Connection....");
			cst.close();
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Some SQL problem : "+e);
		}
	}



}


	


