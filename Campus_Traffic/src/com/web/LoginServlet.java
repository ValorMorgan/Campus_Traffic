package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String LOGIN_ID_DEF = "admin";
    private static final String LOGIN_PASS_DEF = "hcf";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		
		if(loginId.equals(LOGIN_ID_DEF) && loginPass.equals(LOGIN_PASS_DEF)) {
			this.getServletContext().getRequestDispatcher("/jsp/admin/admin.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/Logon/login.jsp").forward(request, response);
		}
	}
}
