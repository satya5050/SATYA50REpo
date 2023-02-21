import java.sql.*;
class Selectfromdept {
	public static void main(String []args)throws Exception{
Class.forName("oracle.jdbc.driver.OracleDriver");	
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM DEPT");
while(rs.next()==true){
	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
}
	rs.close();
	st.close();
	con.close();
	}
}
