package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SectionBean;
import dao.SectionDao;

@WebServlet("/Search_Servlet")
public class Search_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Search_Servlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = (String) request.getAttribute("userName");

	        String view = "/WEB-INF/view/Search.jsp";
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 文字コードの指定
	        request.setCharacterEncoding("utf-8");
	        // formから値を取得

	        SectionBean bean = new SectionBean();
	        SectionDao dao = new SectionDao();
	        List<SectionBean> list = new ArrayList<SectionBean>();

	        String name = (String)request.getParameter("name");//企業名
	        request.setAttribute("companyname", name);

	        String industry = (String)request.getParameter("industry");//業種
	        request.setAttribute("industry", industry);

	        String occupation = (String)request.getParameter("occupation");//職種
	        request.setAttribute("occupation",occupation);

	        String area = (String)request.getParameter("area");//エリア
	        request.setAttribute("area",area);

	        String year = (String)request.getParameter("year");//年度
	        request.setAttribute("year",year);
	        if(year.equals("指定なし")){
	        	year = "0";
	        }

	        String acceptance = (String)request.getParameter("acceptance");//合否
	        request.setAttribute("acceptance",acceptance);

	        String department = (String)request.getParameter("department");//学科
	        request.setAttribute("Department", department);


	        switch(department){							//コース
	        	case "情報システム科":
	        		String course1 = (String)request.getParameter("course1");
	        		request.setAttribute("course", course1);
	        		  bean.setCourse(course1);
	        		break;
	        	case "ネットワークセキュリティ科":
	        		String course2 = (String)request.getParameter("course2");
	        		request.setAttribute("course", course2);
	        		  bean.setCourse(course2);
	        		break;
	        	case "総合システム工学科":
	        		String course3 = (String)request.getParameter("course3");
	        		request.setAttribute("course", course3);
	        		  bean.setCourse(course3);
	        		break;
	        	case "高度情報工学科":
	        		String course4 = (String)request.getParameter("course4");
	        		request.setAttribute("course", course4);
	        		  bean.setCourse(course4);
	        		break;
	        	case "情報ビジネス科":
	        		String course5 = (String)request.getParameter("course5");
	        		request.setAttribute("course", course5);
	        		  bean.setCourse(course5);
	        		break;
	        	case "会計ビジネス科":
	        		String course6 = (String)request.getParameter("course6");
	        		request.setAttribute("course", course6);
	        		  bean.setCourse(course6);
	        		break;
	        	case "デザイン科":
	        		String course7 = (String)request.getParameter("course7");
	        		request.setAttribute("course", course7);
	        		  bean.setCourse(course7);
	        		break;
	        	case "総合デザイン科":
	        		String course8 = (String)request.getParameter("course8");
	        		request.setAttribute("course", course8);
	        		  bean.setCourse(course8);
	        		break;
	        	default:
	        		request.setAttribute("course", "指定なし");
	        		  bean.setCourse("指定なし");
	        };
	        bean.setCompany(name);
	        bean.setArea(area);
	        bean.setDepartment(department);
	        bean.setYear(Integer.parseInt(year));
	        bean.setIndustry(industry);
	        bean.setOccupations(occupation);
	        bean.setSof(acceptance);

	        String view = null;
	        if(request.getParameter("pagename").equals("return") == true){
	        	view ="/WEB-INF/view/Menu.jsp";

	        }

	        else if(request.getParameter("pagename").equals("search") == true){
	        	view = "/WEB-INF/view/Result.jsp";
	        	list = dao.find(bean);
	        	request.setAttribute("list", list);
	        }
	        

	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

}