package com.nit.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckEligibility extends HttpServlet {
@Override
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String name=req.getParameter("pname").toUpperCase();
	String gender=req.getParameter("pgen");
	int age=Integer.parseInt(req.getParameter("page"));
	if(age<18)
		pw.println("<h1 style='color:red;text-align:center'>MR./MISS. "+name+" YOU ARE NOT ELIGIBLE TO MARRAIGE</h1>");
	else
		pw.println("<h1 style='color:blue;text-align:center'>MR./MISS. "+name+" YOU ARE ELIGIBLE FOR MARRAIGE</h1>");


	pw.println("<a href='marraige.html'><img src='images/marraige.png' width='1000' height='400'></a>");
pw.close();
}

}

