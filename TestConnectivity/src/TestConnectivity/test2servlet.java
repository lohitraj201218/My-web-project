package TestConnectivity;

import oracle.jdbc.OracleDriver;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test2servlet
 */
@WebServlet("/test2servlet")
public class test2servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test2servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
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
		out.println("success");

String name = request.getParameter("n1");

String description = request.getParameter("n2");

String src = request.getParameter("n3");

String price = request.getParameter("n4");
Integer a=Integer.parseInt(price);
out.println(price);
                  // File f=new File("C:\\Users\\PERSONAL\\Pictures\\Screenshots\\Screenshot (55).png");
                  
           // String pass=request.getParameter("upass");
        
//String DRIVER="oracle.jdbc.OracleDriver";  
String CONNECTION_URL="jdbc:oracle:thin:@localhost:1521:XE";  
String USERNAME="lohit";  
String PASSWORD="Ben10ultimate";  
try{  
    out.println("success");
    //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
    
    //Class.forName("oracle.jdbc.driver.­OracleDriver");
    
	//Connection con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
   DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lohit","Ben10ultimate");
  out.println("success");
}catch(Exception e) {
	System.out.println(e);
}
  String sql="insert into ITEMS(NAME,DESCRIPTION,SRC,PRICE) values(?,?,?,?)";
  try(Connection con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD); ) {
  PreparedStatement ps = con.prepareStatement(sql);
  

out.println("successW1");

ps.setString(1,"qwerty");
ps.setString(2,"asdfgh");
ps.setString(3,"asdfgh");
out.println("success1");
ps.setInt(4, 123);
ps.executeUpdate(); 
out.println("success2");

}catch(Exception e){
	System.out.println(e);
}  
            
  
             
        
		   out.println("</body>");
           out.println("</html>");}

		
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
