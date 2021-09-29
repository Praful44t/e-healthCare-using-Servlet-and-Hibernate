package com.montran.client.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.montran.client.dao.UserDAO;
import com.montran.client.model.User;
import com.montran.util.PasswordEncrypt;


@WebServlet("/registerUser")
public class RegistryUser extends HttpServlet{
	private static final long serialVersionUID = 7441358059227870976L;
	private UserDAO userDao;
	
	public void init() {
		userDao = new UserDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = false;
		
		
		
		String mailid = request.getParameter("mailid");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String key = "1";
        String passwordEncrypt = null;
		try {
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
        
        User user = new User();
  
        user.setFname(firstName);
        user.setLname(lastName);
        user.setAge(age);
        user.setGender(gender);
        user.setMailid(mailid);
        user.setPassword(passwordEncrypt);
        try {
			status = userDao.addUser(user);
		} catch (Exception e) {
			response.sendRedirect("error/registryError.jsp");
		}
        if(status)	response.sendRedirect("success/registrySuccess.jsp");
        else	response.sendRedirect("error/registryError.jsp");
	}
}	
