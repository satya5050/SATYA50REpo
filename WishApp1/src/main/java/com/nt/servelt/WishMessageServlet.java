package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		LocalDateTime ldt= LocalDateTime.now();
	int hour =ldt.getHour();
	pw.println("<h1 style='color:blue;text-align:center'>"+ldt.toString()+"</h1>");
		if(hour<12) 
		pw.println("<h1 style='color:red;text-align:center'>Good Morning</h1>");
		else if(hour==12)
			pw.println("<h1 style='color:blue;text-align:center'>Good Noon</h1>");
		else if(hour<16)
		pw.println("<h1 style='color:pink;text-align:center'>Good AfterNoon</h1>");
		else if(hour<20)
			pw.println("<h1 style='color:red;text-align:center'>Good Evening</h1>");
		else if(hour<22)
			pw.println("<h1 style='color:blue;text-align:center'>Good Night</h1>");
		else
			pw.println("<h1 style='color:pink;text-align:center'>GO TO SLEEP</h1>");
		//add home hyperlink
		pw.println("<a href='page.html'>home</a>");
		pw.close();
	}
}
