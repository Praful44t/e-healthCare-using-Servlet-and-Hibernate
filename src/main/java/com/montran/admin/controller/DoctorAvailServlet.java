package com.montran.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montran.admin.dao.FacultyDAO;
import com.montran.admin.model.Faculty;


@WebServlet("/availDoc")
public class DoctorAvailServlet extends HttpServlet{
	private static final long serialVersionUID = 1374485972630411453L;
	private FacultyDAO facultyDao;
	
	public void init() {
			facultyDao = new FacultyDAO();	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = false;
		String password = request.getParameter("password");
		boolean value = Boolean.parseBoolean(request.getParameter("available"));
		Faculty faculty = facultyDao.searchFacultyByPass(password);
		status = facultyDao.docAvail(value, faculty);
	
    	if(status)	{
    		HttpSession session = request.getSession();
			session.setAttribute("admin_name","Praful");
            request.getRequestDispatcher("success/docSuccessPage.jsp").forward(request, response);
    	}
    	else	{
    		HttpSession session = request.getSession();
			session.setAttribute("admin_name","Praful");
            request.getRequestDispatcher("success/docSuccessPage.jsp").forward(request, response);
    	}
        }
}
