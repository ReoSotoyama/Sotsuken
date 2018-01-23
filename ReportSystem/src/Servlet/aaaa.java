package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeBean;
import dao.EmployeeDao;

@WebServlet("/aaaa_Servlet")
public class aaaa extends HttpServlet{
	private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public aaaa() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	EmployeeDao dao = new EmployeeDao();
	        List<EmployeeBean> list = dao.findAll();
	        request.setAttribute("list", list);

	        String view = "/WEB-INF/view/Registration.jsp";
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	        String view = null;
	    	// 文字コードの指定
	        request.setCharacterEncoding("utf-8");

	        System.out.println(request.getParameter("gakunen"));


	        // formから値を取得
	        if (request.getParameter("pagename").equals("registration")){
	        	 EmployeeBean bean = new EmployeeBean();
	 	        bean.setId(Integer.parseInt(request.getParameter("number")));
	 	        bean.setName(request.getParameter("user"));
	 	        bean.setDepartment(request.getParameter("department") );
	 	        bean.setCourse( request.getParameter("course") ) ;
	 	        bean.setX(request.getParameter("gakunen"));
	 	        bean.setPass(request.getParameter("pass"));
	 	        bean.setAddress(request.getParameter("mail"));

	 	        EmployeeDao dao = new EmployeeDao();

	 	        dao.insert(bean);
	        view = "/WEB-INF/view/Completion.jsp";
	        }
	        else if (request.getParameter("pagename").equals("back")){
	        view =	"/WEB-INF/view/Login.jsp";
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }


}
