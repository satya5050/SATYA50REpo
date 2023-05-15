package JDBCPractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Updatetest {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	try {
		sc=new Scanner(System.in);
		String sname=null;
		int sno=0;
		if(sc!=null) {
			System.out.println("ENTER STUDENT NAME WHICH YOU WANT TO UPDATE");
		 sname=sc.nextLine();
			System.out.println("ENTER STUDENT NO WHICH SNO YOU WANT TO UPDATE");
			 sno=sc.nextInt();
		  }
		sname="'"+sname+"'";
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
	st=con.createStatement();
	// UPDATE STUDENT SET SNAME='SATYA' WHERE SNO=123
	String query= "UPDATE STUDENT SET SNAME="+ sname+"WHERE SNO="+sno;
	System.out.println(query);
	int count=0;
	if(st!=null) {
		count=st.executeUpdate(query);
	}
	if(count==0) {
		System.out.println("NO RECORDS IS UPDATED");
	}
	else {
		System.out.println(count+"  RECORDS IS UPDATED  ");
	}
	}
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
