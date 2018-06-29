package com.DAO;

import java.sql.SQLException;


import org.apache.commons.dbutils.QueryRunner;

import com.java.User;
import com.utils.DBUTILS;

public class UserDAO {
QueryRunner queryRunner = new QueryRunner(DBUTILS.getDataSource());

public boolean editUser(User user) throws Exception{
	String sql = "update users set name=?,password=?,nickname=? where id=?";
	Object[] params = {user.getName(),user.getPassword(),user.getNickName(),user.getId()};
	queryRunner.update(sql, params);
	return true;
}
}
