package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpadateOperation {

	public static void 	main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try {
			sc=new Scanner(System.in);
			String newname=null;
			String newadd=null;
			float newavg=0.0f;
			int sno=0;
			if(sc!=null) {
				System.out.println("ENTER THE NEW NAME FOR STUDENT: ");
				newname=sc.nextLine();
				System.out.println("ENTER THE NEW ADDRESS FOR STUDENT");
				newadd=sc.nextLine();
				System.out.println("ENTER THE NEW AVERAGE FOR STUDENT");
				newavg=sc.nextFloat();
				System.out.println("ENTER THE STUDENT NO. WHERE  U WANT TO UPDATE THE RECORD:  ");
				sno=sc.nextInt();
			}
			newname="'"+newname+"'";
			newadd="'"+newadd+"'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
			if(con!=null)
				st=con.createStatement();
			//query prepare
			//  UPDATE STUDENT SET SNAME='SATYA',SADD='HYD',AVG=95.05 WHERE SNO=103
			String query= " UPDATE STUDENT SET SNAME="+newname+","+"SADD="+newadd+","+"AVG="+newavg+"WHERE SNO="+sno;
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			if(count ==0) {
				System.out.println("NO RECORDS FOUND TO  DELETE");
			}
			else {
				System.out.println("NO. OF RECORDS THAT ARE EFFECTED IS: "+count);
			}
		}//try close
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999) {
				System.out.println("INVALID COLUMN NAME OR TABLE NAME");
			}
			else if(se.getErrorCode()==(12899)){
				System.out.println("DON'T INSERT MORE THAN COLUMNS SIZE DATA INTO SNAME,SADD");
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
