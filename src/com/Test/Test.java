package com.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DAO.UserDAO;
import com.google.gson.Gson;
import com.java.User;

public class Test {

	@org.junit.Test
	public void test() throws Exception {
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
		String gson = new Gson().toJson(userlist);
		System.out.println(userlist);
	}
	@org.junit.Test
   public void update() throws Exception{
	   UserDAO userDAO = new UserDAO();
	   User user = new User();
	   user.setId(2);
	   user.setName("bb");
	   user.setPassword("aaqq.com");
	   user.setNickName("aa");
	 
	   boolean flag = userDAO.editUser(user);
	   if (flag == true) {
		System.out.println("ok");
	}else{
		System.out.println("error");
	}
   }
}
