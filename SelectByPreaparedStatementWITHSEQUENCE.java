package company.satya.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class SelectByPreaparedStatementWITHSEQUENCE {
	private static final String INSERT_QUERY="INSERT INTO BABULI VALUES(SNO_SEQ1.NEXTVAL,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
				System.out.println("ENTER HOW MANY RECORDS YOU HAVE TO STORE: ");
				count=sc.nextInt();sc.nextLine();
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
			if(con!=null)
				ps=con.prepareStatement(INSERT_QUERY);
			if(sc!=null&&ps!=null) {
				for(int i=1;i<=count;i++) {
					System.out.println("ENTER "+ i +" STUDENT DETAILS");
					System.out.println("ENTER STUDENT NAME: ");
					String sname=sc.nextLine();
					System.out.println("ENTER STUDENT ADRESS : ");
					String addrs=sc.nextLine();
					System.out.println("ENTER STUDENT AVERAGE: ");
					float avg=sc.nextFloat();sc.nextLine();
				ps.setString(1,sname);ps.setString(2, addrs);ps.setFloat(3, avg);
					int result=ps.executeUpdate();
					if(result==0) {
						System.out.println("STUDENT DETAILS ARE NOT INSERTED");
					}
					else {
						System.out.println("STUDENT DETAILS ARE INSERTED");
					}
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
