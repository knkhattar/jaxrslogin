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
 * Servlet implementation class LeaveInfo
 */
@WebServlet("/LeaveInfo")
public class LeaveInfo extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			PrintWriter out = response.getWriter();
			String empId = request.getParameter("empId");
			
			request.setCharacterEncoding("utf8");
			response.setContentType("application/json");
			JSONObject obj = new JSONObject();
			
		
			try {
				if (empId.equals("test")) {
					
					JSONArray jsonArray = new JSONArray();

					for (int i =1; i<6; i++) {
					    JSONObject jsonObj= new JSONObject();
					    jsonObj.put("leaveType", "SL"+i);
					    jsonObj.put("leaveCount", i);
					    jsonArray.put(jsonObj.toString());
					}
					obj.put("leaves",jsonArray);
				} 

			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.println(obj);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
