package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String s1val=req.getParameter("s1");
	int val1=0,val2=0;
	if(!s1val.equalsIgnoreCase("link1")&& !s1val.equalsIgnoreCase("link2")) {
	val1=Integer.parseInt(req.getParameter("t1"));
	val2=Integer.parseInt(req.getParameter("t2"));
	}
	if(s1val.equalsIgnoreCase("add")) 
		pw.println("<h1>SUM OF  "+val1+" AND "+val2+" IS :"+(val1+val2)+"</h1>");
	else if(s1val.equalsIgnoreCase("sub"))
		pw.println("<h1>SUBSTRACTION  OF  "+val1+" AND "+val2+" IS :"+(val1-val2)+"</h1>");
	else if(s1val.equalsIgnoreCase("mul"))
		pw.println("<h1>MULTIPLE OF  "+val1+" AND "+val2+" IS :"+(val1*val2)+"</h1>");
	else if(s1val.equalsIgnoreCase("div"))
		pw.println("<h1>DIVISION OF  "+val1+" AND "+val2+" IS :"+((float)val1/val2)+"</h1>");
	else if(s1val.equalsIgnoreCase("link1")) {
		pw.println("<h1>SYSTEM PROPORTIES ARE </h1>");
	pw.println("<b>" +System.getProperties()+"</b>");
	}
	else {
		pw.println("<h1>SYSTEM DATE AND TIMES ARE:</h1>");
		pw.println("<b>"+LocalDateTime.now()+"</b>");
	}
	pw.println("<a href='form.html'>HOME</a>");
		pw.close();
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
