package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SectionBean;
import dao.SectionDao;

@WebServlet("/Report_Servlet")
public class Report_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	  int x = 0;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Report_Servlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = (String) request.getAttribute("userName");


	        System.out.println("Report_ServletのGetメソッドが呼び出されました");
	        String view = "/WEB-INF/view/Reporting.jsp";
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


	        String view = null;
	        if(request.getParameter("pagename").equals("back")){
	        	view ="/WEB-INF/view/Menu.jsp";
	        }

	        else if(request.getParameter("pagename").equals("registration")){
	        	request.setCharacterEncoding("utf-8");

	        	Login_Servlet ls = new Login_Servlet();
		        SectionBean bean = new SectionBean();

		        String phone = null;
		        try{
		        String	c = (String)request.getParameter("phone");
		        String	a =(String)request.getParameter("phone1");
		        String  b =(String)request.getParameter("phone2");

		        phone = c+a+b;

		        int aaa = Integer.parseInt(phone);

		        }catch(NumberFormatException e){
		        	System.out.println(phone);
		        }
		        phone = request.getParameter("phone") + request.getParameter("phone1") + request.getParameter("phone2");
		        int aaa = Integer.parseInt(phone);
		        int time = 0;
		        String d = request.getParameter("mouth") + request.getParameter("day");
		        time = Integer.parseInt(d);

		        SectionDao dao = new SectionDao();

		        System.out.println(request.getParameter("location"));
		        System.out.println(request.getParameter("paper"));

		        bean.setId(ls.id);
		        bean.setName(request.getParameter("name"));
		        bean.setDepartment(request.getParameter("department") );
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
		        //bean.setCourse( request.getParameter("course") ) ;
		        bean.setCompany(request.getParameter("company"));

		        bean.setPhone(aaa);
		        bean.setLocation(request.getParameter("location"));
		        bean.setIndustry(request.getParameter("industry"));
		        bean.setOccupations(request.getParameter("occupations"));
		        bean.setYear(Integer.parseInt(request.getParameter("year")));

		        bean.setTime(time);
		        bean.setSof(request.getParameter("sof"));
		        bean.setComment1(request.getParameter("coment1"));
		        bean.setComment2(request.getParameter("coment2"));
		        bean.setComment3(request.getParameter("coment3"));

		        String g = request.getParameter("paper");

		        bean.setArea(g);
		        dao.insert(bean);

	        	view = "/WEB-INF/view/Completion_Report.jsp";
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }


}