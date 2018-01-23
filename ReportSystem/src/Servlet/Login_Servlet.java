package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import util.DbManager;

@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static int id = 0;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Login_Servlet() {
	        super();
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String view = "/WEB-INF/view/Login.jsp";
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 String view = null;
	    	 EmployeeDao dao = new EmployeeDao();
	    	 dao.findAll();
	    	// 文字コードの指定
	        request.setCharacterEncoding("utf-8");

	        if (request.getParameter("pagename").equals("login") == true){
	        // formから値を取得
	        try{
	        	id = Integer.parseInt(request.getParameter("Id"));
	        }catch (NumberFormatException e){
	        	System.out.println("IDに文字列を入れられるとExceptionを吐くよ");
	        }
	        String ps = (String)request.getParameter("pass");

	        boolean check;
	        check = authUser(id,ps);

	        		if(check){
	        			request.setAttribute("userNumber", id);
	        			request.setAttribute("userPass", ps);
	        			view = "/WEB-INF/view/Menu.jsp";
	        		}
	        		else{
	        			view = "/WEB-INF/view/Login.jsp";
	        			request.setAttribute("error", "error");
	        		}
	        }
	        else if (request.getParameter("pagename").equals("number") == true){
	        	view = "/WEB-INF/view/Registration.jsp";
	        }
	        else if (request.getParameter("pagename").equals("teach") == true){
	        	view = "/WEB-INF/view/Menu.jsp";
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	        dispatcher.forward(request, response);



	    }

	    protected boolean authUser(int id, String pass){
	    	Connection conn = null;
	        if (id == 0 || pass == null || pass.length() == 0){
	            return false;
	        }

	        try {
	        	conn = DbManager.getConnection();
	            String sql = "SELECT * FROM user WHERE 学籍番号 = ? && パスワード = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);

	            pstmt.setInt(1, id);
	            pstmt.setString(2, pass);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()){
//	                int userid = rs.getInt("学籍番号");
//	                String username = rs.getString("ユーザー名");

	                return true;
	            }else{
	                return false;
	            }
	        }catch (SQLException e){
	            log("SQLException:" + e.getMessage());
	            return false;
	        }
	    }

}
