package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class JdbcSelect {
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			String initChar;
			if(sc!=null) {
				System.out.println("ENTER INITIAL CHARECTER OF EMPLOYEE NAME: ");
			}
			initChar=sc.next().toUpperCase();
			initChar ="'"+initChar+"%'"; 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
			if(con!=null)
				st=con.createStatement();
			//query prepare
			// select empno,ename,job,sal from emp where ename like'A%';
			String query= "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE ENAME LIKE"+initChar;
			if(st!=null)
				rs=st.executeQuery(query); 
			if(rs!=null) {
				boolean flag=false;
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}//while close
				if( flag==false) { 
					System.out.println("NO RECORDS FOUND");
				}
			}//if close
		}//try close
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
				if(st!=null) {
					st.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
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
