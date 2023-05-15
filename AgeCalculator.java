package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class AgeCalculator {
	private static final String AGE_CALCULATOR=" SELECT  ROUND((SYSDATE-DOB)/365.25,2) FROM PERSON_INFO_DATES WHERE PID=?";
	public static void main(String[] args) {
    Scanner sc=null;
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
  int pi=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				   System.out.println("ENTER PERSION ID: ");
				     pi=sc.nextInt();
			}
			//Load the Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection with oracle databse
			if(sc!=null) {
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
			}
			if(con!=null) {
			ps=con.prepareStatement(AGE_CALCULATOR);	
			}
	if(ps!=null) 
		ps.setInt(1, pi);
	if(ps!=null)
		rs=ps.executeQuery();
		if(rs!=null) {
		if(rs.next()){
			float  age=rs.getFloat(1);
			System.out.println("PERSON AGE IS: "+age);
		}
		else {
			System.out.println("PERSON NOT FOUND");
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

		}//finally close
	}

}
