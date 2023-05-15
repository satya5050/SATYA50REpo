package CallableStatementprojectPlSQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class AddtwonumberusingCallableStatment {
	public static final String QUERY= "{CALL FIRST_ADD(?,?,?)}";
public static void main(String[] args) {
	try(Scanner sc=new Scanner(System.in)){
		System.out.println("ENTER FIRST NUMBER:: ");
		int fno=sc.nextInt();
	    System.out.println("ENTER SECOND NUMBER:: ");
	    int sno=sc.nextInt();
	    try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
	    		CallableStatement cs=con.prepareCall(QUERY);	){
	    	cs.registerOutParameter(3, Types.INTEGER);
	    	cs.setInt(1, fno);
	    	cs.setInt(2, sno);
	    	cs.execute();
	    	if(cs!=null)
	    	if(cs!=null) {
	    		System.out.println("SUM OF  "+fno+ "  AND  "+sno+" IS= "+(cs.getInt(3)));
	    	}
	    	}
	}catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
