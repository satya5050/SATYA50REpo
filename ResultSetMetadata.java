package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ResultSetMetadata {
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
 Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM BABULI");
			){
		ResultSetMetaData rsmd=null;
		if(rs!=null) {
			rsmd=rs.getMetaData();
		}
		if(rsmd!=null) {
			int colcount=rsmd.getColumnCount();
		for(int i=1;i<=colcount;++i) {
			System.out.print(rsmd.getColumnName(i)+" ");
		}
		System.out.println();
		for(int i=1;i<=colcount;++i) {
			System.out.print(rsmd.getColumnTypeName(i)+" ");
		}
		System.out.println();
		while(rs.next()) {
		for(int i=1;i<=colcount;++i) {
			System.out.print(rs.getString(i)+" ");
		}
		System.out.println();
		}
		}
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
