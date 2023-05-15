package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectAndNonSelectQuery {

	public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
		try {
			System.out.println("ENTER SELECT OR NON SELECT QUERY YOU WANT");
		sc=new Scanner(System.in);
		String query=sc.nextLine();
		//Load the JDBC class
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     //Connect to jdbc
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
	      //createstatement
	 st=con.createStatement();
	 if(st!=null) {
		 boolean flag=st.execute(query);
	
		if(flag==true) {
			System.out.println("SELECT SQL QUERY EXECUTED");
			System.out.println(query);
			rs=st.getResultSet();
		if(rs!=null) {
		while(rs.next()==true){
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
		}
	 }
	 }
	 else {
		 System.out.println("NON SELECT QUERY EXECUTED");
		 int count=st.getUpdateCount();
		 System.out.println("no. of records that are affected :"+count);
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