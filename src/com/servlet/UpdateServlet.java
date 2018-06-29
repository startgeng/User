package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.DAO.UserDAO;

import com.java.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter writer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String account = request.getParameter("user");
	  String name = request.getParameter("name");
	  String password = request.getParameter("password");
	  String nickName = request.getParameter("nickName");
	  UserDAO userDAO = new UserDAO();
	  User user = new User();
	  int a = Integer.parseInt(account);
	  user.setId(a);
	  user.setName(name);
	  user.setNickName(nickName);
	  user.setPassword(password);
	 
	  PrintWriter out = response.getWriter();
	  try {
		boolean flag = userDAO.editUser(user);
		if (flag == true) {
		
		out.print("ok");
		}else {
		out.print("error");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
