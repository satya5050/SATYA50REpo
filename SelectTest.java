package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
		if(con!=null) {
			st=con.createStatement();
			//preapare the query
			// select empno,ename,sal,job from emp
			String query=" select empno,ename,sal,job from emp";
			System.out.println(query);
			if(st!=null) {
				rs=st.executeQuery(query);
				}
			if(rs!=null) {
				boolean flag=false;
				while(rs.next()==true) {
					flag=true;
					System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
				}
				if(flag==false) {
					System.out.println("NO RECORDS FOUND ");
				}
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

	}//finally close
}
}
