package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiffresultSetObject {
	public static final String QUERY="SELECT  EMPNO,ENAME,JOB,SAL FROM EMP";
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
		PreparedStatement ps=con.prepareStatement(QUERY,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery(QUERY);){
    System.out.println("::::::: EMPLOYEE DETAILS TOP TO BUTTON::::::");		
    System.out.println();
	while(rs.next()) {
		System.out.println(rs.getRow()+"------>"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
	}
	System.out.println("---------------------------------------------------------------");
	System.out.println("::::::::EMPLOYE DETAILS BUTTOM TO TOP::::::::");
	System.out.println();
	rs.isAfterLast();
	while(rs.previous()) {
		System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
	}
	System.out.println("-----------------------------------------------------------------");
	rs.first();
	System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
	System.out.println("--------------------------------------------------------------");
	rs.last();
	System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
    System.out.println("-----------------------------------------------------------------");
    rs.absolute(3);
    System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
	System.out.println("----------------------------------------------------------------");
	 rs.absolute(-6);
	    System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
		System.out.println("----------------------------------------------------------------");
		rs.relative(3);
		System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			System.out.println("----------------------------------------------------------------");
	    rs.relative(-6);
	    System.out.println(rs.getRow()+"------->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
		System.out.println("----------------------------------------------------------------");
	}catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
