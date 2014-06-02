package com.restful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/hello")
public class Hello {
private static final String api_version= "00.01.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle()
	{
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion()
	{
		return "<p>Version</p>" + api_version;
	}
	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabasStatus() throws Exception
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:emp","system","admin");
//			ps = con.prepareStatement("select * from emp");
//			System.out.println("Evrything is Correct");
//			rs = ps.executeQuery();
//			System.out.println("EMP_ID" + "\t" + "EMP_NAME" + "\t" + "EMP_DEPT");
//			while(rs.next())
//			{
//				String id = rs.getString("emp_id");
//				String name = rs.getString("emp_name");
//				String dept = rs.getString("emp_dept");
//				System.out.print(id + "\t" + name + "\t\t" + dept);
//				System.out.print("\n");
//			}
			ps = con.prepareStatement("select * from detail");
			System.out.println("Evrything is Correct");
			rs = ps.executeQuery();
			System.out.println("USERID" + "\t" + "USERNAME" + "\t" + "PASSWORD");
			while(rs.next())
			{
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String pass = rs.getString("password");
				System.out.print(userid + "\t" + username + "\t" + pass);
				System.out.print("\n");
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Database Status Display on the Console";
	}
}
