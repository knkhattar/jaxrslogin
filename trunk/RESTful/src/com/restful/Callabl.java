//This Program is used to authentication the user
package com.restful;

import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;



@Path("/callabl")
public class Callabl
{
@POST
public Response status(@FormParam("userName") String username, @FormParam("password") String pass)
{
Connection con;
CallableStatement ps;
int rs;
String status="";
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con = DriverManager.getConnection("jdbc:odbc:emp","system","admin");
ps = con.prepareCall("{call status(?,?)}");
ps.setString(1, username);
ps.setString(2, pass);
rs = ps.executeUpdate();
if(rs==1)
{
	System.out.println("Welcome to my First Restful Web Service");
	status = "Welcome to my First Restful Web Service";
}
else
{
	System.out.println("Invalid UserName or Password");
	status = "Invalid UserName or Password";
}
con.close();
}
catch(Exception e)
{
e.printStackTrace();
}
return Response.status(200).entity("" + status).build(); 
}
}