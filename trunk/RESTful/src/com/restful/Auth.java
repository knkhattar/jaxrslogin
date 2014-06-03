//						This Program is used to authentication the user
package com.restful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;



@Path("/checkUser")
public class Auth
{
	@POST
	public Response checkUser(@FormParam("userName") String username, @FormParam("password") String pass)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		String status="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:emp","system","admin");
			ps = con.prepareStatement("select * from detail where username=? and password=?");
			ps.setString(1, username);
            ps.setString(2, pass);
			rs = ps.executeQuery();
			boolean found = rs.next();
			if(found)
			{
				System.out.println("Welcome to my First Restful Web Service");
				status = "Welcome to my First Restful Web Service";
			}
			else
			{
				System.out.println("Invalid UserName or Password");
				status = "Invalid UserName or Password";
			}
			rs.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(200).entity("" + status).build(); 
	}
}