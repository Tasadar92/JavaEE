package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.Division_DAO;
import com.sopra.dao.Multiplicacion;
import com.sopra.dao.Resta_DAO;
import com.sopra.dao.Suma_DAO;

/**
 * Servlet implementation class Calculadora
 */
@WebServlet("/Calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculadora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/FormCalc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("operacion");
		Double op1;
		Double op2;
		Double result = null;
		String error = null;
		
		switch (op) {
		case "suma":
			
			op1 = Double.parseDouble(request.getParameter("op1"));
			op2 = Double.parseDouble(request.getParameter("op2"));
			
			Suma_DAO s = new Suma_DAO(op1, op2);
			
			result = s.operar();			

			break;

		case "resta":
			
			op1 = Double.parseDouble(request.getParameter("op1"));
			op2 = Double.parseDouble(request.getParameter("op2"));
			
			Resta_DAO r = new Resta_DAO(op1, op2);
			
			result = r.operar();
			
			break;
		
		case "multi":
			
			op1 = Double.parseDouble(request.getParameter("op1"));
			op2 = Double.parseDouble(request.getParameter("op2"));
			
			Multiplicacion m = new Multiplicacion(op1, op2);
			
			result = m.operar();
			
			break;
			
		case "div":
			
			op1 = Double.parseDouble(request.getParameter("op1"));
			op2 = Double.parseDouble(request.getParameter("op2"));
			
			Division_DAO d = new Division_DAO(op1, op2);
			
			try {
				result = d.operar();
			}catch (Exception e) {
				// TODO: handle exception
				error = e.getMessage();
				
			}
			
			break;
		}
		
		if(error != null)
			request.setAttribute("result", error);
		else
			request.setAttribute("result", result);
		
		request.getRequestDispatcher("/WEB-INF/FormCalc.jsp").forward(request, response);
		
	}

}
