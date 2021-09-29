package com.montran.client.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montran.client.dao.UserDAO;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet{
	private static final long serialVersionUID = 1374485972630411453L;
	private UserDAO userDao;
	
	public void init() {
		userDao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = false;
		int rid = Integer.parseInt(request.getParameter("room-no"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		if (userDao.roomStatus(rid))
			status = userDao.roomBooking(rid,pid);
		System.out.println(status);
        if(status)	{
        	HttpSession session = request.getSession();
    		session.setAttribute("admin_name","Praful");
            request.getRequestDispatcher("success/userPageSuccess.jsp").forward(request, response);
        }
        else	{
        	HttpSession session = request.getSession();
    		session.setAttribute("admin_name","Praful");
            request.getRequestDispatcher("error/userPageError.jsp").forward(request, response);
        }
    }
}
