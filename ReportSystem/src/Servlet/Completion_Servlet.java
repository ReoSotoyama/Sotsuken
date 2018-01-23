package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Completion_Servlet")
public class Completion_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Completion_Servlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = (String) request.getAttribute("userName");

	        String view = "/WEB-INF/view/Login.jsp";
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 String view = null;
	    	// 文字コードの指定
	    	 System.out.println("aaaa");
	        request.setCharacterEncoding("utf-8");

	        if (request.getParameter("pagename").equals("login") == true){

	        view = "/WEB-INF/view/Login.jsp";
	        }
	        else if (request.getParameter("pagename").equals("menu") == true){
	        	view = "/WEB-INF/view/Menu.jsp";
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }


}