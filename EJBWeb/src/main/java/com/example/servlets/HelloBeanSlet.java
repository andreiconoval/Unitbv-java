package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.StatelessEjbRemote;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloBeanSlet
 */
@WebServlet("/HelloBeanSlet")
public class HelloBeanSlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloBeanSlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	     InitialContext context;
		try {
			context = new InitialContext();
			StatelessEjbRemote firstejb = (StatelessEjbRemote) context
	    		 .lookup("java:global/EJBEar/EJBBean/StatelessEjb!com.example.StatelessEjbRemote");
			
			String str =  firstejb.sayHello();
			// firstejb.insert("Andrei");
			response.setContentType("text/htm");
			PrintWriter out = response.getWriter();
			
			out.print(str);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
