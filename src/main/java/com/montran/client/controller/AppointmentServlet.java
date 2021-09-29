package com.montran.client.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montran.admin.model.Faculty;
import com.montran.client.dao.UserDAO;
import com.montran.client.model.Appointment;
import com.montran.client.model.User;

@WebServlet("/appointment")
public class AppointmentServlet extends HttpServlet{
	private static final long serialVersionUID = 1374485972630411453L;
	private UserDAO userDao;;
	
	public void init() {
		userDao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = false;
		String date = request.getParameter("doa");
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate= LocalDate.parse(date,formatter);
		String docName = request.getParameter("doctor");
		String[] docFullName = docName.split("\\s+");
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		Faculty faculty = new Faculty();
		User user = new User();
		try {
			faculty = userDao.getDoctor(docFullName[0], docFullName[1]);
			user = userDao.getUserById(uid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Appointment appointment = new Appointment();
		appointment.setDate(localDate);
		appointment.setFaculty(faculty);
		appointment.setUser(user);
		status = userDao.addAppointment(appointment);

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
