package com.servlet.controller;

import java.io.IOException;
import java.net.HttpRetryException;

import com.servlet.Dao.UserDao;
import com.servlet.Dao.UserDaoImlimaenation;
import com.servlet.Dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update1")
public class Update1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDao udao=null;
	public Update1Servlet() {
		udao=new UserDaoImlimaenation();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int umpid=Integer.parseInt(req.getParameter("uid"));
		System.out.println(umpid);
		String uname=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		long ph=Long.parseLong(req.getParameter("ph"));
		
		User user=new User();
		user.setU_id(umpid);
		user.setFullname(uname);
		user.setEmail(email);
		user.setPass(pass);
		user.setPhone(ph);
		
		boolean update=udao.udateSingleUserData(user);
		if(update==true)
		{
//		req.getRequestDispatcher("viewuser1").forward(req, resp);
//			resp.sendRedirect("viewuser1?view"+ umpid);
			resp.sendRedirect("viewuser1?view=" + umpid);
		}
		
	}

}
