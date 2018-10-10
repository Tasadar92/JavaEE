package com.urjc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.python.util.PythonInterpreter;

import com.urjc.conection.ConexionJavaPython;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index" )
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public static final String VIEW_SINGLE = "/singleURL.jsp";
    public static final String VIEW_MULTIPLE = "/multipleURL.jsp";
    public static final String VIEW_FORM   = "/index.jsp";
    public static final String OPTION = "option";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
    	
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Pre-charge
		/*ConexionJavaPython conexion = new ConexionJavaPython();
		PythonInterpreter interpreter = new PythonInterpreter();*/
		
		this.getServletContext().getRequestDispatcher( VIEW_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opt = request.getParameter(OPTION);
		
		if(opt.equals("singleURL"))
			request.getRequestDispatcher(VIEW_SINGLE).forward(request, response);
		
		if(opt.equals("multipleURL"))
			request.getRequestDispatcher(VIEW_MULTIPLE).forward(request, response);
	}

}
