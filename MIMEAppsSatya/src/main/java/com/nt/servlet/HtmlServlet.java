								package com.nt.servlet;
								import javax.servlet.*;
								import javax.servlet.http.*;
								import java.io.*;
								public class HtmlServlet extends HttpServlet{
								protected void service(HttpServletRequest req,HttpServletResponse  res)throws ServletException,IOException{
									res.setContentType("text/html");
								 PrintWriter pw=res.getWriter();
								 pw.println("<table border='1',align'='center'>");
                                   pw.println("<tr><th>player name</th><th>medal</th><th>category</th></tr>");
								   pw.println("<tr><td>niraj chopra</td><td>gold</td><td>javelin throw</td></tr>");
								      pw.println("<tr><td>satyaranjan pallai</td><td>diamond</td><td>developer</td></tr>");
									     pw.println("<tr><td>soumyranja pallai</td><td>bronch</td><td>card</td></tr>");
										 pw.close();
								}
								}