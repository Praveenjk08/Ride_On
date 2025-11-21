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

@WebServlet("/edit1")
public class EditSingleUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDao udao=null;
	public EditSingleUserServlet() {
		udao=new UserDaoImlimaenation();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid=Integer.parseInt(req.getParameter("e1"));
		User user=udao.getSingleUserDetails(uid);
		if(user!=null)
		{
			req.setAttribute("editusers", user);
			req.getRequestDispatcher("EditSingleUserForm.jsp").forward(req, resp);
		}
		
	}

}
