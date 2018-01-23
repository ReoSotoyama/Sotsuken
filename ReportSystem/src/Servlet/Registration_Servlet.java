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

@WebServlet("/Registration_Servlet")
public class Registration_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Registration_Servlet() {
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



	        // formから値を取得
	        if (request.getParameter("pagename").equals("registration") == true){
	        	EmployeeBean bean = new EmployeeBean();
		        bean.setId(Integer.parseInt(request.getParameter("number")));
		        bean.setName(request.getParameter("user"));
		        bean.setDepartment(request.getParameter("department"));
		        bean.setX(request.getParameter("gakunen"));
		        bean.setPass(request.getParameter("pass"));
		        bean.setAddress(request.getParameter("mail"));

		        switch(request.getParameter("department")){

		        case "情報システム科":
		        	bean.setCourse(request.getParameter("course"));
		        	break;
		        case "ネットワークセキュリティ科":
		        	bean.setCourse(request.getParameter("course1"));
		        	break;
		        case "総合システム工学科":
		        	bean.setCourse(request.getParameter("course2"));
		        	break;
		        case "高度情報工学科":
		        	bean.setCourse(request.getParameter("course3"));
		        	break;
		        case "情報ビジネス科":
		        	bean.setCourse(request.getParameter("course4"));
		        	break;
		        case "会計ビジネス科":
		        	bean.setCourse(request.getParameter("course5"));
		        	break;
		        case "デザイン科":
		        	bean.setCourse(request.getParameter("course6"));
		        	break;
		        case "総合デザイン科":
		        	bean.setCourse(request.getParameter("course7"));
		        	break;
		        }

		        EmployeeDao dao = new EmployeeDao();

		        dao.insert(bean);
	        view = "/WEB-INF/view/Completion.jsp";
	        }
	        else if (request.getParameter("pagename").equals("back") == true){
	        view =	"/WEB-INF/view/Login.jsp";
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }
}