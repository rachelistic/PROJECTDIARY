package co.rachel.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.test.dao.TestDao;
import co.rachel.test.encryption.Encryption;
import co.rachel.test.vo.TestVo;

/**
 * Servlet implementation class InsertUser
 */
@WebServlet("/InsertUser.do")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		TestDao dao = new TestDao();
		TestVo vo = new TestVo();
		Encryption enc = new Encryption();
		String str;
		String encStr;
		
		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo.setPassword(request.getParameter("pw"));
		
		str = request.getParameter("pw");
		encStr = enc.encrypto(str);
		
		System.out.println(encStr);
		
		vo.setEncryptionpassword(encStr);
		
		
		
		int n = dao.insert(vo);
		/* String viewPage; */
		if(n!=0) {
			
			response.sendRedirect("loginResult.jsp");
			System.out.println("서블렛에서 등록되었습니당");

			/*
			 * String msg = request.getParameter("id") + "님의 정보를 데이터 베이스에 입력하였습니다.";
			 * request.setAttribute("msg",msg); viewPage = "/Test/loginResult.jsp";
			 * RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			 * dispatcher.forward(request, response);
			 */
		}else {
			System.out.println("서블렛에서 등록 실패!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
