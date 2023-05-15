package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertintoStudentTable {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			sc=new Scanner (System.in);
			int sno=0;
			String sname=null;
			String sadd=null;
			float avg=0.0f;
			if(sc!=null) {
				System.out.println("ENTER STUDENT NO. : ");
				sno=sc.nextInt();sc.nextLine();
				System.out.println("ENTER STUDENT NAME: ");
				sname=sc.nextLine();
				System.out.println("ENTER STUDENT ADDRESS: ");
				sadd=sc.nextLine();
				System.out.println("ENTER STUDENT AVERAGE: ");
				avg=sc.nextFloat();
			}
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";
			//load jdbc driver by driverclass
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish the Connection
			if(sc!=null) {
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","ORACLE");
			}
			//CreateStatement
			if(con!=null) {
				st=con.createStatement();
			}
			//Preapare Query
			// INSERT INTO STUDENT VALUES(102,'DIPU','CTC',10.0);
			String query="INSERT INTO STUDENT VALUES("+sno+","+sname+","+sadd+","+avg+")";
			System.out.println(query);
			int count =0;
			if(st!=null) 
				count=st.executeUpdate(query);
		
			if(count==0) 
				System.out.println("RECORDS IS NOT INSERTED");
			else
				System.out.println("RECORD IS INSERTED");


		}//try close
		catch(SQLException se) {
			if(se.getErrorCode()==1)
				System.out.println("DUPLICATE CAN'T BE INSERTED TO PK COLUMN");
		
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
