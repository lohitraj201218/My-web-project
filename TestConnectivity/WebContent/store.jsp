<%@ page import="java.sql.*" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html14/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Storing</title>
</head>
<body>
<%
String name = request.getParameter("n1");

String description = request.getParameter("n2");

String src = request.getParameter("n3");

String price = request.getParameter("n4");

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","lohit","Ben10ultimate");
 	PreparedStatement ps = con.prepareStatement("insert into items(name,description,src,price) values(?,?,?,?)");
	ps.setString(1,name);
	ps.setString(2,description);
	ps.setString(3,src);
	ps.setString(4,price);
	int i = ps.executeUpdate();
	
	if(i > 0){
		out.println("Successfully stored");
	}else{
		System.out.println("Fail");
	}
}catch(Exception e){
	System.out.println(e);
}

%>
</body>
</html>