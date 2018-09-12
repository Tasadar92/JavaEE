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
		Double op1 = null;
		Double op2 = null;
		Double result = null;
		String error = null; String s = null; String blanc1 = null; String blanc2 = null;
		
		switch (op) {
		case "suma":
			
			try {
				s = request.getParameter("op1");
				op1 = Double.parseDouble(s);
				
			}catch (Exception e) {
				blanc1 = e.getMessage();
			}			
			
			try {
				s = request.getParameter("op2");
				op2 = Double.parseDouble(s);
			}catch (Exception e) {
				blanc2 = e.getMessage();
			}
			
			Suma_DAO sum;
			
			if(blanc1 == null && blanc2 == null) {
				sum = new Suma_DAO(op1, op2);			
				result = sum.operar();	
			}

			break;

		case "resta":
			
			try {
				s = request.getParameter("op1");
				op1 = Double.parseDouble(s);
				
			}catch (Exception e) {
				blanc1 = e.getMessage();
			}			
			
			try {
				s = request.getParameter("op2");
				op2 = Double.parseDouble(s);
			}catch (Exception e) {
				blanc2 = e.getMessage();
			}
			
			Resta_DAO r;
			
			if(blanc1 == null && blanc2 == null) {
				r = new Resta_DAO(op1, op2);			
				result = r.operar();
			}
			
			break;
		
		case "multi":
			
			try {
				s = request.getParameter("op1");
				op1 = Double.parseDouble(s);
				
			}catch (Exception e) {
				blanc1 = e.getMessage();
			}			
			
			try {
				s = request.getParameter("op2");
				op2 = Double.parseDouble(s);
			}catch (Exception e) {
				blanc2 = e.getMessage();
			}
			
			Multiplicacion m;
			
			if(blanc1 == null && blanc2 == null) {
				m = new Multiplicacion(op1, op2);			
				result = m.operar();
			}
			
			break;
			
		case "div":
			
			try {
				s = request.getParameter("op1");
				op1 = Double.parseDouble(s);
				
			}catch (Exception e) {
				blanc1 = e.getMessage();
			}			
			
			try {
				s = request.getParameter("op2");
				op2 = Double.parseDouble(s);
			}catch (Exception e) {
				blanc2 = e.getMessage();
			}
			
			Division_DAO d;
			
			if(blanc1 == null && blanc2 == null) {
				d = new Division_DAO(op1, op2);
				
				try {
					result = d.operar();
				}catch (Exception e) {
					// TODO: handle exception
					error = e.getMessage();
					
				}
			}
			
			break;
		}
		
		if(error != null)
			request.setAttribute("result", error);
		else {
			if(blanc1 != null && blanc2 != null) {
				request.setAttribute("blanc1", "Entrez un opérande");
				request.setAttribute("blanc2", "Entrez un opérande");
			}else
				if(blanc1 != null)
					request.setAttribute("blanc1", "Entrez un opérande");
				else
					if(blanc2 != null)
						request.setAttribute("blanc2", "Entrez un opérande");
			
			request.setAttribute("result", result);
		}
		
		request.getRequestDispatcher("/WEB-INF/FormCalc.jsp").forward(request, response);
		
	}

}
