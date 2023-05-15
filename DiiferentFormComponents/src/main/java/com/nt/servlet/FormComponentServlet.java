package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Formurl")
public class FormComponentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("pname"); 
		int age=Integer.parseInt(req.getParameter("page") );
		String address=req.getParameter("padd");
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		ms=(ms==null)?"single":"ms";
		String ply=req.getParameter("qlfy");
		String []lang=req.getParameterValues("languages");
		if(lang==null)
			lang=new String [] {"no language is selected"};
		String []hob=req.getParameterValues("hb");
		if(hob==null)
			hob=new String [] {"no hobbies is selected"};
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String mob=req.getParameter("mob");
		String wnb=req.getParameter("wnb");
		int fn=Integer.parseInt(req.getParameter("favNumber"));
		long m=Long.parseLong(req.getParameter("mobilenumber"));
		String email=req.getParameter("mail");
		String fc=req.getParameter("color");
		String url=req.getParameter("fburl");
		String fgs=req.getParameter("favsearch");
		int income=Integer.parseInt(req.getParameter("income"));
		String submit=req.getParameter("PROCESS DETAILS");
		String reset=req.getParameter("CANCEL");
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Baby boy</h1>");
			else if(age<13)
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Small boy</h1>");
			else if(age<19){
				if(ms.equalsIgnoreCase("marraid"))	
					pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Teenage Marraied Boy</h1>");				
					pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Teenage boy</h1>");
		}
			else if(age<35) {
				if(ms.equalsIgnoreCase("marraid"))	
					pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Young Marraied Boy</h1>");				
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Young  boy</h1>");
			}
				else if(age<50) {
					if(ms.equalsIgnoreCase("marraid"))	
						pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a middle aged Marraied Boy</h1>");				
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a middle aged  man </h1>");
				}
				else {
					if(ms.equalsIgnoreCase("marraid"))	
						pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a  Marraied Budda</h1>");				
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Budda </h1>");
		}
			
		}
		
		System.out.println();
		if(gender.equalsIgnoreCase("F")) {
			if(age<5)
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Baby Girl</h1>");
			else if(age<13)
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Small Girl</h1>");
			else if(age<19) {
			if(ms.equalsIgnoreCase("marraid"))	
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Teenage Marraied Girl</h1>");				
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Teenage Girl</h1>");
			}
			else if(age<35) {
				if(ms.equalsIgnoreCase("marraid"))	
					pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Young Marraied Girl</h1>");			
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Young  girl</h1>");
			}
				else if(age<50) {
				if(ms.equalsIgnoreCase("marraid")) 	
					pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a Middle aged Marraied Girl</h1>");			
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+" You are a middle aged Women </h1>");
				}
				else {
					if(ms.equalsIgnoreCase("marraid"))	
						pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a  Marraied  Buddi</h1>");					
				pw.println("<h1 style='color:red;text-align:center'>Master"+name+"You are a Buddi</h1>");
		}
		}
		pw.println("<br><br><b>Fromg Data::</b><br>");
		pw.println("<br>name:: <br>"+name);
		pw.println("<br>age :: <br>"+age);
		pw.println("<br>addess:: <br>"+address);
		pw.println("<br>gender:: <br>"+gender);	
		pw.println("<br>maritial status:: <br>"+ms);
		pw.println("<br>Person Qualification:: <br>"+ply);
		pw.println("<br>Languages u known:: <br>"+Arrays.toString(lang));
		pw.println("<br>hobbies:: <br>"+Arrays.toString(hob));
		pw.println("<br>Date Of Birth:: <br>"+dob);
		pw.println("<br>Time Of Birth:: <br>"+tob);
		pw.println("<br>Week of birth::<br>"+wnb);
		pw.println("<br>Month of birth:: <br>"+mob);
		pw.println("<br>Mobile Number:: <br>"+m);
		pw.println("<br>Favorite Number:: <br>"+fn);
		pw.println("<br>email id:: <br>"+email);
		pw.println("<br>Favorite Colour:: <br>"+fc);
		pw.println("<br>Facebook url:: <br>"+url);
		pw.println("<br>Favorite Google Search:: <br>"+fgs);
		pw.println("<br>Your Annual Income Is:: <br>"+income);
	pw.println("<br><a href=form.html</a><br>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
