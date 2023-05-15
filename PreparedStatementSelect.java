package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatementSelect {
	private static final String SELECT_QUERY= "SELECT COUNT(*) FROM IRCTC WHERE UNAME=? AND PWD=?";
public static void main(String[] args) {
Scanner sc=null;
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
try {
		sc=new Scanner(System.in);
		String username=null;
		int pwd=0;
		if(sc!=null) {
			System.out.println("ENTER USERNAME: ");
		 username=sc.next();
			System.out.println("ENTER PASSWORD: ");
			 pwd=sc.nextInt();
		}
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
ps=con.prepareStatement( SELECT_QUERY);
if(ps!=null) {
	ps.setString(1, username);
	ps.setInt(2, pwd);
}
	if(ps!=null) {
		rs=ps.executeQuery();
		}
	if(rs!=null) {
		rs.next();
		int count=rs.getInt(1);
	
if(count==0) {
System.out.println("IT IS A INVALID CEDENTIAL");
}
else{
	System.out.println("IT IS VALID CREDENTIAL");
}

	}

}
catch(SQLException se) {
	if(se.getErrorCode()>=900 && se.getErrorCode()<=999) {
		System.out.println("INVALID COLUMN NAME OR TABLE NAME");
	}
	se.getStackTrace();
}
catch(Exception e) {
	e.getStackTrace();
}
finally{
	try {
		if(rs!=null) {
			rs.close();
		}
	}
	catch(SQLException se) {
		se.getStackTrace();
	}
	try {
		if(con!=null) {
			con.close();
		}
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
	try {
		if(sc!=null) {
			sc.close();
		}
	}
	catch(Exception e ) {
		e.printStackTrace();
	}
}//finally close
}
}
