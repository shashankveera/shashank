import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class EmployeeTest {
	public static void main(String[] args) {
		System.out.println("--------------------------");
		
List<Employee> empList = null;
		
		EmployeeDAOImpl ddiObj = new EmployeeDAOImpl();
		
		empList = ddiObj.findEmployees(); 

		Iterator<Employee> iter = empList.iterator();
		
		while(iter.hasNext()) {
			Employee empObj = iter.next();
			System.out.println("emp number   : "+empObj.getEmployeeNumber());
			System.out.println("emp name     : "+empObj.getEmployeeName());
			System.out.println("emp job     : "+empObj.getEmployeeJob());
			System.out.println("emp mgr     : "+empObj.getEmployeeMgr());
			System.out.println("emp hiredate     : "+empObj.getEmployeeHireDate());
			System.out.println("emp salary     : "+empObj.getEmployeeSalary());
			System.out.println("emp comm     : "+empObj.getEmployeeComm());
			System.out.println("dept number : "+empObj.getDepartmentNumber());
			System.out.println("--------------------");
		}
	}

}
class Employee  
{
	private int employeeNumber; 
	private String employeeName; 
	private String employeeJob;
	private int employeeMgr;
	private String employeeHireDate;
	private int employeeSalary;
	private int employeeComm;
	private int departmentNumber;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeJob() {
		return employeeJob;
	}
	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}
	public int getEmployeeMgr() {
		return employeeMgr;
	}
	public void setEmployeeMgr(int employeeMgr) {
		this.employeeMgr = employeeMgr;
	}
	public String getEmployeeHireDate() {
		return employeeHireDate;
	}
	public void setEmployeeHireDate(String employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeComm() {
		return employeeComm;
	}
	public void setEmployeeComm(int employeeComm) {
		this.employeeComm = employeeComm;
	}
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
}

interface EmployeeDAO 
{
	void addEmployee(Employee dRef);
	Employee findEmployee(int eno);		
	List<Employee> findEmployees();			
	void modifyEmployee(Employee dRef);		
	void removeEmployee(Employee dRef);     
	
}

class EmployeeDAOImpl implements EmployeeDAO
{
	Connection conn;
	ResultSet rs;
	Statement st;
	PreparedStatement pst;
	
	EmployeeDAOImpl() {
		try
		{
			
			System.out.println("Trying to load the driver.......");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver loaded....");
		
			 
			System.out.println("Trying to connect to the database");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:"+ "@localhost:1521:orcl", "system", "oracle");
			System.out.println("Connected to the database");
		}
		catch(Exception e) {
			System.out.println("Some Problem : "+e);
		}
	}
	
	public void addEmployee(Employee dRef) { 
		try {
			PreparedStatement pst = conn.prepareStatement("insert into emp values (?,?,?,?,?,?,?,?)"); 
			pst.setInt(1, dRef.getEmployeeNumber());	
			pst.setString(2, dRef.getEmployeeName()); 
			pst.setString(3, dRef.getEmployeeJob());
			pst.setInt(4, dRef.getEmployeeMgr());
			pst.setString(5, dRef.getEmployeeHireDate());
			pst.setInt(6, dRef.getEmployeeSalary());
			pst.setInt(7, dRef.getEmployeeComm());
			pst.setInt(8, dRef.getDepartmentNumber());	
			System.out.println("PrepareStatement made....for DML");
			
			System.out.println("Trying to fire it... ");
			int rows = pst.executeUpdate(); 
			System.out.println("Record inserted..."+rows);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public Employee findEmployee(int eno) {
		Employee empObj = null;
		
		try {
			st = conn.createStatement();
			System.out.println("Statment made .... ");
			
			rs = st.executeQuery("select * from emp where empno="+eno); 
			System.out.println("Query fired...and got the result....");
			System.out.println("Now processing the result.....");
			if(rs.next()) { 
				int a = rs.getInt(1); 	
				String b = rs.getString(2); 
				String c = rs.getString(3); 
				int d = rs.getInt(4); 
				String e = rs.getString(5); 
				int f = rs.getInt(6); 	
				int g = rs.getInt(7); 	
				int h = rs.getInt(8); 		
				
				empObj = new Employee(); 
				empObj.setEmployeeNumber(a);
				empObj.setEmployeeName(b);
				empObj.setEmployeeJob(c);
				empObj.setEmployeeMgr(d);
				empObj.setEmployeeHireDate(e);
				empObj.setEmployeeSalary(f);
				empObj.setEmployeeComm(g);
				empObj.setDepartmentNumber(h);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return empObj;
	}
	
	public 	List<Employee> findEmployees() {
		List<Employee> empList = new ArrayList<Employee>(); 
		
		try {
			Statement st = conn.createStatement();
			System.out.println("Statement made...");
			rs = st.executeQuery("select * from emp"); 
			System.out.println("Query fired...and got the result....");
			System.out.println("Now processing the result....."); 
			while(rs.next()) { 
				int a = rs.getInt(1); 	
				String b = rs.getString(2); 
				String c = rs.getString(3); 
				int d = rs.getInt(4); 
				String e = rs.getString(5); 
				int f = rs.getInt(6); 	
				int g = rs.getInt(7); 	
				int h = rs.getInt(8);
				
				Employee empObj = new Employee(); 
				empObj.setEmployeeNumber(a);
				empObj.setEmployeeName(b);
				empObj.setEmployeeJob(c);
				empObj.setEmployeeMgr(d);
				empObj.setEmployeeHireDate(e);
				empObj.setEmployeeSalary(f);
				empObj.setEmployeeComm(g);
				empObj.setDepartmentNumber(h);
				
				empList.add(empObj);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return empList;
	}
	
	public 	void modifyEmployee(Employee dRef) {
		try {
			System.out.println("Trying to make a PreparedStatement for DML(update)");
			PreparedStatement pst = conn.prepareStatement("update emp set ename=?, ejob=?, emgr=?, ehiredate=?, esalary=?, ecomm=?, deptno=? where empno=?"); // this is for DML
			pst.setInt(1, dRef.getEmployeeNumber());	
			pst.setString(2, dRef.getEmployeeName()); 
			pst.setString(3, dRef.getEmployeeJob());
			pst.setInt(4, dRef.getEmployeeMgr());
			pst.setString(5, dRef.getEmployeeHireDate());
			pst.setInt(6, dRef.getEmployeeSalary());
			pst.setInt(7, dRef.getEmployeeComm());
			pst.setInt(8, dRef.getDepartmentNumber());
			
			
			System.out.println("PrepareStatement made....for DML update");
			System.out.println("Trying to fire it... ");	
			int rows = pst.executeUpdate();
			System.out.println("Record updated : "+rows);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public 	void removeEmployee(Employee dRef) {
		try {
			System.out.println("Trying to make a PreparedStatement for DML(delete)");
			PreparedStatement pst = conn.prepareStatement("delete from emp where empno=?"); 
			pst.setInt(1, dRef.getEmployeeNumber()); 
		
			System.out.println("PrepareStatement made....for DML delete");
			System.out.println("Trying to fire it... ");	
			int rows = pst.executeUpdate();
			System.out.println("Record deleted..."+rows);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
