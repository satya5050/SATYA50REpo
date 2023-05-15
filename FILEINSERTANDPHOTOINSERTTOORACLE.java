package JDBCPractice;

	import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

	public class FILEINSERTANDPHOTOINSERTTOORACLE {
		private final static String INSERTQUERY="INSERT INTO JOBSEEKER VALUES(?,?,?,?,?)";
		public static void main(String[] args) {   
			try (Scanner sc=new Scanner (System.in)){
				int pid=0;String name=null,adress=null,photolocation=null,resumelocation=null;
				if(sc!=null) {
				System.out.println("ENTER PERSON ID: ");
				 pid=sc.nextInt();sc.nextLine();
				System.out.println("ENTER PERSON NAME: ");
				name=sc.nextLine();
				System.out.println("ENTER PERSON ADDRESS: ");
			   adress=sc.nextLine();
			   System.out.println("ENTER PHOTO LOCATION: ");
			   photolocation=sc.nextLine();
			   System.out.println("ENTER RESUME LOCATION: ");
			   resumelocation=sc.nextLine();
				}
			   try(InputStream is=new FileInputStream(photolocation);
					   Reader reader=new FileReader(resumelocation)){
			  try( Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
				PreparedStatement ps=con.prepareStatement(INSERTQUERY);){
				  if(ps!=null) {
					  ps.setInt(1, pid);
					  ps.setString(2, name);
				      ps.setString(3, adress);
				      ps.setBinaryStream(4, is);
				      ps.setCharacterStream(5, reader);
				  }
				  int count =0;
				  if(ps!=null)
				  count=ps.executeUpdate();
				  if(count==0)
					  System.out.println("RECORD NOT INSERTED");
				  else 
					  System.out.println("RECORD IS INSERTED");
				  
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


