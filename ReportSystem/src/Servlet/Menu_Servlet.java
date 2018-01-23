package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Menu_Servlet")
public class Menu_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Menu_Servlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	request.setCharacterEncoding("utf-8");

	    	String number = (String) request.getAttribute("userNumber");
	        String view = "/WEB-INF/view/Menu.jsp";
	        System.out.println(number);
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 文字コードの指定
	    	String view = null;
	        request.setCharacterEncoding("utf-8");

	        if (request.getParameter("pagename").equals("search") == true){
	        	view = "/WEB-INF/view/Search.jsp";

	        }

	        else if (request.getParameter("pagename").equals("report") == true){
	        	Login_Servlet ls = new Login_Servlet();
	        	request.setAttribute("userNumber", ls.id);
	        	view = "/WEB-INF/view/Reporting.jsp";
	        }

	        else if (request.getParameter("pagename").equals("mypage") == true){
	        	view = "/WEB-INF/view/MyPage.jsp";
	        }
	        else if(request.getParameter("pagename").equals("back")){
	        	view ="/WEB-INF/view/Login.jsp";
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

}
