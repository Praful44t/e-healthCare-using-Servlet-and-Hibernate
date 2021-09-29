package com.montran.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.montran.admin.dao.FacultyDAO;
import com.montran.admin.model.Faculty;
import com.montran.util.PasswordEncrypt;



@WebServlet("/registerEmp")
public class RegistryFaculty extends HttpServlet{
	private static final long serialVersionUID = -7601685754234126946L;
	private FacultyDAO facultyDao;

	public void init() {
			facultyDao = new FacultyDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean status = false;
		String mailid = request.getParameter("mailid");
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String key = "1";
        String passwordEncrypt = null;
		try {
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
        Faculty faculty = new Faculty();
  
        faculty.setFname(fname);
        faculty.setLname(lname);
        faculty.setAge(age);
        faculty.setPhone(phone);
        faculty.setMailid(mailid);
        faculty.setPassword(passwordEncrypt);
        try {
			status = facultyDao.addFaculty(faculty);
        } catch (Exception e) {
				e.printStackTrace();
		}
        	
        if(status)	response.sendRedirect("success/registrySuccess.jsp");
        else	response.sendRedirect("error/registryError.jsp");
        
       
                  
	}
}
