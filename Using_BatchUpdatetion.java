package company.satya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Using_BatchUpdatetion {
	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
				Statement st=con.createStatement()) {
			st.addBatch("INSERT INTO STUDENT VALUES(076061,'PAPU','DHAMNAGAR',57.0)");
			st.addBatch("DELETE FROM STUDENT WHERE SNO=135");
			st.addBatch("UPDATE STUDENT SET AVG=AVG+10 WHERE SNO>=1057");
			int []result=st.executeBatch();
			int sum=0;
			for(int i=0;i<result.length;i++) {
				sum=sum+i;
	
			}
			System.out.println("TOTAL NO.OF RECORDS  EFFECTED IS: "+sum);
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
