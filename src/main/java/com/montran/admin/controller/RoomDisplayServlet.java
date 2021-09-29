package com.montran.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montran.admin.dao.AdminDAO;

@WebServlet("/roomDisplay")
public class RoomDisplayServlet extends HttpServlet{
	private static final long serialVersionUID = 1374485972630411453L;
	private AdminDAO adminDao;
	
	public void init() {
			adminDao = new AdminDAO();	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Long> list = new ArrayList<>();
		
		try {
			 list.addAll(adminDao.roomDisplay());
		} catch (Exception e) {
			e.printStackTrace();
		}
		long n1 = list.get(0);
		long n2 = list.get(1);
		HttpSession session = request.getSession();
		session.setAttribute("avail_room", n1);
		session.setAttribute("unavail_room", n2);
		request.getRequestDispatcher("success/adminRoomShow.jsp").forward(request, response);
	}
}
