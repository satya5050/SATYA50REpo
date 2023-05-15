package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
	int country=Integer.parseInt(req.getParameter("country"));
	String []capitals=new String []{"New delhi","Islamabad","WasingtonDC","Beijing"};
	String []countries=new String[] {"India","Pakistan","USA","China"};
	pw.println("<h1 style='color:blue;text-align:center'>Capital name of the Country "+countries[country]+" is:: "+capitals[country]+"</h1>");
pw.println("<a href='page.html'>Home</a>");
pw.close();
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
