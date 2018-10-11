package TestConnectivity;
import java.sql.*;
public class writing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lohit","Ben10ultimate");
			Statement statement = connection.createStatement();
			//int update = statement.executeUpdate("insert into items values('YU','fruit','juice.jpg',150)");
			
//test
			String sql="insert into ITEMS(NAME,DESCRIPTION,SRC,PRICE) values(?,?,?,?)";
			
			 PreparedStatement ps = connection.prepareStatement(sql);
			  

			 System.out.println("successW1");

			 ps.setString(1,"qwty");
			 ps.setString(2,"asdfgh");
			 ps.setString(3,"asdfgh");
			 System.out.println("success1");
			 ps.setInt(4, 123);
			 ps.executeUpdate(); 
//test end
//			System.out.println(update+"Row Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
