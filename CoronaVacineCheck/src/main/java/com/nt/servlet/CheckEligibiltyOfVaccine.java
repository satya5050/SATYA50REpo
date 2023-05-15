package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckEligibiltyOfVaccine extends HttpServlet {	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws  ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("pname").toUpperCase();
		String address=req.getParameter("padd");
		int age=Integer.parseInt(req.getParameter("page"));
		if(age<18)
			pw.println("<h1 style='color:red;text-align:center'>MR./MISS. "+name+" YOU ARE NOT ELIGIBLE TO VACCINATION</h1>");
		else
			pw.println("<h1 style='color:blue;text-align:center'>MR./MISS. "+name+" YOU ARE ELIGIBLE FOR VACCINATION</h1>");


		pw.println("<a href='vacinecheckpage.html'><img src='images/WhatsApp Image 2022-12-25 at 10.28.53 PM.jpeg' width='300' height='200'></a>");
		pw.close();
	}
}
