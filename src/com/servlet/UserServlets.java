package com.servlet;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.java.User;

/**
 * Servlet implementation class UserServlets
 */
@WebServlet("/UserServlets")
public class UserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String operFlag = request.getParameter("operFlag");
		if ("getAllUSer".equals(operFlag)) {
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/user?user=root&password=123&userUnidcode=true&characterEncoding=UTF8");
				Statement statement = conn.createStatement();
				ResultSet resultSet=statement.executeQuery("SELECT * FROM users");
				List<User> userlist =new ArrayList<>();
				while(resultSet.next()){
					User user =new User();
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("name"));
					user.setPassword(resultSet.getString("password"));
					user.setNickName(resultSet.getString("nickName"));
					
					userlist.add(user);
				}
				
				
				PrintWriter out = response.getWriter();
				out.print(new Gson().toJson(userlist));
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
