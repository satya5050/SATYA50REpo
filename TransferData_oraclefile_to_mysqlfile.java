package JDBCPractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransferData_oraclefile_to_mysqlfile {
	private static final String MYSQL_INSERT_INTO_STUDENT="INSERT INTO STUDENT (SNO,SNAME,SADRESS,AVG)  VALUES(?,?,?,?)";
	private static final String ORACLE_SELECT_STATEMENT="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) throws Exception {
		Connection oraclecon=null, mysqlcon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		oraclecon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
			mysqlcon=DriverManager.getConnection("jdbc:mysql:///AdvJavaSatya","root","Rolex123");
			if(oraclecon!=null) {
				st=oraclecon.createStatement();
			}
				if( mysqlcon!=null) {
					ps=mysqlcon.prepareStatement(MYSQL_INSERT_INTO_STUDENT);
				}
					if(st!=null) {
						rs=st.executeQuery(ORACLE_SELECT_STATEMENT);
					}
					if(rs!=null && ps!=null) {
						while(rs.next()) {
				           int num = rs.getInt(1);
							String name=rs.getString(2);
							String add=rs.getString(3);
							float avg=rs.getFloat(4);
							
							ps.setInt(1, num);
							ps.setString(2, name);
							ps.setString(3, add);
							ps.setFloat(4, avg);
							ps.executeUpdate();
					
							
						}
						
						System.out.println("DATA COPY FROM ORACLE DB TO MYSQL DB SUCCESFULLY");
						oraclecon.close();
						mysqlcon.close();
					}
		
		
//		try {
//		}
//		
//		catch(SQLException se) {
//		
//				System.out.println("DATA IS NOT COPY FROM ORACLE DB TO MYSQL DB");
//			se.getStackTrace();
//		}
//		catch(Exception e) {
//			e.getStackTrace();
//		}
//		finally{
//			try {
//				if(ps!=null) {
//					ps.close();
//				}
//			}
//			catch(SQLException se) {
//				se.getStackTrace();
//			}
//			try {
//				if(st!=null) {
//					st.close();
//				}
//			}
//			catch(SQLException se) {
//				se.getStackTrace();
//			}
//			try {
//				if(mysqlcon!=null) {
//					mysqlcon.close();
//				}
//			}
//			catch(SQLException se) {
//				se.printStackTrace();
//			}
//			
//			try {
//				if(oraclecon!=null) {
//					oraclecon.close();
//				}
//			}
//			catch(SQLException se) {
//				se.printStackTrace();
//			}
//
//		}//finally close
	}



	}


