package com.hrms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class ApplyLeave
 */
@WebServlet("/ApplyLeave")
public class ApplyLeave extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	PrintWriter out = response.getWriter();
		String empId = request.getParameter("empId");
		String leaveType = request.getParameter("leaveType");
		String currentdate = request.getParameter("currentdate");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String comments = request.getParameter("comments");
		String mobileNumber = request.getParameter("mobileNumber");
		String leaveCount = request.getParameter("leaveCount");
		request.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        JSONObject obj = new JSONObject();
        try
        {
        	if(empId.equals("test"))
        	{
        		
        		obj.put("Status", 1);        	
        	}
        	else
        	{
        		obj.put("Status", 0);
        	}
        	        	
        }
        catch (JSONException e)
        {
			e.printStackTrace();
		}
        out.print(obj);
	}
}
