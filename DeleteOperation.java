package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOperation {

	public static void 	main(String[] args) {
	    Scanner sc=null;
		Connection con=null;
	    Statement st=null;
	   
	    try {
	    	sc=new Scanner(System.in);
	    	String city=null;
	    	if(sc!=null) {
	    	System.out.println("ENTER THE CITY NAME TO DELETE THE ADRESS: ");
	    	city=sc.next();
		      }
	    	 city ="'"+city+"'"; 
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","ORACLE");
	       if(con!=null)
	       st=con.createStatement();
	       //query prepare
	      //  DELETE FROM STUDENT WHERE SADD='DELHI'
	       String query= " delete from student where sadd="+city;
	     int count=0;
	       if(st!=null)
	     count=st.executeUpdate(query);
	     if(count ==0) {
	    	 System.out.println("NO RECORDS FOUND TO  DELETE");
	     }
	     else {
	    	 System.out.println("NO OF RECORDS THAT ARE EFFECTED IS: "+count);
	     }
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
