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

@WebServlet("/LoginFaculty")
public class LoginFaculty extends HttpServlet{
	private static final long serialVersionUID = 2388592269352325906L;
	private FacultyDAO facultyDao;
	
	public void init() {
			facultyDao = new FacultyDAO();	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mailid = request.getParameter("mailid");
		String password = request.getParameter("password");

		try {
				if(facultyDao.validateFaculty(mailid,password)) {
					Faculty facultyDetails = facultyDao.searchFaculty(mailid,password);
					HttpSession session = request.getSession();
					session.setAttribute("fname",facultyDetails.getFname());
					session.setAttribute("lname",facultyDetails.getLname());
					session.setAttribute("age",facultyDetails.getAge());
					session.setAttribute("phone",facultyDetails.getPhone());
					session.setAttribute("sessions",facultyDetails.getSessions());
					session.setAttribute("fees",facultyDetails.getFees());
					session.setAttribute("available",facultyDetails.isAvailable());
		            request.getRequestDispatcher("success/doctorPage.jsp").forward(request, response);
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
