package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUsingDdl {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
	try {
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
		st=con.createStatement();
		// CREATE TABLE STUDENT_REG (SNAME VARCHAR2(10),PWD INT)
		String query=" CREATE TABLE STUDENT_REG (SNAME VARCHAR2(10),PWD INT)";
		int count=0;
		if(st!=null) {
		count=st.executeUpdate(query);
		
		}
		if(count==0) {
			System.out.println("TABLE IS CREATED");
		}
		else {
			System.out.println("TABLE IS NOT CREATED");
		}
	}
	   catch(SQLException se) {
	    	se.getStackTrace();
	    }
	    catch(Exception e) {
	    	e.getStackTrace();
	    }
	    finally{
	    
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
	    	
	    }//finally close
	}

}
