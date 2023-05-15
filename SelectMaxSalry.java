package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectMaxSalry{
	public static void main(String[] args) {
		Connection con=null;
	    Statement st=null;
	    ResultSet rs=null;
	    try {
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
	       if(con!=null)
	       st=con.createStatement();
	       //query prepare
	      // select empno,ename,job,sal from emp where ename like'A%';
	       String query= " SELECT ENAME,EMPNO,SAL,JOB FROM EMP WHERE SAL=(SELECT MAX(SAL)FROM EMP)";
	       System.out.println(query);
	       if(st!=null)
	       rs=st.executeQuery(query); 

	       if(rs!=null) {
	    	   boolean flag=false;
	       while(rs.next()) {
	    	   flag=true;
	    	   System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
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
	    
	    }//finally close
	}

}
