package JDBCPractice;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class Select_Artist_info {
	private final static String SELECT_QUERY=	" SELECT ARTIST_ID,NAME,ADRESS,PHOTOLOCATION FROM ARTIST_INFO WHERE ARTIST_ID=?";
public static void main(String[] args) {
    try(Scanner sc=new Scanner(System.in)){
    	int id=0;
    	if(sc!=null) {
    		System.out.println("ENTER PERSION ID: ");
    	id=sc.nextInt();
    	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE") ;
    			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);){
    			ps.setInt(1, id);
    				try(ResultSet rs=ps.executeQuery()){
    					if(rs!=null) {
                             while(rs.next()) {   	    
    				                 id=rs.getInt(1);
    				                 String name=rs.getString(2);
    				                 String address=rs.getString(3);
    				                 System.out.println(id+" "+name+" "+address);
    				                 InputStream is=rs.getBinaryStream(4);
                            	 OutputStream os=new FileOutputStream("retrive_image.jpg");
    		IOUtils.copy(is, os);
    		System.out.println("BLOB VALUES ARE RETRIVED AND STORED SUCCESFULLY");
    		}
    				}
    				}
    				
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


