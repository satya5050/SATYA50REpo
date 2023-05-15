package company.satya.jdbc;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class RowSetProject_SelectTest {
public static void main(String[] args) {
	try(OracleJDBCRowSet jrowSet=new OracleJDBCRowSet()) {
		jrowSet.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		jrowSet.setUsername("SYSTEM");
		jrowSet.setPassword("ORACLE");
		jrowSet.setCommand("SELECT * FROM STUDENT");
		jrowSet.execute();
		while(jrowSet.next()) {
			System.out.println(jrowSet.getRow()+"  "+jrowSet.getString(1)+" "+jrowSet.getString(2)+" "+jrowSet.getString(3)+" "+jrowSet.getString(4));
		}
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
