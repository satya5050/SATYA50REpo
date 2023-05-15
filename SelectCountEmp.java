package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCountEmp {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.nt.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///Advjavasatya","root","Rolex123");
			if(con!=null)
				st=con.createStatement();
			//query prepare
			// select empno,ename,job,sal from emp where ename like'A%';
			String query= "SELECT COUNT(*)FROM EMP";
			System.out.println(query);
			if(st!=null)
				rs=st.executeQuery(query); 

			if(rs!=null) {
				boolean flag=false;
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1));
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
