package com.servlet.controller;

import java.io.IOException;

import com.servlet.Dao.UserDao;
import com.servlet.Dao.UserDaoImlimaenation;
import com.servlet.Dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewuser1")
public class ViewSingleUserDetails extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao udao=null;
	public ViewSingleUserDetails() {
	udao=new UserDaoImlimaenation();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid=Integer.parseInt(req.getParameter("view"));
		User user=udao.getSingleUserDetails(uid);
		if(user!=null)
		{
			HttpSession session=req.getSession();
			
		      req.setAttribute("userrod", user);
			req.getRequestDispatcher("SingleUserDetails.jsp").forward(req, resp);
		}
		
		
	}

}
