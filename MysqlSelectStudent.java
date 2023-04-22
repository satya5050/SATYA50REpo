import java.sql.*;
class MysqlSelectStudent{ 
	public static void main(String[] args) throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql:// localhost:3306/Advjavasatya","root","Rolex123");
	//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","oracle");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
	while(rs.next()==true){
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
	}
	rs.close();
	st.close();
	con.close();
	}
}
