package TestConnectivity;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author PERSONAL
 */
public class testServlet
        extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rc</title>");  
          
            out.println("</head>");
            out.println("<body>");
           out.println("<h1>Servlet rc at " + request.getContextPath() + "</h1>");
            
          

String name = request.getParameter("n1");

String description = request.getParameter("n2");

String src = request.getParameter("n3");

String price = request.getParameter("n4");
out.println(price);
                  // File f=new File("C:\\Users\\PERSONAL\\Pictures\\Screenshots\\Screenshot (55).png");
                  
           // String pass=request.getParameter("upass");
        
try{  
    out.println("success");
    String DRIVER="oracle.jdbc.driver.OracleDriver";  
String CONNECTION_URL="jdbc:oracle:thin:@localhost:1521:XE";  
String USERNAME="lohit";  
String PASSWORD="Ben10ultimate";  
Class.forName(DRIVER);  
	Connection con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
 
  out.println("success");
PreparedStatement ps=con.prepareStatement("insert into items values(?,?,?,?)");  
ps.setString(1,name);
ps.setString(2,description);
ps.setString(3,src);
ps.setString(4,price);
ps.executeUpdate(); 

}catch(Exception e){}  
            
              out.println("<center>");
              out.println("  <h1>\n" +
"            Registration failed!</h1>\n" +
"        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        /* out.println("<form action=\"http://localhost:8080/Hotel_Ordering/2097_pop/Home.html\">&nbsp;\n" +
"         <div class=\"form-group\">\n" +
"                    <h1>   <button type=\"submit\" class=\"btn btn-primary tm-btn-submit\">Home</button></h1>\n" +
"                      </div>\n" +
"        </form>");*/
            
            out.println("</center>");
             
        
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
