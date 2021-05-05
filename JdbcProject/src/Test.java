import java.sql.*;  

public class Test {

	public static void main(String[] args) {
		try
		{
			System.out.println("Trying to load the driver....");
			DriverManager.deregisterDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver loaded....");
			
			System.out.println("Trying to connect to the database");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			System.out.println("Connected to the database");
			
			System.out.println("Trying to make a statement for DQL");    //3rd step : create statement of your choice select(DQL)/DML/PL-SQL(proce/funs)
            Statement st = conn.createStatement(); // this is for DQL
            System.out.println("Statement made....for DQL");
            System.out.println("Trying to write a query and fire it... ");    //4th step : fire the statement and acquire result if any
            ResultSet rs = st.executeQuery("select * from emp"); // type the query here
            System.out.println("Query fired...and got the result....");
            System.out.println("Now processing the result....."); //5th step : process the result
            while(rs.next()) { // process the result set like a cursor program
                int empno = rs.getInt(1);    
                String ename = rs.getString(2); 
                String job = rs.getString(3); 
                  
                System.out.println("EMPNO : "+empno);
                System.out.println("ENAME  : "+ename);
                System.out.println("JOB    : "+job);
                System.out.println("---------------------------");
                
                conn.close();
            }
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}

}
