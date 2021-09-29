package com.montran.client.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montran.client.dao.UserDAO;
import com.montran.client.model.User; 


@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet{
	private static final long serialVersionUID = -8959766377137273290L;
	private UserDAO userDao;
	
	public void init() {
		userDao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String mailid = request.getParameter("mailid");
		String password = request.getParameter("password");



		try {
				if(userDao.validateUser(mailid,password)) {
					User userDetails = userDao.searchUser(mailid,password);
					HttpSession session = request.getSession();
					session.setAttribute("firstName",userDetails.getFname());
					session.setAttribute("lastName",userDetails.getLname());
					session.setAttribute("age",userDetails.getAge());
		            request.getRequestDispatcher("success/userPage.jsp").forward(request, response);
				}
			
				else {
				response.sendRedirect("error/loginError.jsp");
				}
			}
	    catch (Exception e) {
			e.printStackTrace();
		}
	}
}
