package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
String val=req.getParameter("p1");
Locale []locales=Locale.getAvailableLocales();
if(val.equalsIgnoreCase("link1")) {
	pw.println("<h1>::ALL LANGUAGES ARE::</h1>");
for(Locale l:locales)
	pw.println(l.getDisplayLanguage()+",");
}
else if(val.equalsIgnoreCase("link2")) {
	pw.println("<h1>::ALL COUNTRIES ARE::</h1>");
for(Locale l:locales)
pw.println(l.getDisplayCountry()+",");
}
else {
	pw.println("<h1 style='color:pink;text-align:center'>SYSTEM AND TIME :: "+LocalDateTime.now()+"</h1>");
}
pw.println("<br><a href='links.html'>HOME</a>");
pw.close();
		}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	doGet(req,res);
	}
}
