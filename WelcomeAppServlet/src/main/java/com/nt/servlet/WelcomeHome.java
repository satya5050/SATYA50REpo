package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeHome extends HttpServlet {
@Override
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
    pw.println("<h1 style='color:red;text-align:center'>WELCOME TO SERVLET</h1>");
    pw.close();
}
}
