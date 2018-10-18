package com.inutech.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inutech.dao.AnneeAcademiqueDao;
import com.inutech.dao.OptionDao;
import com.inutech.model.AnneeAcademique;
import com.inutech.model.Option;

/**
 * Servlet implementation class OpServlet
 */
@WebServlet("/OpServlet")
public class OpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OptionDao dao=new OptionDao();
        //EtudiantDao etudiant=new EtudiantDao();
		String action=request.getParameter("operation");
		
	        if(action.equalsIgnoreCase("ADD")){
	        	String desc=request.getParameter("desc");
	        	String code=request.getParameter("code");
	            dao.addOption(new Option(desc,code));
	            response.sendRedirect("restraint/Option.jsp");
	        }
	        if(action.equalsIgnoreCase("REMOVE")){
	        	int i=Integer.parseInt(request.getParameter("idm"));
	        	dao.removeOption(i);
	            response.sendRedirect("restraint/Option.jsp");
	        }
	        if(action.equalsIgnoreCase("UPDATE")){
	        	int i=Integer.parseInt(request.getParameter("idm"));
	        	String desc=request.getParameter("descm");
	        	String code=request.getParameter("codem");
	        	dao.updateOption(new Option(i,desc,code));
	            response.sendRedirect("restraint/Option.jsp");
	        }
	        if(action.equalsIgnoreCase("FIND")){
	        	int i=Integer.parseInt(request.getParameter("idseach"));
	        	Option y=dao.findOption(i);
	        	request.setAttribute("seach",y);
	            response.sendRedirect("restraint/Option.jsp");
	        }
	}

}
