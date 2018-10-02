package com.urjc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urjc.dto.URL;
import com.urjc.forms.SingleURLForm;

/**
 * Servlet implementation class SingleURL
 */
@WebServlet("/SingleURL")
public class SingleURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String ATT_URL = "url";
	public static final String ATT_FORM   = "form";
    
    public static final String VIEW_SUCCESS = "/processedURL.jsp";
    public static final String VIEW_FORM   = "/singleURL.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleURL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VIEW_FORM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		/* Set up of the form object */
        SingleURLForm form = new SingleURLForm();

        /* Processing the query and retrieving the resulting bean */
        URL url = form.createURL(request);
        
        /* Adding the Bean and the Business Object to the Query Object */
        request.setAttribute(ATT_URL, url);
        request.setAttribute(ATT_FORM, form);
        
        if (form.getErreurs().isEmpty()) {
        	this.getServletContext().getRequestDispatcher(VIEW_SUCCESS).forward(request, response);
        }else
        	this.getServletContext().getRequestDispatcher(VIEW_FORM).forward(request, response);
	}

}
