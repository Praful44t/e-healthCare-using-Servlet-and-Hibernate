package com.montran.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.montran.admin.dao.AdminDAO;

@WebServlet("/loginAdmin")
public class LoginAdmin extends HttpServlet{
	private static final long serialVersionUID = -7699387501488419273L;
	private AdminDAO adminDao;
	
	public void init() {
			adminDao = new AdminDAO();	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mailid = request.getParameter("mailid");
		String password = request.getParameter("password");

		try {
			if (adminDao.validate(mailid,password)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("admin_name",mailid);
	            request.getRequestDispatcher("success/adminPage.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("error/loginError.jsp");
				
			}
		} catch (Exception e) {
			response.sendRedirect("error/loginError.jsp");
		}
	}
	
}
