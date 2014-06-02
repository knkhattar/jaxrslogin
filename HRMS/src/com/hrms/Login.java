package com.hrms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
	 	 PrintWriter out = response.getWriter();
			String user=request.getParameter("userName");
			String pass=request.getParameter("password");
			request.setCharacterEncoding("utf8");       
	       response.setContentType("application/json");
	       JSONObject obj = new JSONObject();	     
	       try
	       {
	       	if(user.equals("test") && (pass.equals("test")))
	       	{        		
	       		obj.put("status", 1); 
	       		obj.put("empId", "test");
	       	}
	       	else
	       	{        	
	       		obj.put("status", "0");
	       	}
	       	
	       }
	       catch (JSONException e)
	       {
				e.printStackTrace();
			}
	       out.println(obj);
	       out.close();
	}
}