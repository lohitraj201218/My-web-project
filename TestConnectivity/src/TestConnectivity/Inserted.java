package TestConnectivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inserted
 */
@WebServlet("/Inserted")
public class Inserted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserted() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rc</title>");  
          
            out.println("</head>");
            out.println("<body>");
		
            System.out.println("success");

		String name = request.getParameter("n1");

		String description = request.getParameter("n2");

		String src = request.getParameter("n3");

		String a = request.getParameter("n4");
		Integer price=Integer.parseInt(a);
		out.println(price);
		
		
		/*
		
		try {
			System.out.println("0");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lohit","Ben10ultimate");
			Statement statement = connection.createStatement();
			//int update = statement.executeUpdate("insert into items values('YU','fruit','juice.jpg',150)");
			
//test
			System.out.println("1");
			String sql="insert into ITEMS(NAME,DESCRIPTION,SRC,PRICE) values(?,?,?,?)";
			
			 PreparedStatement ps = connection.prepareStatement(sql);
			  
			 System.out.println("2");
			 System.out.println("successW1");

			 ps.setString(1,name);
			 ps.setString(2,description);
			 ps.setString(3,src);
			 System.out.println("success1");
			 ps.setInt(4, price);
			 ps.executeUpdate(); 
//test end
//			System.out.println(update+"Row Inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		*/
		//read code
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lohit","Ben10ultimate");
			Statement st = con.createStatement();
			String sql = "select * from items";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				out.print(rs.getString(1));
				
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		

		}catch(Exception e) {
			System.out.println(e);
		}
		
	
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
