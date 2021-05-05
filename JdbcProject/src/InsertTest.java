import java.sql.*;
import java.util.Scanner;  

public class InsertTest {

	public static void main(String[] args) {
		try
		{
			System.out.println("Trying to load the driver....");
			DriverManager.deregisterDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver loaded....");
			
			System.out.println("Trying to connect to the database");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			System.out.println("Connected to the database");
			
		
			
			System.out.println("Trying to make a Preparedstatement for DML(insert)");    //3rd step : create statement of your choice select(DQL)/DML/PL-SQL(proce/funs)
            PreparedStatement pst = conn.prepareStatement("insert into dept values(?,?,?)"); // this is for DQL
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter dept number : ");
            int dno = scan.nextInt();
            System.out.println("Enter dept name : ");
            String dnm = scan.next();
            System.out.println("Enter dept location : ");
            String dloc = scan.next();
            
            pst.setInt(1,  dno);
            pst.setNString(2, dnm);
            pst.setNString(3, dloc);
            
            System.out.println("PrepareStatement made.....for DML");
            
            System.out.println("Trying to fire it... ");    
            int rows = pst.executeUpdate();
            
          
            
            System.out.println("Query fired...and rows inserted"+rows);
            
            System.out.println("Trying to close PrepareStatement,Connection...");
            pst.close();
            conn.close();
            System.out.println("PrepareStatement,Connection closed...");
            System.out.println("End main");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}

}
