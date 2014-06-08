package com.Google_Hello_World;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Google_Hello_WorldServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<html><body><center><h1 style=color:maroon>Hello Friends</h1></center>"+"\n"+"<h4 style=color:blue>Hi i m Dheeraj Kumar from Pune</h4>"+"\n"+"<h4 style=color:blue>"+"I m working in Techsignia"+"</h4>"+"\n"+"<h4 style=color:blue>"+"Techsignia is the CMM Level 5 Company"+"</h4>"+"\n\n\n"+"<br><br><center><h1 style=color:red>"+"This is My First Web Application on The Google Cloud"+"</h1></center>"+"</body></html>");
		//resp.getWriter().println("Hello, world!" + "\n" +"\n" + "Hi Friends I am Dheeraj Kumar From Pune" + "\n" +"\t" +"Now i m working in Techsignia. Techsignia is the CMM Level 5 Company" +"\n" +"\t" + "This is my firsy msg from Google Cloud");
		
		//resp.getWriter().println("<html><body><h1>Hi Friends i m Dheeraj Kumar</h1></body></html>");
	}
}
